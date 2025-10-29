package ua.repository;

import ua.model.File;

public class FileRepository extends GenericRepository<File> {
    public void sortByFormat() {
        data.sort(File.byFormat);
    }
}
