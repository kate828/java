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

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public List<Author> getAuthors() { return authors; }
    public List<FileData> getFiles() { return files; }

    @Override
    public String toString() {
        return "EBook{" + title + ", ISBN=" + isbn + ", authors=" + authors + "}";
    }
}
