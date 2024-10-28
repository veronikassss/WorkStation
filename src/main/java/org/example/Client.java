package org.example;

import java.util.Objects;

public class Client {

    static int nextId = 1;

    String name;
    int age;
    String city;
    int ID;

    {
        ID = nextId;
        nextId++;
    }

    public Client(String name, int age, String city) {

        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return age == client.age &&
                name.equals(client.name) &&
                city.equals(client.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Client{name = " + name + ", age = " + age + ", city = " + city + "}";

    }
    public String write() {
        return String.join(",", name, String.valueOf(age), city);
    }

}

