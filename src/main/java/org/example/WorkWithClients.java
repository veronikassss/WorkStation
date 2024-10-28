package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkWithClients {

    private static final Parser parser = new Parser();
    private static final Repository repository = new Repository();
    private static final MyFileWriter myFileWriter = new MyFileWriter();
    private static final Scanner scr = new Scanner(System.in);

    public void work() {

        passAndSave(parser, "output.txt", repository);

        menu();

        while (true) {

            int option = scr.nextInt();
            scr.nextLine();

            switch (option) {
                case 1:
                    passerAndSaveInRepository();
                    menu();
                    break;
                case 2:
                    repository.getAll();
                    menu();
                    break;
                case 3:
                    findClientByID();
                    menu();
                    break;
                case 4:
                    deleteClientByID();
                    menu();
                    break;
                case 5:
                    closeAndSaveInComputer();
                    break;
                default:
                    System.out.println("sorry, but we can make only 5 option, choose one of this!");
            }
        }
    }

    private static void deleteClientByID() {
        int ID = printID( "Write ID, please: ");
        Client client = repository.deleteByID(ID);
        System.out.println(client + " was deleted!");
    }

    private static void closeAndSaveInComputer() {
        printMessage("waiting...we are saving your data");
        List<Client> all = repository.getAll();
        boolean ready = myFileWriter.download(all, "output.txt");
        printMessage("okay, now bye!");
    }

    private static void findClientByID() {
        int ID = printID( "Write ID, please: ");
        Client client = repository.getByID(ID);
        System.out.println(client);
    }

    private void passerAndSaveInRepository() {
        printMessage("write the name of the file: ");
        String filename = scr.nextLine();

        passAndSave(parser, filename, repository);
        printMessage("Clients are saved!");
    }

    private static int printID(String message) {
       printMessage(message);
       return scr.nextInt();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void menu() {
        System.out.println("choose the option: \n1. save the client\n" +
                "2. get all client\n" +
                "3. search by the ID\n" +
                "4. delete the client by ID\n" +
                "5. exit");
    }


    public void passAndSave(Parser parser, String filename, Repository repository) {

        List<String[]> data = parser.parseFile(filename);
        List<Client> clients = convertToClientList(data);
        repository.save(clients);
    }

    public List<Client> convertToClientList(List<String[]> dataFile) {

        List<Client> clientList = new ArrayList<>();

        for (String[] data : dataFile) {
            if(data.length >= 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String city = data[2];
                Client client = new Client(name,age,city);
                clientList.add(client);
            }
        }
        return clientList;
    }
}
