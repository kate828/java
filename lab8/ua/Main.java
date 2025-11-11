package ua;

import ua.exception.InvalidDataException;
import ua.model.*;
import ua.repository.AuthorRepository;
import ua.util.LogUtil;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogUtil.getLogger();
        AuthorRepository repo = new AuthorRepository();

        try {
            Author valid = new Author("George", "Orwell", 1903);
            repo.add(valid);

            Author invalid = new Author("", "", 2200);
            repo.add(invalid);

        } catch (InvalidDataException e) {
            logger.severe("❌ Validation error: " + e.getMessage());
            System.out.println("Помилки: " + e.getErrors());
        }

        System.out.println("\n✅ Valid authors in repository:");
        repo.getAll().forEach(System.out::println);
    }
}
