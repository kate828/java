package ua.model;

import java.time.LocalDate;

public class LibraryAccess {
    private Reader reader;
    private EBook ebook;
    private LocalDate accessStartDate;
    private LocalDate accessEndDate;

    public LibraryAccess(Reader reader, EBook ebook, LocalDate accessStartDate, LocalDate accessEndDate) {
        this.reader = reader;
        this.ebook = ebook;
        this.accessStartDate = accessStartDate;
        this.accessEndDate = accessEndDate;
    }

    public Reader getReader() { return reader; }
    public EBook getEbook() { return ebook; }
    public LocalDate getAccessEndDate() { return accessEndDate; }

    @Override
    public String toString() {
        return reader + " -> " + ebook.getTitle() + " (" + accessStartDate + " - " + accessEndDate + ")";
    }
}
