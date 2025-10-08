package ua.util;

public class ReaderUtils {
    public static boolean isValidReaderId(String id) {
        if (id == null) return false;
        return ValidationHelper.isStringLengthBetween(id, 1, 20);
    }
}
