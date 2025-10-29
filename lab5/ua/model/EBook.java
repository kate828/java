package ua.model;

import java.util.Comparator;
import java.util.Objects;

public class EBook implements Comparable<EBook> {
    private String title;
    private String isbn;
    private Author author;

    public EBook(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Author getAuthor() { return author; }

    @Override
    public int compareTo(EBook o) {
        return this.title.compareToIgnoreCase(o.title);
    }

    public static Comparator<EBook> byIsbn =
            Comparator.comparing(EBook::getIsbn);

    public static Comparator<EBook> byAuthorName =
            Comparator.comparing(e -> e.getAuthor().getFullName());

    @Override
    public String toString() {
        return title + " [" + isbn + "] - " + author.getFullName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EBook)) return false;
        EBook eBook = (EBook) o;
        return Objects.equals(isbn, eBook.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
