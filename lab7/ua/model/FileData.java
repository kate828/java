package ua.model;

public class FileData {
    private String url;
    private String format;
    private double sizeMB;
    private String category;

    public FileData() {}

    public FileData(String url, String format, double sizeMB, String category) {
        this.url = url;
        this.format = format;
        this.sizeMB = sizeMB;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%s [%s, %.1f MB, %s]", url, format, sizeMB, category);
    }
}
