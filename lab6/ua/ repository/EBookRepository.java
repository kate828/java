package ua.repository;

import ua.model.EBook;
import ua.util.LogUtil;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EBookRepository extends GenericRepository<EBook> {
    private static final Logger logger = LogUtil.getLogger();

    public List<EBook> findByTitle(String titlePart) {
        logger.info("Searching for EBooks with title containing: " + titlePart);
        return items.stream()
                .filter(e -> e.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<EBook> findByAuthor(String authorLastName) {
        return items.stream()
                .filter(e -> e.getAuthors().stream()
                        .anyMatch(a -> a.getLastName().equalsIgnoreCase(authorLastName)))
                .collect(Collectors.toList());
    }
}
