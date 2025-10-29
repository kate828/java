package ua.repository;

import ua.model.LibraryAccess;

public class LibraryAccessRepository extends GenericRepository<LibraryAccess> {
    public void sortByEndDate() {
        data.sort(LibraryAccess.byEndDate);
    }
}
