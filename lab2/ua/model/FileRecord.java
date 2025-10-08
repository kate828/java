package ua.model;

import ua.util.FileUtils2;

public record FileRecord(String url, FileFormat format, double sizeMb, String type) {
    public FileRecord {
        if (!FileUtils2.isValidUrl(url)) throw new IllegalArgumentException("Invalid url");
        if (!FileUtils2.isValidSize(sizeMb)) throw new IllegalArgumentException("Invalid size");
        if (format == null) format = FileFormat.UNKNOWN;
    }

    public static FileRecord of(String url, String formatString, double sizeMb, String type) {
        FileFormat fmt = FileUtils2.parseFormat(formatString);
        if (FileUtils2.isValidUrl(url) && FileUtils2.isValidSize(sizeMb) && fmt != FileFormat.UNKNOWN) {
            return new FileRecord(url, fmt, sizeMb, type);
        }
        return null;
    }
}
