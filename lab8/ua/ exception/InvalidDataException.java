package ua.exception;

import java.util.List;

public class InvalidDataException extends Exception {
    private final List<String> errors;

    public InvalidDataException(List<String> errors) {
        super(String.join("; ", errors));
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
