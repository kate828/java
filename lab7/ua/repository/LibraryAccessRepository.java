package ua.repository;

import ua.model.LibraryAccess;
import ua.util.LogUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LibraryAccessRepository extends GenericRepository<LibraryAccess> {
    private static final Logger logger = LogUtil.getLogger();

    public List<LibraryAccess> findActiveAccesses() {
        logger.info("Finding all active accesses...");
        return items.stream()
                .filter(LibraryAccess::isAccessActive)
                .collect(Collectors.toList());
    }

    public List<LibraryAccess> findByReaderId(String readerId) {
        logger.info("Finding accesses by reader ID: " + readerId);
        return items.stream()
                .filter(a -> a.getReader().getReaderId().equalsIgnoreCase(readerId))
                .collect(Collectors.toList());
    }

    public List<LibraryAccess> findByDateRange(LocalDate from, LocalDate to) {
        logger.info("Finding accesses between " + from + " and " + to);
        return items.stream()
                .filter(a -> !a.getAccessStartDate().isAfter(to) && !a.getAccessEndDate().isBefore(from))
                .collect(Collectors.toList());
    }
}
