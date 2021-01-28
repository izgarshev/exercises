package main.java.ex8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Verify that asking for the first five long words does not call the filter method
 * once the fifth long word has been found. Simply log each method call.
 * 2. Measure the difference when counting long words with a parallelStream
 * instead of a stream. Call System.currentTimeMillis before and after
 * the call and print the difference. Switch to a larger document (such as War and
 * Peace) if you have a fast computer.
 * 3. Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
 * <p>
 * Stream.of(values)? How do you get a stream of int instead?
 * 4. Using Stream.iterate, make an infinite stream of random numbers—not by
 * calling Math.random but by directly implementing a linear congruential
 * generator. In such a generator, you start with x0
 * = seed and then produce xn + 1 =
 * (a xn
 * + c) % m, for appropriate values of a, c, and m. You should implement a
 * method with parameters a, c, m, and seed that yields a Stream<Long>. Try
 * out a = 25214903917, c = 11, and m = 248
 * .
 * 5. The codePoints method in Section 8.3, “The filter, map, and flatMap
 * Methods” (page 263) was a bit clumsy, first filling an array list and then turning it
 * into a stream. Write a stream-based version instead, using the
 * IntStream.iterate method to construct a finite stream of offsets, then
 * extract the substrings.
 * 6. Use the String.codePoints method to implement a method that tests
 * whether a string is a word, consisting only of letters. (Hint:
 * Character.isAlphabetic.) Using the same approach, implement a method
 * that tests whether a string is a valid Java identifier.
 * 7. Turning a file into a stream of tokens, list the first 100 tokens that are words in the
 * sense of the preceding exercise. Read the file again and list the 10 most frequent
 * words, ignoring letter case.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution5("solution"));
        System.out.println(solution6("somestring"));
    }

    /**
     * возвращает IntStream с шагом 1 и величиной в длину переданной строки
     */
    public static IntStream solution5(String s) {
        return IntStream.iterate(0, value -> value < s.length(), operand -> operand + 1);
    }

    /**
     * проверяет состоит ли строка только из букв
     * если строка только из букв, то вернется true
     */
    private static boolean solution6(String s) {
        List<String> collect = codePoints(s)
                .filter(s1 -> {
                    System.out.println(s1);
                    return !Character.isAlphabetic(s1.charAt(0));
                })
                .collect(Collectors.toList());
        return collect.isEmpty();
    }

    private static void solution7() {

    }

    public static Stream<String> codePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }
        return result.stream();
    }


}
