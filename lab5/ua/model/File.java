package ua.model;

public class File implements Comparable<File> {
    private String url;
    private String format;
    private double size;
    private String type;

    public File(String url, String format, double size, String type) {
        this.url = url;
        this.format = format;
        this.size = size;
        this.type = type;
    }

    public String getFormat() { return format; }
    public double getSize() { return size; }

    @Override
    public int compareTo(File other) {
        return Double.compare(this.size, other.size);
    }

    public static java.util.Comparator<File> byFormat =
            java.util.Comparator.comparing(File::getFormat);

    @Override
    public String toString() {
        return "[" + format + "] " + size + "MB (" + type + ")";
    }
}
