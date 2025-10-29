package ua.util;

import ua.exception.InvalidDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileData {
    private static final Logger logger = Logger.getLogger(FileData.class.getName());

    public static List<String> readLines(String filePath) throws InvalidDataException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            logger.info("Початок зчитування файлу: " + filePath);

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    logger.warning("Порожній рядок пропущено");
                    continue;
                }
                lines.add(line);
            }

            logger.info("Файл успішно зчитано. Рядків: " + lines.size());
            return lines;

        } catch (FileNotFoundException e) {
            logger.severe("Файл не знайдено: " + filePath);
            throw new InvalidDataException("Файл не знайдено: " + filePath, e);
        } catch (IOException e) {
            logger.severe("Помилка при зчитуванні файлу: " + e.getMessage());
            throw new InvalidDataException("Помилка вводу/виводу при зчитуванні файлу", e);
        } catch (Exception e) {
            logger.severe("Невідома помилка: " + e.getMessage());
            throw new InvalidDataException("Невідома помилка під час обробки файлу", e);
        } finally {
            logger.info("Завершення зчитування файлу: " + filePath);
        }
    }
}
