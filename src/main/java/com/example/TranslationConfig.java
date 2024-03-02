package com.example.translateText;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Translation")
public interface TranslationConfig extends Config {
    @ConfigItem(
            name = "Language",
            description = "The language you want to translate text to.",
            position = 1,
            keyName = "LANGO"
    )
    default Languages LANG() {
        return Languages.English;
    }


    @ConfigItem(
            keyName = "Email",
            name = "Usage Limit",
            description = "Supply a valid email for 50000 translated characters daily from mymemory.translated.net",
            hidden = false
    )
    default String Email() {
        return "";
    }
}