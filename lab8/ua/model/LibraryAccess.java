package ua.model;

import ua.exception.InvalidDataException;
import ua.util.LogUtil;
import ua.util.ValidationUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibraryAccess implements Serializable {
    private static final Logger logger = LogUtil.getLogger();

    private Reader reader;
    private EBook eBook;
    private String accessDate;

    public LibraryAccess(Reader reader, EBook eBook, String accessDate) throws InvalidDataException {
        List<String> errors = new ArrayList<>();
        if (reader == null) errors.add("reader: cannot be null");
        if (eBook == null) errors.add("eBook: cannot be null");
        errors.addAll(ValidationUtil.validateString("accessDate", accessDate));

        if (!errors.isEmpty()) {
            logger.warning("❌ Invalid LibraryAccess: " + errors);
            throw new InvalidDataException(errors);
        }

        this.reader = reader;
        this.eBook = eBook;
        this.accessDate = accessDate;

        logger.info("✅ Created valid LibraryAccess: " + this);
    }

    @Override
    public String toString() {
        return "Access{" + reader + " → " + eBook + " @ " + accessDate + "}";
    }
}
