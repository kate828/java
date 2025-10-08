package ua.util;

import java.util.regex.Pattern;

class ValidationHelper {
    private ValidationHelper() {}

    static boolean isStringLengthBetween(String text, int min, int max) {
        if (text == null) return false;
        int len = text.trim().length();
        return len >= min && len <= max;
    }

    static boolean isNumberInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    static boolean isNumberInRange(double number, double min, double max) {
        return number >= min && number <= max;
    }

    static boolean isMatch(String text, String pattern) {
        if (text == null || pattern == null) return false;
        return Pattern.matches(pattern, text);
    }
}
