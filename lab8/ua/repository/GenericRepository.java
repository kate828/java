package ua.repository;

import ua.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GenericRepository<T> {
    protected List<T> items = new ArrayList<>();
    protected Logger logger = LogUtil.getLogger();

    public void add(T item) {
        if (item == null) {
            logger.warning("Attempted to add null item");
            return;
        }
        items.add(item);
        logger.info("Added: " + item);
    }

    public List<T> getAll() {
        return items;
    }
}
