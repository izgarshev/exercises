package main.java.ex6;

import java.util.List;

public class Arrays {
    /**
     * возвращает пару из первого и последнего элементов коллекции
     */
    public static <E extends Comparable<E>> Pair<E> firstLast(List<E> list) {
        if (list.size() < 2) {
            System.out.println("размер коллекции недостаточен для правильной работы метода");
            return null;
        }
        return new Pair<>(list.get(0), list.get(list.size() - 1));
    }

}
