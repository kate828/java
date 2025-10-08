package ua.util;

import ua.model.EBookCategory;

public class EBookUtils {
    private EBookUtils() {}

    public static boolean isValidTitle(String title) {
        return ValidationHelperInner.isStringLengthBetween(title, 1, 200);
    }

    public static boolean isValidIsbn(String isbn) {
        if (isbn == null) return false;
    
        return isbn.matches("^(?:\\d{9}[\\dXx]|\\d{13})$") || isbn.matches("^\\d{3}-\\d{10}$");
    }

    public static EBookCategory parseCategory(String s) {
        if (s == null) return EBookCategory.OTHER;
        return switch (s.trim().toLowerCase()) {
            case "fiction", "novel" -> EBookCategory.FICTION;
            case "nonfiction", "non-fiction" -> EBookCategory.NONFICTION;
            case "science" -> EBookCategory.SCIENCE;
            case "history" -> EBookCategory.HISTORY;
            default -> EBookCategory.OTHER;
        };
    }


    static class ValidationHelperInner {
        static boolean isStringLengthBetween(String text, int min, int max) {
            if (text == null) return false;
            int len = text.trim().length();
            return len >= min && len <= max;
        }
    }
}
