import ua.model.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНА 1 — Library Access Demo ===");

        Author author = Author.createAuthor("george", "orwell", 1903);
        System.out.println("Author: " + author);

        Reader reader = Reader.createReader("alice", "smith", "R1001");
        reader.setFavoriteAuthor(author);
        System.out.println("Reader: " + reader);
        System.out.println("Reader's favorite author: " + reader.getFavoriteAuthor());

        FileResource file = FileResource.createFile("https://cdn.example.com/1984.pdf", "PDF", 2.3, "Document");
        System.out.println("File: " + file);

        LibraryAccess access = LibraryAccess.createLibraryAccess(
                reader,
                "1984",
                new Date(),
                new Date(System.currentTimeMillis() + 14L*24*3600*1000)
        );
        System.out.println("Access: " + access);

        // Приклад невдалого створення (ЛР1)
        Author badAuthor = Author.createAuthor("x", "y", 999);
        System.out.println("Bad author created? " + (badAuthor != null));

        System.out.println("\n=== ЛАБОРАТОРНА 2 — EBook & FileRecord Demo ===");

        FileRecord f1 = FileRecord.of("https://cdn.example.com/1984.pdf", "pdf", 2.5, "Document");
        FileRecord f2 = FileRecord.of("https://cdn.example.com/audio1984.mp3", "mp3", 45.0, "Audio");
        System.out.println("FileRecord 1: " + f1);
        System.out.println("FileRecord 2: " + f2);

        EBookRecord ebook = EBookRecord.create(
                "1984",
                List.of("George Orwell"),
                "9780451524935",
                "fiction",
                List.of(f1, f2)
        );

        System.out.println("EBook record: " + ebook);
        System.out.println("Files in EBook: " + ebook.files());

        System.out.println("Parsed format for 'epub': " + FileFormat.EPUB);
    }
}
