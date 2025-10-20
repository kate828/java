package ua;

import ua.exception.InvalidDataException;
import ua.model.*;
import ua.util.FileUtils;
import ua.util.LibraryUtils;
import ua.util.LogHelper;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LogHelper.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("=== Початок виконання програми Library 2 (Digital) ===");

        try {
            List<Author> authors = FileUtils.readAuthors("data/authors.csv");
            List<EBook> ebooks = FileUtils.readEBooks("data/ebooks.csv");
            List<Reader> readers = FileUtils.readReaders("data/readers.csv");

            logger.info("Дані успішно зчитано.");

            LibraryAccess access = LibraryUtils.createAccess(readers.get(0), ebooks.get(0));
            logger.info("Створено доступ: " + access);

            try {
                LibraryUtils.validateEBook(new EBook("", "", "1234", null));
            } catch (InvalidDataException e) {
                logger.warning("Виняток при перевірці: " + e.getMessage());
            }

            logger.info("Програма виконана успішно.");

        } catch (IOException e) {
            logger.severe("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Невідома помилка: " + e.getMessage());
        } finally {
            logger.info("=== Завершення програми ===");
        }
    }
}
