package ua.model;

import java.time.LocalDate;

public class LibraryAccess {
    private Reader reader;
    private EBook ebook;
    private LocalDate accessStartDate;
    private LocalDate accessEndDate;

    public LibraryAccess() {}

    public LibraryAccess(Reader reader, EBook ebook, LocalDate accessStartDate, LocalDate accessEndDate) {
        this.reader = reader;
        this.ebook = ebook;
        this.accessStartDate = accessStartDate;
        this.accessEndDate = accessEndDate;
    }

    public Reader getReader() {
        return reader;
    }

    public EBook getEbook() {
        return ebook;
    }

    public LocalDate getAccessStartDate() {
        return accessStartDate;
    }

    public LocalDate getAccessEndDate() {
        return accessEndDate;
    }

    public boolean isAccessActive() {
        LocalDate now = LocalDate.now();
        return (now.isEqual(accessStartDate) || now.isAfter(accessStartDate))
                && (now.isBefore(accessEndDate) || now.isEqual(accessEndDate));
    }

    @Override
    public String toString() {
        return String.format("LibraryAccess{reader=%s, ebook=%s, from=%s, to=%s, active=%s}",
                reader, ebook.getTitle(), accessStartDate, accessEndDate, isAccessActive());
    }
}
