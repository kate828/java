package ua.model;

import java.util.List;

public class EBook {
    private String title;
    private List<Author> authors;
    private String isbn;
    private List<FileData> files;

    public EBook() {}

    public EBook(String title, List<Author> authors, String isbn, List<FileData> files) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.files = files;
    }

    @Override
    public String toString() {
        return String.format("EBook{title='%s', authors=%s, isbn='%s', files=%s}",
                title, authors, isbn, files);
    }
}
