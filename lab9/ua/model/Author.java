package model;


public class Author implements Comparable<Author> {
private int id;
private String fullname;


public Author(int id, String fullname) {
this.id = id;
this.fullname = fullname;
}


public int getId() { return id; }
public String getFullname() { return fullname; }


@Override
public int compareTo(Author o) {
return this.fullname.compareTo(o.fullname);
}


@Override
public String toString() {
return id + " " + fullname;
}
}
