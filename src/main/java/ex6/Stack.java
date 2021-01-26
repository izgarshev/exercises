package main.java.ex6;

import java.util.ArrayList;
import java.util.List;

class Stack<E>  {
    private List<E> items;

    Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        this.items = new ArrayList<>(size);
    }

    public void push(E item) {
        this.items.add(item);
    }

    public E pop() {
        if (this.items.isEmpty()) {
            throw new IndexOutOfBoundsException("The stack is empty!");
        }
        return this.items.remove(this.items.size() - 1);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }
}