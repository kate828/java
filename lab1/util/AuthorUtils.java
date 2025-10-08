package ua.util;

public class AuthorUtils {
    public static boolean isValidBirthYear(int year) {
        return ValidationHelper.isNumberInRange(year, 1000, 2025);
    }
}
