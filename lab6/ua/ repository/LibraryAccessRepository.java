package ua.repository;

import ua.model.LibraryAccess;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryAccessRepository extends GenericRepository<LibraryAccess> {
    public List<LibraryAccess> findExpired(LocalDate currentDate) {
        return items.stream()
                .filter(a -> a.getAccessEndDate().isBefore(currentDate))
                .collect(Collectors.toList());
    }
}
