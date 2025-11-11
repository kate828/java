package ua.model;

import ua.exception.InvalidDataException;
import ua.util.LogUtil;
import ua.util.ValidationUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Reader implements Serializable {
    private static final Logger logger = LogUtil.getLogger();
    private String firstName;
    private String lastName;
    private int readerId;

    public Reader(String firstName, String lastName, int readerId) throws InvalidDataException {
        List<String> errors = new ArrayList<>();
        errors.addAll(ValidationUtil.validateString("firstName", firstName));
        errors.addAll(ValidationUtil.validateString("lastName", lastName));
        if (readerId <= 0) errors.add("readerId: must be > 0");

        if (!errors.isEmpty()) {
            logger.warning("❌ Invalid Reader: " + errors);
            throw new InvalidDataException(errors);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.readerId = readerId;
        logger.info("✅ Created valid Reader: " + this);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " [ID: " + readerId + "]";
    }
}
