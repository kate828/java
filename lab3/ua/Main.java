package ua;

import ua.exception.InvalidDataException;
import ua.model.*;
import ua.util.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.info("=== Старт програми Library 2 (Digital) ===");

        try {
            List<Author> authors = FileLoader.loadAuthors("data/authors.txt");
            List<Reader> readers = FileLoader.loadReaders("data/readers.txt");

            System.out.println("Автори:");
            authors.forEach(System.out::println);

            System.out.println("\nЧитачі:");
            readers.forEach(System.out::println);

            EBook ebook = new EBook("1984", authors, "9780451524935", List.of(
                    new FileResource("https://ebooks.com/1984.pdf", "PDF", 2.5, "Document")
            ));
            System.out.println("\nEBook створено: " + ebook);

        } catch (InvalidDataException e) {
            System.err.println("Помилка даних: " + e.getMessage());
            LoggerUtil.error("Виникла помилка даних", e);
        } finally {
            LoggerUtil.info("=== Завершення програми ===");
        }
    }
}
