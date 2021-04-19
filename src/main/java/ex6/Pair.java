package main.java.ex6;

public class Pair<E extends Comparable<E>> {
    E first;
    E last;

    public Pair(E first, E last) {
        this.first = first;
        this.last = last;
    }

    public E getFirst() {
        return first;
    }

    public E getLast() {
        return last;
    }

    public E getMax() {
        if (first.compareTo(last) > 0) {
            return first;
        } else return last;
    }

    public E getMin() {
        if (first.compareTo(last) > 0) {
            return last;
        } else return first;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
