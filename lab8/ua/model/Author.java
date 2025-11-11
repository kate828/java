package ua.model;

import ua.exception.InvalidDataException;
import ua.util.LogUtil;
import ua.util.ValidationUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Author implements Serializable {
    private static final Logger logger = LogUtil.getLogger();
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(String firstName, String lastName, int birthYear) throws InvalidDataException {
        List<String> errors = new ArrayList<>();
        errors.addAll(ValidationUtil.validateString("firstName", firstName));
        errors.addAll(ValidationUtil.validateString("lastName", lastName));
        errors.addAll(ValidationUtil.validateYear("birthYear", birthYear));

        if (!errors.isEmpty()) {
            logger.warning("❌ Invalid Author: " + errors);
            throw new InvalidDataException(errors);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;

        logger.info("✅ Created valid Author: " + this);
    }

    public void setFirstName(String firstName) throws InvalidDataException {
        List<String> errors = ValidationUtil.validateString("firstName", firstName);
        if (!errors.isEmpty()) throw new InvalidDataException(errors);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws InvalidDataException {
        List<String> errors = ValidationUtil.validateString("lastName", lastName);
        if (!errors.isEmpty()) throw new InvalidDataException(errors);
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) throws InvalidDataException {
        List<String> errors = ValidationUtil.validateYear("birthYear", birthYear);
        if (!errors.isEmpty()) throw new InvalidDataException(errors);
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthYear + ")";
    }
}
