package ua.util;

import java.util.Date;

public class LibraryAccessUtils {
    public static boolean isValidStartDate(Date date) {
        return date != null;
    }

    public static boolean isValidEndDate(Date start, Date end) {
        if (end == null || start == null) return false;
        return !end.before(start);
    }
}
