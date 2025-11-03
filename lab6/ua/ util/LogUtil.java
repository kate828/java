package ua.util;

import java.util.logging.*;

public class LogUtil {
    private static final Logger logger = Logger.getLogger(LogUtil.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("library_streams.log", true);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
