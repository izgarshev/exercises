package main.java.ex8;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private List<Address> addresses;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Person(int id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
