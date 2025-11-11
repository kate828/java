package ua.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {

    public static List<String> validateString(String fieldName, String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.isBlank()) {
            errors.add(fieldName + ": cannot be empty or null");
        }
        return errors;
    }

    public static List<String> validatePositive(String fieldName, double number) {
        List<String> errors = new ArrayList<>();
        if (number <= 0) {
            errors.add(fieldName + ": must be greater than 0");
        }
        return errors;
    }

    public static List<String> validateYear(String fieldName, int year) {
        List<String> errors = new ArrayList<>();
        if (year < 1500 || year > 2025) {
            errors.add(fieldName + ": must be between 1500 and 2025");
        }
        return errors;
    }
}
