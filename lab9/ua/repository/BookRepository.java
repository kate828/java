package repository;


import model.Book;
import java.util.Comparator;


public class BookRepository extends GenericRepository<Book> {


public void sortByTitle() {
data.sort(Comparator.comparing(Book::getTitle));
}
}
