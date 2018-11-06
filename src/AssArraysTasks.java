import java.io.File;
import java.util.*;

public class AssArraysTasks {

    private static Map<Character, Integer> task1(String e){
        Map<Character, Integer> res = new HashMap<>();
        for (char c: e.toCharArray()) {
//          res.putIfAbsent(c, 0);
            res.put(c, res.getOrDefault(c,0) + 1);
        }
        return res;
    }

    private static Map<Character, List<Integer>> task2(String e){
        Map<Character, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < e.length(); i++) {
            char c = e.charAt(i);
            if (res.containsKey(c))
                res.get(c).add(i);
            else {
                List<Integer> t = new ArrayList<>();
                t.add(i);
                res.put(c, t); //res[c] = t
            }
        }
        return res;
    }

    private static Map<String, Integer> task3(File f, Map<String, Integer> d) {
        try (Scanner in = new Scanner(f, "UTF-8")) {
            while (in.hasNext()) {
                String word = in.next();
                d.putIfAbsent(word, 0);
                d.put(word, d.get(word) + 1);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return d;
    }

    private static void task3Sort(Map<String, Integer> d) {
        List<Map.Entry<String, Integer>> l = new ArrayList<>(d.entrySet());
        l.sort((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<String, Integer> entry : l)
            System.out.println(entry.getKey() + " " + Integer.toString(entry.getValue()));
    }

    public static void main(String[] args) {
        Map<Character, Integer> res1 = task1("banana");
        res1.forEach((key, value) -> {
            System.out.println(key + " --> " + value);
        });

        Map<Character, List<Integer>> res2 = task2("banana");
        res2.forEach((key, value) -> {
            System.out.println(key + " --> " + value);
        });

        File f = new File("book_edited.txt");
        Map<String, Integer> d1 = new HashMap<>();
        Map<String, Integer> d2 = new TreeMap<>();
        Map<String, Integer> d3 = new LinkedHashMap<>();
        d1 = task3(f, d1);
        d2 = task3(f, d2);
        d3 = task3(f, d3);
        System.out.println(d1.size());
        System.out.println(d2.size());
        System.out.println(d3.size());
        task3Sort(d1);
    }
}
