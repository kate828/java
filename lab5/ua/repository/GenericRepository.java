package ua.repository;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T extends Comparable<T>> {
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());
    protected List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
        logger.info("Додано об'єкт: " + item);
    }

    public void remove(T item) {
        data.remove(item);
        logger.info("Видалено об'єкт: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(data);
    }

    public void sortByIdentity(String order) {
        if (order.equalsIgnoreCase("asc")) {
            data.sort(Comparator.naturalOrder());
        } else if (order.equalsIgnoreCase("desc")) {
            data.sort(Comparator.reverseOrder());
        }
        logger.info("Відсортовано колекцію за основним полем (" + order + ")");
    }
}
