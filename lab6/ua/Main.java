package ua;

import ua.model.*;
import ua.repository.*;
import ua.util.LogUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogUtil.getLogger();

        EBookRepository ebookRepo = new EBookRepository();
        ReaderRepository readerRepo = new ReaderRepository();
        LibraryAccessRepository accessRepo = new LibraryAccessRepository();

        Author a1 = new Author("George", "Orwell", 1903);
        Author a2 = new Author("Aldous", "Huxley", 1894);
        Reader r1 = new Reader("Anna", "Ivanova", "R01");
        Reader r2 = new Reader("Bohdan", "Petrenko", "R02");

        EBook b1 = new EBook("1984", List.of(a1), "9780451524935",
                List.of(new FileData("url1", "PDF", 2.5, "fiction")));
        EBook b2 = new EBook("Brave New World", List.of(a2), "9780060850524",
                List.of(new FileData("url2", "EPUB", 3.0, "fiction")));

        ebookRepo.add(b1);
        ebookRepo.add(b2);
        readerRepo.add(r1);
        readerRepo.add(r2);

        accessRepo.add(new LibraryAccess(r1, b1, LocalDate.now().minusDays(10), LocalDate.now().minusDays(1)));
        accessRepo.add(new LibraryAccess(r2, b2, LocalDate.now().minusDays(2), LocalDate.now().plusDays(5)));

        System.out.println("\n📚 All EBooks:");
        ebookRepo.printAll();

        System.out.println("\n🔍 Find by Author (Huxley):");
        ebookRepo.findByAuthor("Huxley").forEach(System.out::println);

        System.out.println("\n⏳ Expired Access:");
        accessRepo.findExpired(LocalDate.now()).forEach(System.out::println);

        System.out.println("\n⚙️ Stream vs ParallelStream Performance Test:");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) numbers.add(i);

        long t1 = System.currentTimeMillis();
        long sum1 = numbers.stream().reduce(0, Integer::sum);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        long sum2 = numbers.parallelStream().reduce(0, Integer::sum);
        long t4 = System.currentTimeMillis();

        System.out.println("Stream time: " + (t2 - t1) + " ms");
        System.out.println("ParallelStream time: " + (t4 - t3) + " ms");

        logger.info("Program finished successfully.");
    }
}
