package repository;


import model.Group;
import java.util.Comparator;


public class GroupRepository extends GenericRepository<Group> {


public void sortByName() {
data.sort(Comparator.comparing(Group::getName));
}
}
