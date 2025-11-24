package concurrency;


import repository.*;
import util.FileLoader;
import util.LogUtil;
import model.*;


import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ParallelLoader {


public static CompletableFuture<Void> loadStudents(StudentRepository repo, String path) {
return CompletableFuture.runAsync(() -> {
LogUtil.log("Loading students...");
List<String> lines = FileLoader.load(path);
lines.parallelStream().forEach(line -> {
String[] a = line.split(",");
repo.add(new Student(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2])));
});
});
}


public static CompletableFuture<Void> loadGroups(GroupRepository repo, String path) {
return CompletableFuture.runAsync(() -> {
LogUtil.log("Loading groups...");
List<String> lines = FileLoader.load(path);
lines.parallelStream().forEach(line -> {
String[] a = line.split(",");
repo.add(new Group(Integer.parseInt(a[0]), a[1]));
});
});
}


public static CompletableFuture<Void> loadAuthors(AuthorRepository repo, String path) {
return CompletableFuture.runAsync(() -> {
LogUtil.log("Loading authors...");
List<String> lines = FileLoader.load(path);
lines.parallelStream().forEach(line -> {
String[] a = line.split(",");
repo.add(new Author(Integer.parseInt(a[0]), a[1]));
});
});
}


public static CompletableFuture<Void> loadBooks(BookRepository repo, String path) {
return CompletableFuture.runAsync(() -> {
LogUtil.log("Loading books...");
List<String> lines = FileLoader.load(path);
lines.parallelStream().forEach(line -> {
String[] a = line.split(",");
repo.add(new Book(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2])));
});
});
}
}
