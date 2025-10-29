package ua.model;

import java.time.LocalDate;

public class LibraryAccess {
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

    public String getId() {
        return reader.getReaderId() + "_" + ebook.getIsbn();
    }

    @Override
    public String toString() {
        return reader + " -> " + ebook + " [" + startDate + " - " + endDate + "]";
    }
}
