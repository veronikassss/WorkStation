package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Parser {

    static final String pathWay = "C:\\Users\\USER\\IdeaProjects\\WorkWithClientss\\src\\main\\resources";

        public List<String[]> parseFile(String filename) {

            Path path = Paths.get(pathWay + filename);

            List<String> lines = readAllLines(path);
            List<String[]> futureClients = new ArrayList<>();

            for (String line : lines) {
                String[] data = line.split(",");
                futureClients.add(data);
            }

            return futureClients;
        }

    public List<String> readAllLines(Path path) {

        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
