package repository;


import model.Author;
import java.util.Comparator;


public class AuthorRepository extends GenericRepository<Author> {


public void sortByName() {
data.sort(Comparator.comparing(Author::getFullname));
}
}
