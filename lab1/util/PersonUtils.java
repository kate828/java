package ua.util;

public class PersonUtils {
    private PersonUtils() {}

    public static String formatFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null) return "";
        return firstName.trim() + " " + lastName.trim();
    }

    public static String formatEmail(String email) {
        if (email == null) return null;
        return email.toLowerCase().trim();
    }

    public static boolean isValidEmail(String email) {
        return ValidationHelper.isMatch(email, "^[\\w.-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-zA-Z]{2,}$");
    }

    public static String generateEmail(String firstName, String lastName) {
        if (firstName == null || lastName == null) return null;
        return firstName.trim().toLowerCase() + "." + lastName.trim().toLowerCase() + "@library.local";
    }

    public static boolean isValidName(String name) {
        return ValidationHelper.isStringLengthBetween(name, 2, 50);
    }

    public static String capitalize(String text) {
        if (text == null || text.trim().isEmpty()) return text;
        String t = text.trim();
        return t.substring(0,1).toUpperCase() + t.substring(1).toLowerCase();
    }
}
