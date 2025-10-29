package ua.model;

public class Reader implements Comparable<Reader> {
    private String firstName;
    private String lastName;
    private int readerId;

    public Reader(String firstName, String lastName, int readerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.readerId = readerId;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Reader o) {
        return Integer.compare(this.readerId, o.readerId);
    }

    public static java.util.Comparator<Reader> byName =
            java.util.Comparator.comparing(Reader::getFullName);

    @Override
    public String toString() {
        return getFullName() + " (ID: " + readerId + ")";
    }
}
