package ua.util;

import ua.exception.InvalidDataException;
import ua.model.*;

import java.time.LocalDate;

public class LibraryUtils {

    public static void validateEBook(EBook ebook) throws InvalidDataException {
        if (ebook.getTitle() == null || ebook.getTitle().isBlank())
            throw new InvalidDataException("Назва книги не може бути порожньою");
    }

    public static LibraryAccess createAccess(Reader reader, EBook ebook) {
        return new LibraryAccess(reader, ebook, LocalDate.now(), LocalDate.now().plusDays(14));
    }
}
