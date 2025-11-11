package ua.model;

import ua.exception.InvalidDataException;
import ua.util.ValidationUtil;
import ua.util.LogUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileData implements Serializable {
    private static final Logger logger = LogUtil.getLogger();
    private String url;
    private String format;
    private double size;
    private String type;

    public FileData(String url, String format, double size, String type) throws InvalidDataException {
        List<String> errors = new ArrayList<>();
        errors.addAll(ValidationUtil.validateString("url", url));
        errors.addAll(ValidationUtil.validateString("format", format));
        errors.addAll(ValidationUtil.validatePositive("size", size));
        errors.addAll(ValidationUtil.validateString("type", type));

        if (!errors.isEmpty()) {
            logger.warning("❌ Invalid FileData: " + errors);
            throw new InvalidDataException(errors);
        }

        this.url = url;
        this.format = format;
        this.size = size;
        this.type = type;

        logger.info("✅ Created valid FileData: " + this);
    }

    @Override
    public String toString() {
        return "File[" + format + ", " + size + "MB, " + type + "]";
    }
}
