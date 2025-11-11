package ua.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ua.exception.DataSerializationException;
import ua.util.LogUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GenericRepository<T> {
    protected List<T> items = new ArrayList<>();
    protected Logger logger = LogUtil.getLogger();

    public void add(T item) {
        items.add(item);
        logger.info("Added: " + item);
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Removed: " + item);
    }

    public List<T> getAll() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public void saveToJson(String filePath) throws DataSerializationException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), items);
            logger.info("Saved to JSON: " + filePath);
        } catch (IOException e) {
            throw new DataSerializationException("Failed to save to JSON", e);
        }
    }

    public void loadFromJson(String filePath, Class<T[]> clazz) throws DataSerializationException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            T[] array = mapper.readValue(new File(filePath), clazz);
            items.clear();
            items.addAll(List.of(array));
            logger.info("Loaded from JSON: " + filePath);
        } catch (IOException e) {
            throw new DataSerializationException("Failed to load from JSON", e);
        }
    }

    public void saveToYaml(String filePath) throws DataSerializationException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), items);
            logger.info("Saved to YAML: " + filePath);
        } catch (IOException e) {
            throw new DataSerializationException("Failed to save to YAML", e);
        }
    }

    public void loadFromYaml(String filePath, Class<T[]> clazz) throws DataSerializationException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            T[] array = mapper.readValue(new File(filePath), clazz);
            items.clear();
            items.addAll(List.of(array));
            logger.info("Loaded from YAML: " + filePath);
        } catch (IOException e) {
            throw new DataSerializationException("Failed to load from YAML", e);
        }
    }
}
