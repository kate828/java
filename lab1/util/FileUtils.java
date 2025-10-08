package ua.util;

public class FileUtils {
    public static boolean isValidUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }

    public static boolean isValidFormat(String fmt) {
        if (fmt == null) return false;
        String f = fmt.trim().toUpperCase();
        return f.equals("PDF") || f.equals("EPUB") || f.equals("MOBI") || f.equals("MP3");
    }

    public static boolean isValidSize(double mb) {
        return ValidationHelper.isNumberInRange(mb, 0, 10_000);
    }
}
