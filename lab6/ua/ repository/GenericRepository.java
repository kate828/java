package ua.repository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.logging.Logger;
import ua.util.LogUtil;

public class GenericRepository<T> {
    protected List<T> items = new ArrayList<>();
    protected Logger logger = LogUtil.getLogger();

    public void add(T item) {
        items.add(item);
        logger.info("Added: " + item);
    }

    public List<T> getAll() {
        return items;
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public void printAll() {
        items.forEach(System.out::println);
    }
}
