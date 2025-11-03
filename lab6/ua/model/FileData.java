package ua.model;

public class FileData {
    private String url;
    private String format;
    private double size;
    private String type;

    public FileData(String url, String format, double size, String type) {
        this.url = url;
        this.format = format;
        this.size = size;
        this.type = type;
    }

    public String getFormat() { return format; }
    public double getSize() { return size; }

    @Override
    public String toString() {
        return String.format("%s (%.1f MB, %s)", format, size, type);
    }
}
