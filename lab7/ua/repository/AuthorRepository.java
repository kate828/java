package ua.repository;

import ua.model.Author;
import ua.util.LogUtil;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AuthorRepository extends GenericRepository<Author> {
    private static final Logger logger = LogUtil.getLogger();

    public List<Author> findByLastName(String lastNamePart) {
        logger.info("Searching authors with last name containing: " + lastNamePart);
        return items.stream()
                .filter(a -> a.getSurname().toLowerCase().contains(lastNamePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Author> findByBirthYear(int year) {
        logger.info("Searching authors born in year: " + year);
        return items.stream()
                .filter(a -> a.getBirthYear() == year)
                .collect(Collectors.toList());
    }

    public List<Author> findByBirthYearRange(int from, int to) {
        logger.info("Searching authors born between " + from + " and " + to);
        return items.stream()
                .filter(a -> a.getBirthYear() >= from && a.getBirthYear() <= to)
                .collect(Collectors.toList());
    }
}
