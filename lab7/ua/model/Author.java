package ua.model;

public class Author {
    private String name;
    private String surname;
    private int birthYear;

    public Author() {}

    public Author(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getBirthYear() { return birthYear; }

    @Override
    public String toString() {
        return name + " " + surname + " (" + birthYear + ")";
    }
}
