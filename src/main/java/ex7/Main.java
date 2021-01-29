package main.java.ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 1. Implement the “Sieve of Erathostenes” algorithm to determine all prime numbers
 * ≤ n. Add all numbers from 2 to n to a set. Then repeatedly find the smallest
 * element s in the set, and remove s
 * 2
 * , s · (s + 1), s · (s + 2), and so on. You are done
 * when s
 * 2
 * > n. Do this with both a HashSet<Integer> and a BitSet.
 * 2. In an array list of strings, make each string uppercase. Do this with (a) an iterator,
 * (b) a loop over the index values, and (c) the replaceAll method.
 * 3. How do you compute the union, intersection, and difference of two sets, using just
 * the methods of the Set interface and without using loops?
 * 4. Produce a situation that yields a ConcurrentModificationException.
 * What can you do to avoid it?
 * <p>
 * 5. Implement a method public static void swap(List<?> list,
 * int i, int j) that swaps elements in the usual way when the type of list
 * implements the RandomAccess interface, and that minimizes the cost of visiting
 * the positions at index i and j if it is not.
 * 6. I encouraged you to use interfaces instead of concrete data structures—for
 * example, a Map instead of a TreeMap. Unfortunately, that advice goes only so
 * far. Suppose you have a method parameter of type Map<String,
 * Set<Integer>>, and someone calls your method with a HashMap<String,
 * HashSet<Integer>>. What happens? What parameter type can you use
 * instead?
 * 7. Write a program that reads all words in a file and prints out how often each word
 * occurred. Use a TreeMap<String, Integer>.
 */
public class Main {
    private static File textFile = new File("src/main/java/ex7/text.txt");
    public static void main(String[] args) throws FileNotFoundException {
        solution4();
        swap(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 2, 3);//solution5
        solution6(new HashMap<String, HashSet<Integer>>());
        solution7();
    }

    /**
     * самый простой вариант - заменить параметр Set на HashSet
     * @param map
     */
    private static void solution6(HashMap<String, HashSet<Integer>> map) {
        System.out.println(map);
    }



    private static void solution4() {
        //здесь будет ConcurrentModificationException, т.к мы пытаемся внести изменения в коллекцию во время работы итератора
//        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
//        for (Integer number : list) {
//            System.out.println("number: " + number);
//            if (number.equals(2)) {
//                list.add(5);
//            }
//        }
        //чтобы избежать исключения мы добавляем новый элемент после работы итератора
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        for (Integer number : list) {
            System.out.println("number: " + number);
        }
            list.add(5);
        for (Integer number : list) {
            System.out.println("number: " + number);
        }
    }

    /**
     * метод меняет местами элементы, под указанными номерами
     */
    public static void swap(List<?> list, int i, int j) {
        System.out.println(list);
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
        System.out.println(list);
    }

    private static void solution7() throws FileNotFoundException {
        List<String> words = loadText(textFile);
        System.out.println("Occurrences: " + countOccurrence(words).toString());
    }

    private static Map<String, Integer> countOccurrence(List<String> words) {
        Map<String, Integer> occurrences = new TreeMap<>();
        for (String word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
        return occurrences;
    }

    private static List<String> loadText(File filename) throws FileNotFoundException {
        if (filename == null || !filename.exists()) {
            throw new IllegalArgumentException("Error: filename incorrect");
        }

        List<String> result = new ArrayList<>();
        Scanner in = new Scanner(filename);
        while (in.hasNext()) {
            result.add(in.next());
        }

        return result;
    }
}
