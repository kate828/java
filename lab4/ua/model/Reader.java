package ua.model;

public class Reader {
    private String firstName;
    private String lastName;
    private String readerId;

    public Reader(String firstName, String lastName, String readerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.readerId = readerId;
    }

    public String getReaderId() {
        return readerId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + readerId + ")";
    }
}
