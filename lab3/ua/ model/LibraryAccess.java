package ua.model;

import java.time.LocalDate;

public class LibraryAccess {
    private Reader reader;
    private EBook ebook;
    private LocalDate accessStartDate;
    private LocalDate accessEndDate;

    public LibraryAccess(Reader reader, EBook ebook, LocalDate start, LocalDate end) {
        this.reader = reader;
        this.ebook = ebook;
        this.accessStartDate = start;
        this.accessEndDate = end;
    }

    @Override
    public String toString() {
        return reader + " має доступ до " + ebook.getTitle() +
                " з " + accessStartDate + " по " + accessEndDate;
    }
}
