package com.example.translateText;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Languages {
    Afrikaans("Afrikaans", "af-ZA"),
    Albanian("Albanian", "sq-AL"),
//    Amharic("Amharic", "am-ET"),
//    Arabic("Arabic", "ar-SA"),
//    Armenian("Armenian", "hy-AM"),
//    Azerbaijani("Azerbaijani", "az-AZ"),
//    Bajan("Bajan", "bjs-BB"),
//    Balkan_Gipsy("Balkan Gipsy", "rm-RO"),
    Basque("Basque", "eu-ES"),
    Bemba("Bemba", "bem-ZM"),
//    Bengali("Bengali", "bn-IN"),
//    Bielarus("Bielarus", "be-BY"),
//    Bislama("Bislama", "bi-VU"),
    Bosnian("Bosnian", "bs-BA"),
//    Breton("Breton", "br-FR"),
//    Bulgarian("Bulgarian", "bg-BG"),
//    Burmese("Burmese", "my-MM"),
    Catalan("Catalan", "ca-ES"),
    Cebuano("Cebuano", "ceb-PH"),
//    Chamorro("Chamorro", "ch-GU"),
//    Chinese_Simplified("Chinese (Simplified)", "zh-CN"),
//    Chinese_Traditional("Chinese Traditional", "zh-TW"),
//    Comorian_Ngazidja("Comorian (Ngazidja)", "zdj-KM"),
//    Coptic("Coptic", "cop-EG"),
//    Creole_English_Antigua_and_Barbuda("Creole English (Antigua and Barbuda)", "aig-AG"),
//    Creole_English_Bahamas("Creole English (Bahamas)", "bah-BS"),
//    Creole_English_Grenadian("Creole English (Grenadian)", "gcl-GD"),
//    Creole_English_Guyanese("Creole English (Guyanese)", "gyn-GY"),
//    Creole_English_Jamaican("Creole English (Jamaican)", "jam-JM"),
//    Creole_English_Vincentian("Creole English (Vincentian)", "svc-VC"),
//    Creole_English_Virgin_Islands("Creole English (Virgin Islands)", "vic-US"),
//    Creole_French_Haitian("Creole French (Haitian)", "ht-HT"),
//    Creole_French_Saint_Lucian("Creole French (Saint Lucian)", "acf-LC"),
//    Creole_French_Seselwa("Creole French (Seselwa)", "crs-SC"),
//    Creole_Portuguese_Upper_Guinea("Creole Portuguese (Upper Guinea)", "pov-GW"),
    Croatian("Croatian", "hr-HR"),
    Czech("Czech", "cs-CZ"),
    Danish("Danish", "da-DK"),
    Dutch("Dutch", "nl-NL"),
//    Dzongkha("Dzongkha", "dz-BT"),
    English("English", "en-GB"),
    Esperanto("Esperanto", "eo-EU"),
    Estonian("Estonian", "et-EE"),
//    Fanagalo("Fanagalo", "fn-FNG"),
    Faroese("Faroese", "fo-FO"),
    Finnish("Finnish", "fi-FI"),
    French("French", "fr-FR"),
    Galician("Galician", "gl-ES"),
//    Georgian("Georgian", "ka-GE"),
    German("German", "de-DE"),
//    Greek("Greek", "el-GR"),
//    Greek_Classical("Greek (Classical)", "grc-GR"),
//    Gujarati("Gujarati", "gu-IN"),
    Hausa("Hausa", "ha-NE"),
//    Hawaiian("Hawaiian", "haw-US"),
//    Hebrew("Hebrew", "he-IL"),
//    Hindi("Hindi", "hi-IN"),
    Hungarian("Hungarian", "hu-HU"),
    Icelandic("Icelandic", "is-IS"),
    Indonesian("Indonesian", "id-ID"),
//    Inuktitut_Greenlandic("Inuktitut (Greenlandic)", "kl-GL"),
    Irish_Gaelic("Irish Gaelic", "ga-IE"),
    Italian("Italian", "it-IT"),
//    Japanese("Japanese", "ja-JP"),
    Javanese("Javanese", "jv-ID"),
    Kabuverdianu("Kabuverdianu", "kea-CV"),
    Kabylian("Kabylian", "kab-DZ"),
//  Kannada("Kannada", "kn-IN"),
//  Kazakh("Kazakh", "kk-KZ"),
//  Khmer("Khmer", "km-KM"),
    Kinyarwanda("Kinyarwanda", "rw-RW"),
    Kirundi("Kirundi", "rn-BI"),
//    Korean("Korean", "ko-KR"),
    Kurdish("Kurdish", "ku-TR"),
//    Kurdish_Sorani("Kurdish Sorani", "ckb-IQ"),
//    Kyrgyz("Kyrgyz", "ky-KG"),
//    Lao("Lao", "lo-LA"),
    Latin("Latin", "la-VA"),
    Latvian("Latvian", "lv-LV"),
    Lithuanian("Lithuanian", "lt-LT"),
    Luxembourgish("Luxembourgish", "lb-LU"),
//    Macedonian("Macedonian", "mk-MK"),
    Malagasy("Malagasy", "mg-MG"),
    Malay("Malay", "ms-MY"),
//    Maldivian("Maldivian", "dv-MV"),
    Maltese("Maltese", "mt-MT"),
//    Manx_Gaelic("Manx Gaelic", "gv-IM"),
    Maori("Maori", "mi-NZ"),
//    Marshallese("Marshallese", "mh-MH"),
//    Mende("Mende", "men-SL"),
//    Mongolian("Mongolian", "mn-MN"),
//    Morisyen("Morisyen", "mfe-MU"),
//    Nepali("Nepali", "ne-NP"),
//    Niuean("Niuean", "niu-NU"),
    Norwegian("Norwegian", "no-NO"),
    Nyanja("Nyanja", "ny-MW"),
//    Pakistani("Pakistani", "ur-PK"),
//    Palauan("Palauan", "pau-PW"),
//    Panjabi("Panjabi", "pa-IN"),
    Papiamentu("Papiamentu", "pap-CW"),
//    Pashto("Pashto", "ps-PK"),
//    Persian("Persian", "fa-IR"),
//    Pijin("Pijin", "pis-SB"),
    Polish("Polish", "pl-PL"),
    Portuguese("Portuguese", "pt-PT"),
//    Potawatomi("Potawatomi", "pot-US"),
//    Quechua("Quechua", "qu-PE"),
    Romanian("Romanian", "ro-RO"),
//    Russian("Russian", "ru-RU"),
    Samoan("Samoan", "sm-WS"),
    Sango("Sango", "sg-CF"),
    Scots_Gaelic("Scots Gaelic", "gd-GB"),
    Serbian("Serbian", "sr-RS"),
    Shona("Shona", "sn-ZW"),
//    Sinhala("Sinhala", "si-LK"),
    Slovak("Slovak", "sk-SK"),
    Slovenian("Slovenian", "sl-SI"),
    Somali("Somali", "so-SO"),
    Sotho_Southern("Sotho, Southern", "st-ST"),
    Spanish("Spanish", "es-ES"),
//    Sranan_Tongo("Sranan Tongo", "srn-SR"),
    Swahili("Swahili", "sw-SZ"),
    Swedish("Swedish", "sv-SE"),
    Swiss_German("Swiss German", "de-CH"),
//    Syriac_Aramaic("Syriac (Aramaic)", "syc-TR"),
    Tagalog("Tagalog", "tl-PH"),
//    Tajik("Tajik", "tg-TJ"),
//    Tamashek_Tuareg("Tamashek (Tuareg)", "tmh-DZ"),
//    Tamil("Tamil", "ta-LK"),
//    Telugu("Telugu", "te-IN"),
//    Tetum("Tetum", "tet-TL"),
//    Thai("Thai", "th-TH"),
//    Tibetan("Tibetan", "bo-CN"),
//    Tigrinya("Tigrinya", "ti-TI"),
    Tok_Pisin("Tok Pisin", "tpi-PG"),
//    Tokelauan("Tokelauan", "tkl-TK"),
//    Tongan("Tongan", "to-TO"),
    Tswana("Tswana", "tn-BW"),
    Turkish("Turkish", "tr-TR"),
    Turkmen("Turkmen", "tk-TM"),
//    Tuvaluan("Tuvaluan", "tvl-TV"),
//    Ukrainian("Ukrainian", "uk-UA"),
    Uma("Uma", "ppk-ID"),
    Uzbek("Uzbek", "uz-UZ"),
//    Vietnamese("Vietnamese", "vi-VN"),
    Wallisian("Wallisian", "wls-WF"),
    Welsh("Welsh", "cy-GB"),
    Wolof("Wolof", "wo-SN"),
    Xhosa("Xhosa", "xh-ZA"),
//    Yiddish("Yiddish", "yi-YD"),
    Zulu("Zulu", "zu-ZA");

    private final String language;
    private final String name;

    @Override
    public String toString()
    {
        return language;
    }

}
