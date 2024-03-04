package com.example.translateText;


import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;

import com.google.inject.Provides;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import okhttp3.*;
import org.json.JSONObject;


@PluginDescriptor(
        name = "Message Translator",
        description = "Translates text in chat",
        tags = {"chat"}
)
@Slf4j
public class TranslationPlugin extends Plugin implements KeyListener
{
    private static final String TRANSLATE = "Translate";

    @Inject
    ChatMessageManager chatMessageManager;

    @Inject
    private Client client;

    @Inject
    private OkHttpClient httpClient;

    @Inject
    private ClientThread clientThread;

    @Inject
    private KeyManager keyManager;

    @Inject
    private TranslationConfig config;


    @Provides
    TranslationConfig provideConfig(ConfigManager configManager) {
        return (TranslationConfig)configManager.getConfig(TranslationConfig.class);
    }

    @Override
    protected void startUp()
    {
        keyManager.registerKeyListener(this);
    }

    @Override
    protected void shutDown()
    {
        keyManager.unregisterKeyListener(this);
    }

    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {
        if (event.getMenuEntries().length < 2)
        {
            return;
        }

        // Use second entry as first one can be walk here with transparent chatbox
        final MenuEntry entry = event.getMenuEntries()[event.getMenuEntries().length - 2];

        if (entry.getType() != MenuAction.CC_OP_LOW_PRIORITY && entry.getType() != MenuAction.RUNELITE)
        {
            return;
        }

        final int groupId = WidgetUtil.componentToInterface(entry.getParam1());
        final int childId = WidgetUtil.componentToId(entry.getParam1());

        if (groupId != InterfaceID.CHATBOX)
        {
            return;
        }

        final Widget widget = client.getWidget(groupId, childId);
        final Widget parent = widget.getParent();

        if (ComponentID.CHATBOX_MESSAGE_LINES != parent.getId())
        {
            return;
        }

        final int first = WidgetUtil.componentToId(ComponentID.CHATBOX_FIRST_MESSAGE);

        final int dynamicChildIdSender = (childId - first) * 4;
        final int dynamicChildId = (childId - first) * 4 + 1;

        final Widget messageContents = parent.getChild(dynamicChildId);
        final Widget messageOwner = parent.getChild(dynamicChildIdSender);
        if (messageContents == null)
        {
            return;
        }

        String currentMessage = messageContents.getText();
        String messageSender = messageOwner.getText();
        client.createMenuEntry(1)
                .setOption(TRANSLATE)
                .setTarget(entry.getTarget())
                .setType(MenuAction.RUNELITE)
                .onClick(e ->
                {
                    final StringSelection stringSelection = new StringSelection(Text.removeTags(currentMessage));

                    translateTextAsync(currentMessage)
                            .thenAccept(result -> {
                                // Handle the translated text
                                sendChatMessage(messageSender + " " + result.replaceAll("<[^>]*>", ""));
                            })
                            .exceptionally(a -> {
                                a.printStackTrace(); // Handle the error
                                return null;
                            });
                });
    }

    public static class ApiLimitExceededException extends Exception {
        public ApiLimitExceededException(String message) {
            super(message);
        }
    }


    public CompletableFuture<String> translateTextAsync(String originalText) {
        CompletableFuture<String> resultFuture = new CompletableFuture<>();

        String encodedText = URLEncoder.encode(originalText, StandardCharsets.UTF_8);
        String url = "https://api.mymemory.translated.net/get?q=" + encodedText + "&langpair=Autodetect|" + config.LANG().getName();

        if (!config.Email().isBlank())
        {
            url = url + "&de=" + config.Email();
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        clientThread.invoke(() -> {
            httpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    resultFuture.completeExceptionally(e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if (!response.isSuccessful()) {
                            if (response.code() == 429) {
                                resultFuture.completeExceptionally(new ApiLimitExceededException("API usage limit exceeded"));
                            } else {
                                resultFuture.completeExceptionally(new IOException("Unexpected code " + response));
                            }
                            return;
                        }

                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            JSONObject jsonResponse = new JSONObject(responseBody.string());
                            String language = jsonResponse.getJSONObject("responseData").getString("detectedLanguage");
                            String translatedText = jsonResponse.getJSONObject("responseData").getString("translatedText");
                            String result = translatedText + " (" + isLanguageValid(language) + ")";
                            resultFuture.complete(result);
                        } else {
                            resultFuture.completeExceptionally(new IOException("Response body is null"));
                        }
                    } finally {
                        if (response.body() != null) {
                            response.body().close(); // Close the response body
                        }
                    }
                }
            });
        });

        return resultFuture;
    }

    private String isLanguageValid(String code)
    {
        for (Languages enumValue : Languages.values())
        {
            if (enumValue.getName().startsWith(code + "-"))
            {
                return enumValue.getLanguage();
            }
        }
        return null;
    }


    private void sendChatMessage(String chatMessage)
    {
        final String message = new ChatMessageBuilder()
                .append(ChatColorType.HIGHLIGHT)
                .append(chatMessage)
                .build();

        chatMessageManager.queue(
                QueuedMessage.builder()
                        .type(ChatMessageType.CONSOLE)
                        .runeLiteFormattedMessage(message)
                        .build());
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded entry)
    {
    }



    @Override
    public void keyPressed(KeyEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }


}
