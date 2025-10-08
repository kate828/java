package ua.model;

import ua.util.LibraryAccessUtils;
import java.util.Date;
import java.util.Objects;

public class LibraryAccess {
    private Reader reader;
    private String ebookTitle;
    private Date accessStartDate;
    private Date accessEndDate;

    public LibraryAccess() {
    }

    public LibraryAccess(Reader reader, String ebookTitle, Date accessStartDate, Date accessEndDate) {
        setAccessStartDate(accessStartDate);
        setAccessEndDate(accessEndDate);
        this.reader = reader;
        this.ebookTitle = ebookTitle;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getEbookTitle() {
        return ebookTitle;
    }

    public void setEbookTitle(String ebookTitle) {
        this.ebookTitle = ebookTitle;
    }

    public Date getAccessStartDate() {
        return accessStartDate;
    }

    public void setAccessStartDate(Date accessStartDate) {
        if (LibraryAccessUtils.isValidStartDate(accessStartDate))
            this.accessStartDate = accessStartDate;
    }

    public Date getAccessEndDate() {
        return accessEndDate;
    }

    public void setAccessEndDate(Date accessEndDate) {
        if (LibraryAccessUtils.isValidEndDate(accessStartDate, accessEndDate))
            this.accessEndDate = accessEndDate;
    }

    public static LibraryAccess createLibraryAccess(Reader reader, String ebookTitle, Date start, Date end) {
        if (LibraryAccessUtils.isValidStartDate(start) && LibraryAccessUtils.isValidEndDate(start, end)) {
            return new LibraryAccess(reader, ebookTitle, start, end);
        }
        return null;
    }

    @Override
    public String toString() {
        return "LibraryAccess{" +
                "reader=" + (reader != null ? reader.getFullName() : "No Reader") +
                ", ebookTitle='" + ebookTitle + '\'' +
                ", accessStartDate=" + accessStartDate +
                ", accessEndDate=" + accessEndDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryAccess)) return false;
        LibraryAccess that = (LibraryAccess) o;
        return Objects.equals(reader, that.reader) &&
               Objects.equals(ebookTitle, that.ebookTitle) &&
               Objects.equals(accessStartDate, that.accessStartDate) &&
               Objects.equals(accessEndDate, that.accessEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reader, ebookTitle, accessStartDate, accessEndDate);
    }
}
