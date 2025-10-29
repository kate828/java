package ua.model;

import java.time.LocalDate;

public class LibraryAccess implements Comparable<LibraryAccess> {
    private Reader reader;
    private EBook ebook;
    private LocalDate startDate;
    private LocalDate endDate;

    public LibraryAccess(Reader reader, EBook ebook, LocalDate startDate, LocalDate endDate) {
        this.reader = reader;
        this.ebook = ebook;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reader getReader() { return reader; }
    public EBook getEbook() { return ebook; }

    @Override
    public int compareTo(LibraryAccess other) {
        return this.startDate.compareTo(other.startDate);
    }

    public static java.util.Comparator<LibraryAccess> byEndDate =
            java.util.Comparator.comparing(LibraryAccess::getEndDate);

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return reader.getFullName() + " → " + ebook.getTitle() +
                " [" + startDate + " - " + endDate + "]";
    }
}
