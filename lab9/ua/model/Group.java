package model;


public class Group implements Comparable<Group> {
private int id;
private String name;


public Group(int id, String name) {
this.id = id;
this.name = name;
}


public int getId() { return id; }
public String getName() { return name; }


@Override
public int compareTo(Group o) {
return Integer.compare(this.id, o.id);
}


@Override
public String toString() {
return id + " " + name;
}
}
