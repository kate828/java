import concurrency.*;
import repository.*;
import util.LogUtil;


public class Main {
public static void main(String[] args) throws Exception {
StudentRepository students = new StudentRepository();
GroupRepository groups = new GroupRepository();
AuthorRepository authors = new AuthorRepository();
BookRepository books = new BookRepository();


LogUtil.log("Starting parallel loading...");


CompletableFuture.allOf(
ParallelLoader.loadStudents(students, "src/resources/students.txt"),
ParallelLoader.loadGroups(groups, "src/resources/groups.txt"),
ParallelLoader.loadAuthors(authors, "src/resources/authors.txt"),
ParallelLoader.loadBooks(books, "src/resources/books.txt")
).join();


LogUtil.log("All data loaded. Running comparisons...");


PerformanceComparator.testParallelStream(students.getAll());
PerformanceComparator.testExecutorService(students.getAll());


LogUtil.log("Done.");
}
}
