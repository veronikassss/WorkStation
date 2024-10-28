package org.example;

import java.util.*;

public class Repository {

    List<Client> storage = new ArrayList<>();
    Set<Client> uniqueClients = new HashSet<>();

    public void save(List<Client> clients) {

        for (Client client : clients) {
            if (uniqueClients.add(client)) {
                storage.add(client);
            }
        }
    }
    public List<Client> filterOfDublicaters(List<Client> clients) {

        HashSet<Client> set = new HashSet<>(clients);
        return new ArrayList<>(set);
    }

    public List<Client> getAll() {

        List<Client> clients = new ArrayList<>(storage);

        if(storage.isEmpty()) {
            System.out.println("We dont have clients");
        } else {
            System.out.println("There are such clients: ");

            for (Client client : clients) {
                System.out.println(client);
            }
        }

        return clients;
    }

    public Client getByID(int ID) {

        for (Client client : storage) {
            if(client.getID() == ID) {
                return client;
            }
        }
        return null;
    }

    public Client deleteByID(int ID) {

        Client foundClient = null;
        Iterator<Client> iterator = storage.iterator();

        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getID() == ID) {
                foundClient = client;
                iterator.remove();
                System.out.println("The client was delete");
            }
        }

        if (foundClient == null) {
            System.out.println("Sorry, we don't have such client");
        }

        return foundClient;
    }
}
