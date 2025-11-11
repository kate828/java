package ua.util;

import java.io.IOException;
import java.util.logging.*;

public class LogUtil {
    private static final Logger logger = Logger.getLogger("LibraryLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("library.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("⚠️ Could not initialize file logger: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
