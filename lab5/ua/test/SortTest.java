package ua.test;

import ua.model.*;
import ua.repository.*;
import java.time.LocalDate;

public class SortTest {
    public static void run() {
        Author a1 = new Author("George", "Orwell", 1903);
        Author a2 = new Author("Aldous", "Huxley", 1894);

        EBook e1 = new EBook("1984", "111", a1);
        EBook e2 = new EBook("Brave New World", "222", a2);

        Reader r1 = new Reader("John", "Smith", 1);
        Reader r2 = new Reader("Alice", "Brown", 2);

        LibraryAccess acc1 = new LibraryAccess(r1, e1, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 1));
        LibraryAccess acc2 = new LibraryAccess(r2, e2, LocalDate.of(2025, 3, 1), LocalDate.of(2025, 4, 1));

        AuthorRepository authorRepo = new AuthorRepository();
        authorRepo.add(a1);
        authorRepo.add(a2);
        authorRepo.sortByBirthYear();
        System.out.println("Сортування авторів за роком народження:");
        authorRepo.getAll().forEach(System.out::println);

        EBookRepository ebookRepo = new EBookRepository();
        ebookRepo.add(e1);
        ebookRepo.add(e2);
        ebookRepo.sortByIsbn();
        System.out.println("\nСортування книг за ISBN:");
        ebookRepo.getAll().forEach(System.out::println);

        ReaderRepository readerRepo = new ReaderRepository();
        readerRepo.add(r1);
        readerRepo.add(r2);
        readerRepo.sortByName();
        System.out.println("\nСортування читачів за ім'ям:");
        readerRepo.getAll().forEach(System.out::println);

        LibraryAccessRepository accessRepo = new LibraryAccessRepository();
        accessRepo.add(acc1);
        accessRepo.add(acc2);
        accessRepo.sortByEndDate();
        System.out.println("\nСортування доступів за датою завершення:");
        accessRepo.getAll().forEach(System.out::println);
    }
}
