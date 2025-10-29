package ua.model;

import java.util.Objects;

public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Author other) {
        return this.lastName.compareToIgnoreCase(other.lastName);
    }

    public static java.util.Comparator<Author> byBirthYearAsc =
            (a1, a2) -> Integer.compare(a1.birthYear, a2.birthYear);

    public static java.util.Comparator<Author> byFirstName =
            java.util.Comparator.comparing(Author::getFullName);

    @Override
    public String toString() {
        return getFullName() + " (" + birthYear + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
               Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
