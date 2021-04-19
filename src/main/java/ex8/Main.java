package main.java.ex8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
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
 * 8. Find a realistic use for the Collectors.flatMapping method. Consider
 * some class with a method yielding an Optional. Then group by some
 * characteristic and, for each group, collect the nonempty optional values by using
 * flatMapping and Optional.stream.
 * 9. Read the words from /usr/share/dict/words (or a similar word list) into a
 * stream and produce an array of all words containing five distinct vowels.
 */
public class Main {
    private final static String vowels = "aeiouy";
    public static void main(String[] args) {
//        System.out.println(solution5("solution"));
//        System.out.println(solution6("somestring"));
//        solution7();
        sol8();
        sol9();
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
                .filter(s1 -> !Character.isAlphabetic(s1.charAt(0)))
                .collect(Collectors.toList());
        return collect.isEmpty();
    }

    private static void solution7() {
        try (Scanner scanner = new Scanner(Path.of("src/main/java/ex7/text.txt"));
             Scanner scanner2 = new Scanner(Path.of("src/main/java/ex7/text.txt"))) {
            Stream<String> words = scanner.tokens();
            final int[] count = {0};
            List<String> result = new ArrayList<>();
            words.forEach(s -> {
                if (solution6(s)) {
                    if (count[0] < 100) {
                        result.add(s);
                    }
                    count[0]++;
                    System.out.println("count: " + count[0]);
                }
            });
            for (int i = 0; i < result.size(); i++) {
                System.out.println(i + " " + result.get(i));
            }
            System.out.println(result);

            //вывод первых десяти часто встречающихся слов
            Stream<String> wordz = scanner2.tokens();
            Map<String, Integer> map = new HashMap<>();
            wordz.forEach(s -> map.merge(s.toLowerCase(), 1, Integer::sum));
            final int[] i = {0};
            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(stringIntegerEntry -> {
                        if (i[0] < 10) {
                            System.out.println(stringIntegerEntry);
                        }
                        i[0]++;
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    /**
     * Предположим, у нас есть класс Person и класс Address. Для определенного перечня персон есть перечень из n адресов.
     * Метод flatMapping может использоваться для объединения этих объектов в Map, где ключом будет Person, а значением коллекция Address, принадлежащих персоне.
     */
    public static void sol8() {
        List<Address> addressList = List.of(new Address("Moscow", "Lenina"), new Address("Petersburg", "Pushkina"), new Address("Voronezh", "Sovetskaya"));
        List<Person> list = List.of(new Person(1, "Sergey", List.of(addressList.get(0), addressList.get(1))), new Person(2, "Oleg", List.of(addressList.get(0), addressList.get(2))));
        Map<Person, List<Address>> personListMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.flatMapping(person -> person.getAddresses().stream(), Collectors.toList())));
        personListMap.forEach((person, addresses) -> System.out.println(person + addresses.toString()));
    }

    public static void sol9() {
        try {
            List<String> strings = main.java.ex7.Main.loadText(new File("src/main/java/ex8/words.txt"));
            List<String> result = strings.stream().filter(Main::isUniqueVowels).collect(Collectors.toList());
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }

    /**
     * метод проверяет состоит ли строка из 5 уникальных гласных букв
     */
    public static boolean isUniqueVowels(String s) {
        if (s == null || s.length() < 5) {
            return false;
        }
        List<Character> characters = new ArrayList<>();
        for (char c: vowels.toCharArray()) {
            characters.add(c);
        }
        String lowerCaseString = s.toLowerCase(Locale.ROOT);
        int count = 0;
        for (int i = 0; i < lowerCaseString.length(); i++) {
            for (int j = 0; j < characters.size(); j++) {
                if (characters.get(j) == lowerCaseString.charAt(i)) {
                    characters.remove(j);
                    count++;
                    if (count == 5) return true;
                }
            }
        }
        return false;
    }
}
