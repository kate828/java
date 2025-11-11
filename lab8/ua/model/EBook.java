package ua.model;

import ua.exception.InvalidDataException;
import ua.util.LogUtil;
import ua.util.ValidationUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EBook implements Serializable {
    private static final Logger logger = LogUtil.getLogger();
    private String title;
    private String isbn;

    public EBook(String title, String isbn) throws InvalidDataException {
        List<String> errors = new ArrayList<>();
        errors.addAll(ValidationUtil.validateString("title", title));
        errors.addAll(ValidationUtil.validateString("isbn", isbn));

        if (!errors.isEmpty()) {
            logger.warning("❌ Invalid EBook: " + errors);
            throw new InvalidDataException(errors);
        }

        this.title = title;
        this.isbn = isbn;

        logger.info("✅ Created valid EBook: " + this);
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}
