package com.vaccine.card.api.util;

public class StringUtil {

    private StringUtil() {
    }

    public static String removeNonNumericCharacters(String source) {
        return source.replaceAll("\\D", "");
    }
}
