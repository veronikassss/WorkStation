package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {

    static final String path = "C:\\Users\\USER\\IdeaProjects\\WorkWithClientss\\src\\main\\resources";

    public boolean download(List<Client> clients, String filename) {
        try (FileWriter writer = new FileWriter(path + filename)) {
            for (int i = 0; i < clients.size(); i++) {
                writer.write(clients.get(i).write() + "\n");
            }
            System.out.println("The download is success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ops...some mistake");
            return false;
        }
    }
}
