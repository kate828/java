package ua.repository;

import ua.util.LogHelper;
import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {
    private static final Logger logger = LogHelper.getLogger(GenericRepository.class.getName());

    private final List<T> items = new ArrayList<>();
    private final IdentityExtractor<T> extractor;

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.extractor = extractor;
    }

    public void add(T item) {
        String id = extractor.extractId(item);
        boolean exists = items.stream()
                .anyMatch(i -> extractor.extractId(i).equals(id));
        if (exists) {
            logger.warning("Об'єкт із таким ID вже існує: " + id);
        } else {
            items.add(item);
            logger.info("Додано об'єкт: " + item);
        }
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Видалено об'єкт: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public Optional<T> findByIdentity(String id) {
        return items.stream()
                .filter(i -> extractor.extractId(i).equals(id))
                .findFirst();
    }

    @Override
    public String toString() {
        return "GenericRepository{" + "items=" + items + '}';
    }
}
