package ua.model;

import ua.util.AuthorUtils;
import ua.util.PersonUtils;
import java.util.Objects;

public class Author extends Person {
    private int birthYear;

    public Author() {
        super();
    }

    public Author(String firstName, String lastName, String email, int birthYear) {
        super(firstName, lastName, email);
        setBirthYear(birthYear);
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (AuthorUtils.isValidBirthYear(birthYear)) {
            this.birthYear = birthYear;
        }
    }

    public static Author createAuthor(String firstName, String lastName, int birthYear) {
        if (AuthorUtils.isValidBirthYear(birthYear) &&
            PersonUtils.isValidName(firstName) && PersonUtils.isValidName(lastName)) {
            String email = PersonUtils.generateEmail(firstName, lastName);
            return new Author(firstName, lastName, email, birthYear);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return birthYear == author.birthYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthYear);
    }
}
