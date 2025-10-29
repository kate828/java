package ua.model;

import java.util.List;

public class EBook {
    private String title;
    private List<Author> authors;
    private String isbn;

    public EBook(String title, List<Author> authors, String isbn) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "EBook{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
