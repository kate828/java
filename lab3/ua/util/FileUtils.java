package ua.util;

import ua.exception.InvalidDataException;
import ua.model.*;

import java.io.*;
import java.util.*;

public class FileUtils {

    public static List<Author> readAuthors(String path) throws IOException {
        List<Author> authors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3)
                    throw new InvalidDataException("Некоректний запис автора: " + line);
                authors.add(new Author(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (InvalidDataException e) {
            System.err.println(e.getMessage());
        }
        return authors;
    }

    public static List<EBook> readEBooks(String path) throws IOException {
        List<EBook> ebooks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3)
                    throw new InvalidDataException("Некоректний запис книги: " + line);
                ebooks.add(new EBook(parts[0], new ArrayList<>(), parts[1], new ArrayList<>()));
            }
        } catch (InvalidDataException e) {
            System.err.println(e.getMessage());
        }
        return ebooks;
    }

    public static List<Reader> readReaders(String path) throws IOException {
        List<Reader> readers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3)
                    throw new InvalidDataException("Некоректний запис читача: " + line);
                readers.add(new Reader(parts[0], parts[1], parts[2]));
            }
        } catch (InvalidDataException e) {
            System.err.println(e.getMessage());
        }
        return readers;
    }
}
