package ua.repository;

import ua.model.Reader;

public class ReaderRepository extends GenericRepository<Reader> {
    public void sortByName() {
        data.sort(Reader.byName);
    }
}
