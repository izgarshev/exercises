package main.java.ex5;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Path path = new File("./main/java/ex5/strings.txt").toPath();
    public static void main(String[] args) {
//        String filename = "float_file.txt";
//        System.out.println("сумма прочитанных чисел: " + sumOfValues(filename));//solution 4
        solution5();
//        solution6a();
//        solution6b();
//        solution6c();

        //упражнение 7. Первый вариант предпочтительней, т.к. если во время выполнения метод выбросит исключение,
        //например, во время вызова
        //конструктора PrintWriter, то будет вызван in.close() (у Scanner) и ресурсы будут закрыты.
        //Во втором случае in.close() вызван не будет
        //и ресурсы останутся не закрытыми
    }

    /**
     * метод читает строки из файла, преобразует строку в Double и добавляет в ArrayList
     *
     * @param filename название файла
     * @return список значений
     */
    private static ArrayList<Double> readValues(String filename) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("filename incorrect");
        }
        ArrayList<Double> doubles = new ArrayList<>();
        URL url = Main.class.getResource(filename);
        if (url != null) {
            File file = new File(url.getPath());
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    doubles.add(Double.valueOf(scanner.nextLine()));
                }
            } catch (FileNotFoundException e) {
                System.out.println("ошибка, файл не найден");
            } catch (NumberFormatException e) {
                System.out.println("ошибка преобразования строки в число");
            }

        }
        return doubles;
    }

    /**
     * @param filename название файла
     * @return сумма значений
     */
    private static double sumOfValues(String filename) {
        double sum = 0;
        for (Double d : readValues(filename)) {
            sum += d;
        }
        return sum;
    }

    private static void solution5() {
        File file = new File("src/main/java/ex5/output.txt");
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("src/main/java/ex5/strings.txt"));
            out = new PrintWriter(file);
            out.write("start");
            while (in.hasNextLine()) {
                out.println(in.nextLine().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            closeResources(in, out);
        } finally {
            closeResources(in, out);
        }
    }

    private static void closeResources(Scanner scanner, PrintWriter writer) {
        if (scanner != null) scanner.close();
        if (writer != null) writer.close();
    }

    /**
     * catching the exception in the finally clause
     */
    public static void solution6a() {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * a try/catch statement containing a
     *      * try/finally statement
     */
    public static void solution6b() {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            try {
                in.close();
            } finally {
                System.out.println("finally block b");
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    /**
     * a try-with-resources statement with a catch
     *      * clause.
     */
    public static void solution6c() {
        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
