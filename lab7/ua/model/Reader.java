package ua.model;

public class Reader {
    private String firstName;
    private String lastName;
    private String readerId;

    public Reader() {}

    public Reader(String firstName, String lastName, String readerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.readerId = readerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getReaderId() {
        return readerId;
    }

    @Override
    public String toString() {
        return String.format("Reader{id='%s', name='%s %s'}", readerId, firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reader)) return false;
        Reader other = (Reader) obj;
        return readerId != null && readerId.equals(other.readerId);
    }

    @Override
    public int hashCode() {
        return readerId != null ? readerId.hashCode() : 0;
    }
}
