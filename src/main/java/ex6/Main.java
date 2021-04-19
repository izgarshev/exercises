package main.java.ex6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("7. Implement a class Pair<E> that stores a pair of elements of type E. Provide\n" +
//                "accessors to get the first and second element.\n" +
//                "8. Modify the class of the preceding exercise by adding methods max and min,\n" +
//                "getting the larger or smaller of the two elements. Supply an appropriate type\n" +
//                "bound for E.\n" +
//                "9. In a utility class Arrays, supply a method\n" +
//                "Click here to view code image\n" +
//                "public static <E> Pair<E> firstLast(ArrayList<___> a)\n" +
//                "that returns a pair consisting of the first and last element of a. Supply an\n" +
//                "appropriate type argument.");
        //sol 8
        Pair<String> pair = new Pair<>("32", "56");
        System.out.println("max is: " + pair.getMax());
        System.out.println("min is: " + pair.getMin());

        //sol 9
        System.out.println(Arrays.firstLast(List.of(2,5,3,7,9,1,8)));
    }
}
