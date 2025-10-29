package ua;

import ua.model.*;
import ua.repository.*;
import ua.util.LogHelper;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LogHelper.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("=== Початок виконання програми (Lab 4: Generics & Collections) ===");

    
        Author author = new Author("Jane", "Austen", 1775);
        Reader reader1 = new Reader("Anna", "Petrova", "R001");
        Reader reader2 = new Reader("Ivan", "Ivanov", "R002");

        EBook book1 = new EBook("Pride and Prejudice", List.of(author), "ISBN123");
        EBook book2 = new EBook("Emma", List.of(author), "ISBN124");

        LibraryAccess access1 = new LibraryAccess(reader1, book1, LocalDate.now(), LocalDate.now().plusDays(7));
        LibraryAccess access2 = new LibraryAccess(reader2, book2, LocalDate.now(), LocalDate.now().plusDays(14));

  
        GenericRepository<EBook> bookRepo = new GenericRepository<>(EBook::getIsbn);
        GenericRepository<Reader> readerRepo = new GenericRepository<>(Reader::getReaderId);
        GenericRepository<LibraryAccess> accessRepo = new GenericRepository<>(LibraryAccess::getId);

    
        bookRepo.add(book1);
        bookRepo.add(book2);
        bookRepo.add(book1); 

        readerRepo.add(reader1);
        readerRepo.add(reader2);

        accessRepo.add(access1);
        accessRepo.add(access2);
        accessRepo.add(access1); 

   
        System.out.println("📚 Книги: " + bookRepo.getAll());
        System.out.println("👥 Читачі: " + readerRepo.getAll());
        System.out.println("🔑 Доступи: " + accessRepo.getAll());

  
        bookRepo.findByIdentity("ISBN124")
                .ifPresent(b -> System.out.println("🔍 Знайдено книгу: " + b));

    
        readerRepo.remove(reader2);

        logger.info("=== Програма завершена успішно ===");
    }
}
