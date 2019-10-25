package com.example.sportsbetting.language;

import java.util.Locale;
import java.util.ResourceBundle;

// https://stackoverflow.com/questions/2344483/where-does-resourcebundle-getbundleresourcefile-new-localeus-us-look
// https://github.community/t5/Programming-Help-and-Discussion/java-util-MissingResourceException-in-Java-Program/td-p/20428
// https://www.mkyong.com/java/java-resourcebundle-example/
public class Localization {

    private static Locale locale;

    public static ResourceBundle getLocaleBundle() {
        // Request language resource file from the resources folder based on the name of the folder.
        return ResourceBundle.getBundle("messages", locale);
    }

    public static void setLocale(String language, String country) {
        Localization.locale = new Locale(language, country);
    }

}
