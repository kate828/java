package util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileLoader {
public static List<String> load(String path) {
try {
return Files.readAllLines(Paths.get(path));
} catch (IOException e) {
throw new RuntimeException("Cannot load file: " + path, e);
}
}
}
