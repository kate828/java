package ua.model;

import ua.util.ReaderUtils;
import ua.util.PersonUtils;
import java.util.Objects;

public class Reader extends Person {
    private String readerId;
    private Author favoriteAuthor; // приклад protected/package-private доступу можна демонструвати

    public Reader() {
        super();
    }

    public Reader(String firstName, String lastName, String email, String readerId) {
        super(firstName, lastName, email);
        setReaderId(readerId);
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        if (ReaderUtils.isValidReaderId(readerId)) {
            this.readerId = readerId;
        }
    }

    public static Reader createReader(String firstName, String lastName, String readerId) {
        if (ReaderUtils.isValidReaderId(readerId) &&
            PersonUtils.isValidName(firstName) && PersonUtils.isValidName(lastName)) {
            String email = PersonUtils.generateEmail(firstName, lastName);
            return new Reader(firstName, lastName, email, readerId);
        }
        return null;
    }

    public Author getFavoriteAuthor() {
        return favoriteAuthor;
    }

    public void setFavoriteAuthor(Author favoriteAuthor) {
        this.favoriteAuthor = favoriteAuthor;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", readerId='" + readerId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(readerId, reader.readerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), readerId);
    }
}
