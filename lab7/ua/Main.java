package ua;

import ua.exception.DataSerializationException;
import ua.model.*;
import ua.repository.EBookRepository;
import ua.util.ConfigUtil;
import ua.util.LogUtil;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogUtil.getLogger();

        try {
           
            String jsonPath = ConfigUtil.get("json.path");
            String yamlPath = ConfigUtil.get("yaml.path");

            logger.info("JSON path: " + jsonPath);
            logger.info("YAML path: " + yamlPath);

           
            EBookRepository repo = new EBookRepository();
            Author a1 = new Author("George", "Orwell", 1903);
            Author a2 = new Author("Aldous", "Huxley", 1894);

            EBook b1 = new EBook("1984", List.of(a1), "9780451524935", List.of(new FileData("url1", "PDF", 2.5, "fiction")));
            EBook b2 = new EBook("Brave New World", List.of(a2), "9780060850524", List.of(new FileData("url2", "EPUB", 3.0, "fiction")));

            repo.add(b1);
            repo.add(b2);

            repo.saveToJson(jsonPath);
            repo.saveToYaml(yamlPath);

            EBookRepository repo2 = new EBookRepository();
            repo2.loadFromJson(jsonPath, EBook[].class);

            System.out.println("\n📘 Data loaded from JSON:");
            repo2.getAll().forEach(System.out::println);

 
            EBookRepository repo3 = new EBookRepository();
            repo3.loadFromYaml(yamlPath, EBook[].class);

            System.out.println("\n📗 Data loaded from YAML:");
            repo3.getAll().forEach(System.out::println);

            boolean equal = repo.getAll().toString().equals(repo2.getAll().toString());
            System.out.println("\n✅ Data match after serialization: " + equal);

        } catch (DataSerializationException e) {
            logger.severe("Serialization error: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Unexpected error: " + e.getMessage());
        }

        logger.info("Program finished.");
    }
}
