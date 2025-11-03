package ua.repository;

import ua.model.Reader;
import ua.util.LogUtil;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ReaderRepository extends GenericRepository<Reader> {
    private static final Logger logger = LogUtil.getLogger();

    public List<Reader> findByLastName(String lastName) {
        logger.info("Searching Readers by last name: " + lastName);
        return items.stream()
                .filter(r -> r.getFullName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
