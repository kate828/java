package ua.util;

import ua.model.FileFormat;

public class FileUtils2 {
    private FileUtils2() {}

    public static FileFormat parseFormat(String value) {
        if (value == null) return FileFormat.UNKNOWN;
        return switch (value.trim().toLowerCase()) {
            case "pdf" -> FileFormat.PDF;
            case "epub" -> FileFormat.EPUB;
            case "mobi" -> FileFormat.MOBI;
            case "mp3", "audio" -> FileFormat.MP3;
            default -> FileFormat.UNKNOWN;
        };
    }

    public static boolean isValidUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }

    public static boolean isValidSize(double mb) {
        return mb >= 0.0 && mb <= 50_000.0;
    }
}
