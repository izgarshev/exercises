package main.java.ex6;

/**
 * 1. Implement a class Stack<E> that manages an array list of elements of type E.
 * Provide methods push, pop, and isEmpty.
 * 2. Reimplement the Stack<E> class, using an array to hold the elements. If
 * necessary, grow the array in the push method. Provide two solutions, one with an
 * E[] array and one with an Object[] array. Both solutions should compile
 * without warnings. Which do you prefer, and why?
 * 3. Implement a class Table<K, V> that manages an array list of Entry<K, V>
 * elements. Supply methods to get the value associated with a key, to put a value for
 * a key, and to remove a key.
 * 4. In the previous exercise, make Entry into a nested class. Should that class be
 * generic?
 * 5. Consider this variant of the swap method where the array can be supplied with
 * varargs:
 * Click here to view code image
 * public static <T> T[] swap(int i, int j, T... values) {
 *  T temp = values[i];
 *  values[i] = values[j];
 *  values[j] = temp;
 *  return values;
 * }
 * Now have a look at the call
 * Click here to view code image

 * Double[] result = Arrays.swap(0, 1, 1.5, 2, 3);
 * What error message do you get? Now call
 * Click here to view code image
 * Double[] result = Arrays.<Double>swap(0, 1, 1.5, 2, 3);
 * Has the error message improved? What do you do to fix the problem?
 * 6. Implement a generic method that appends all elements from one array list to
 * another. Use a wildcard for one of the type arguments. Provide two equivalent
 * solutions, one with a ? extends E wildcard and one with ? super E.
 * 7. Implement a class Pair<E> that stores a pair of elements of type E. Provide
 * accessors to get the first and second element.
 */
public class Main {
    public static void main(String[] args) {

    }

}
