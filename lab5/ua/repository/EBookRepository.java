package ua.repository;

import ua.model.EBook;

public class EBookRepository extends GenericRepository<EBook> {
    public void sortByAuthor() {
        data.sort(EBook.byAuthorName);
    }

    public void sortByIsbn() {
        data.sort(EBook.byIsbn);
    }
}
