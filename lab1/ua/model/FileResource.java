package ua.model;

import ua.util.FileUtils;
import java.util.Objects;
import java.util.Date;

public class FileResource {
    private String url;
    private String format; // e.g., "PDF", "EPUB"
    private double sizeMb;
    private String type; // e.g., "Document", "Audiobook"
    private Date uploadedAt;

    public FileResource() {}

    public FileResource(String url, String format, double sizeMb, String type, Date uploadedAt) {
        setUrl(url);
        setFormat(format);
        setSizeMb(sizeMb);
        setType(type);
        this.uploadedAt = uploadedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (FileUtils.isValidUrl(url)) this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (FileUtils.isValidFormat(format)) this.format = format.toUpperCase();
    }

    public double getSizeMb() {
        return sizeMb;
    }

    public void setSizeMb(double sizeMb) {
        if (FileUtils.isValidSize(sizeMb)) this.sizeMb = sizeMb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null) this.type = type;
    }

    public Date getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public static FileResource createFile(String url, String format, double sizeMb, String type) {
        if (FileUtils.isValidUrl(url) && FileUtils.isValidFormat(format) && FileUtils.isValidSize(sizeMb)) {
            return new FileResource(url, format.toUpperCase(), sizeMb, type, new Date());
        }
        return null;
    }

    @Override
    public String toString() {
        return "FileResource{" +
                "url='" + url + '\'' +
                ", format='" + format + '\'' +
                ", sizeMb=" + sizeMb +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileResource)) return false;
        FileResource that = (FileResource) o;
        return Double.compare(that.sizeMb, sizeMb) == 0 &&
               Objects.equals(url, that.url) &&
               Objects.equals(format, that.format) &&
               Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, format, sizeMb, type);
    }
}
