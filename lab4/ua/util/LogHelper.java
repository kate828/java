package ua.util;

import java.io.IOException;
import java.util.logging.*;

public class LogHelper {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        try {
            FileHandler handler = new FileHandler("library4.log", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setUseParentHandlers(true);
        } catch (IOException e) {
            System.err.println("Помилка створення лог-файлу: " + e.getMessage());
        }
        return logger;
    }
}
