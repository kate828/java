package repository;


import model.Student;
import java.util.Comparator;


public class StudentRepository extends GenericRepository<Student> {


public void sortByName() {
data.sort(Comparator.comparing(Student::getName));
}


public void sortByAge() {
data.sort(Comparator.comparingInt(Student::getAge));
}
}
