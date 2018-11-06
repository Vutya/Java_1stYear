import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class StreamsTasks {
    public static void Task1(int n) {
        System.out.println("Сумма чисел от 1 до " + n + " = " + IntStream.rangeClosed(1, n).sum());
        System.out.println("Сумма квадратов чисел от 1 до " + n + " = " + IntStream.rangeClosed(1,n).
                                                                            map(x -> x * x).sum());
        System.out.println("Сумма кубов чисел от 1 до " + n + " = " + IntStream.rangeClosed(1,n).
                                                                            map(x -> x * x * x).sum());
        System.out.println("Сумма обратных чисел от 1 до " + n + " = " + IntStream.rangeClosed(1,n).
                                                                            mapToDouble(x ->  (double) 1 / x).sum());
    }

    public static List<Integer> Task2(List<Integer> in) {
        return in.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
    }

    public static void Task3(File f) {
        try {
            byte[] fileAsBytes = Files.readAllBytes(f.toPath());
            String fileAsText = new String(fileAsBytes, "UTF-8");
            IntSummaryStatistics stat = Arrays.stream(fileAsText.split("\\s+")).
                                        collect(Collectors.summarizingInt(String::length));
            System.out.println("Average: " + stat.getAverage());
            System.out.println("Max: " + stat.getMax());
            System.out.println("Min: " + stat.getMin());
            int maximum = stat.getMax();
            System.out.println(Arrays.stream(fileAsText.split("\\s+")).
                                        filter(l -> l.length() == maximum).collect(joining(" ")));
        } catch (Exception e) {
            System.out.println("Failed to read file " + f);
        }
    }

    public static void Task4() {
        Random r = new Random();
        int heads = IntStream.generate(() -> r.nextInt(2)).limit(100).sum();
        int tails = 100 - heads;
        System.out.println(heads + "-орёл, " + tails + "-решка");
    }

    public static void main(String[] args) {
        System.out.println("Task 1");
        Task1(91);

        System.out.println("\nTask 2");
        List<Integer> l =  Arrays.asList(5, 6, 7, 8, 10, 42, 42, 5, 6, 7, 13, 239, 178, 93, 104, 0, -2, -3  );
        List<Integer> new_l = Task2(l);
        System.out.println(new_l);

        System.out.println("\nTask 3");
        File f = new File("book_edited.txt");
        Task3(f);

        System.out.println("\nTask 4");
        Task4();


    }
}
