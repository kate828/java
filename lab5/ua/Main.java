package ua;

import ua.test.SortTest;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("=== Лабораторна робота №5: Сортування об’єктів ===");

        try {
            SortTest.run();
            logger.info("Програма виконана успішно.");
        } catch (Exception e) {
            logger.severe("Помилка виконання: " + e.getMessage());
        }
    }
}
