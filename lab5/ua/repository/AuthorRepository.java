package ua.repository;

import ua.model.Author;
import java.util.Comparator;

public class AuthorRepository extends GenericRepository<Author> {
    public void sortByBirthYear() {
        data.sort(Author.byBirthYearAsc);
    }

    public void sortByFirstName() {
        data.sort(Comparator.comparing(Author::getFullName));
    }
}
