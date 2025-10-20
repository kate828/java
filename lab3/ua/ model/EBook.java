package ua.model;

import java.util.List;

public class EBook {
    private String title;
    private List<Author> authors;
    private String isbn;
    private List<FileData> files;

    public EBook(String title, List<Author> authors, String isbn, List<FileData> files) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.files = files;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    public String getTitle() { return title; }
}
