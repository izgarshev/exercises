package main.java.ex5;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "float_file.txt";
        System.out.println("сумма прочитанных чисел: " + sumOfValues(filename));//solution 4
        solution5();

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
        File file = new File("output.txt");
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("C:\\Code\\exercises\\src\\main\\java\\ex5\\strings.txt"));
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
     * 6. Section 5.1.6, “The finally Clause” (page 189) has an example of a broken try
     * statement with catch and finally clauses. Fix the code with (a) catching the
     * exception in the finally clause, (b) a try/catch statement containing a
     * try/finally statement, and (c) a try-with-resources statement with a catch
     * clause.
     =
     */
}
