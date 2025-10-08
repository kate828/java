import ua.model.*;
import ua.util.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Author author = Author.createAuthor("george", "orwell", 1903);
        System.out.println("Author: " + author);

        Reader reader = Reader.createReader("alice", "smith", "R1001");
        System.out.println("Reader: " + reader);

        reader.setFavoriteAuthor(author);
        System.out.println("Reader's favorite author: " + reader.getFavoriteAuthor());

        FileResource file = FileResource.createFile("https://cdn.example.com/1984.pdf", "PDF", 2.3, "Document");
        System.out.println("File: " + file);

        LibraryAccess access = LibraryAccess.createLibraryAccess(reader, "1984", new Date(), new Date(System.currentTimeMillis() + 14L*24*3600*1000));
        System.out.println("Access: " + access);

        Author badAuthor = Author.createAuthor("x", "y", 999); // invalid
        System.out.println("Bad author created? " + (badAuthor != null));
    }
}
