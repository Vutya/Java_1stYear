import java.util.*;
import java.io.File;
import java.util.Scanner;

public class CollectionsTasks {

    private static List<String> task1(int start, int end) {
        List<String> l = new ArrayList<>();
        for (int i = start; i <= end; i++)
            l.add(Integer.toString(i));
        return l;
    }

    private static List<String> task2(List<String> l) {
        List<String> res = new ArrayList<>();
        for (int i = l.size() - 1 ; i > 0; i--)
            res.add(l.get(i));
        return res;
    }

    private static void task2p(List<String> l) {
        Collections.reverse(l);
    }

    private static List<String> task31(List<String> l) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < l.size() / 2; i++)
            res.add(l.get(i * 2 + 1));
        return res;
    }

    private static List<String> task32(List<String> l) {
        List<String> res = new ArrayList<>();
        for (String s : l)
            if (Integer.parseInt(s) % 2 != 0)
                res.add(s);
        return res;
    }

    private static List<Integer> task33(List<Integer> l) {
        List<Integer> res = new ArrayList<>();
        for (Integer s : l)
            if (s % 2 == 1)
                res.add(s);
        return res;
    }

    private static void task31P(List<String> l) {
        for (int i = 0; i < l.size(); i++)
            l.remove(i);
    }

    private static void task32P(List<String> l) {
        List<String> tmp = new ArrayList<>();
        for (String s: l)
            if (Integer.parseInt(s) % 2 == 0)
                tmp.add(s);
        l.removeAll(tmp);
    }

    private static void task33P(List<Integer> l) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer s : l)
            if (s % 2 == 0)
                tmp.add(s);
        l.removeAll(tmp);
    }

    private static void task4(File file, Set<String> res) {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            while (in.hasNext())
                res.add(in.next().toLowerCase());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Task 1: " + task1(1, 100));

        System.out.println("Task 2: " + task2(task1(1, 100)));

        List<String> l11 = task1(1, 100);
        task2p(l11);
        System.out.println("Task 2 in place: " + l11);

        System.out.println("Task 3.1: " + task1(3, 9) + task31(task1(3, 9)));

        List<String> l1 = task1(3, 10);
        task31P(l1);
        System.out.println("Task 3.1 in place: " + l1);

        System.out.println("Task 3.2: " + task32(task1(1, 100)));

        List<String> l2 = new ArrayList<>(Arrays.asList("10", "20", "30", "30", "40", "11", "21", "31", "41", "40"));
        task32P(l2);
        System.out.println("Task 3.2 in place: " + l2);

        List<Integer> test = Arrays.asList(5, 6, 7, 8, 10, 42, 42, 5, 6); //unchangeable
        System.out.println("Task 3.3: " + task33(test));

        List<Integer> l3 = new ArrayList<>(); //changeable
        l3.add(5);
        l3.add(6);
        l3.add(7);
        l3.add(8);
        l3.add(10);
        l3.add(42);
        task33P(l3);
        System.out.println("Task 3.3 in place: " + l3);

        File f1 = new File("C://HW_Java", "book.txt");
        File f2 = new File("C://HW_Java", "book_edited.txt");
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new TreeSet<>();
        Set<String> s3 = new LinkedHashSet<>();
        task4(f2, s1);
        task4(f1, s2);
        task4(f2, s3);
        System.out.println(s1);
        System.out.println(s2.size());
        System.out.println(s3.size());
    }
}

