package ua.repository;

import ua.model.Reader;
import ua.util.LogUtil;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ReaderRepository extends GenericRepository<Reader> {
    private static final Logger logger = LogUtil.getLogger();

    public Reader findById(String id) {
        logger.info("Searching reader by ID: " + id);
        return items.stream()
                .filter(r -> r.getReaderId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public List<Reader> findByLastName(String lastNamePart) {
        logger.info("Searching readers with last name containing: " + lastNamePart);
        return items.stream()
                .filter(r -> r.getLastName().toLowerCase().contains(lastNamePart.toLowerCase()))
                .collect(Collectors.toList());
    }
}
