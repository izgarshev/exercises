package main.java.ex4;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
