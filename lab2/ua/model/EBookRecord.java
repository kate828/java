package ua.model;

import java.util.List;
import ua.util.EBookUtils;

public record EBookRecord(String title, List<String> authors, String isbn, EBookCategory category, List<FileRecord> files) {
    public EBookRecord {
        if (!EBookUtils.isValidTitle(title)) throw new IllegalArgumentException("Invalid title");
        if (!EBookUtils.isValidIsbn(isbn)) throw new IllegalArgumentException("Invalid ISBN");
        authors = authors == null ? List.of() : List.copyOf(authors);
        files = files == null ? List.of() : List.copyOf(files);
        if (category == null) category = EBookCategory.OTHER;
    }

    public static EBookRecord create(String title, List<String> authors, String isbn, String categoryString, List<FileRecord> files) {
        EBookCategory cat = EBookUtils.parseCategory(categoryString);
        if (EBookUtils.isValidTitle(title) && EBookUtils.isValidIsbn(isbn)) {
            return new EBookRecord(title, authors, isbn, cat, files);
        }
        return null;
    }
}
