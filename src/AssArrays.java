import java.util.HashMap;
import java.util.Map;

public class AssArrays {
    public static void main(String[] args) {
        /*
        Ассоциативные массивы

        В Python dict {'a':1, 'b':2}

        Java

        Массив [10 ,20, 30]
        1 --> 10
        2 --> 20
        3 --> 30

        Ассоциативный массив сопоставляет любым объектам
        "asdf" --> 10
        42 --> 20
        123 --> "zzz"

        Тип Map<Ключ, Значения>, например,
        Map<String, Integer> для подсчёта частот слов
        Map<String, String> для словаря: слово --> перевод
        Map<String, List<String>> для словаря: слово --> все возможные переводы

        Варианты
        HashMap, TreeMap, LinkedHashMap
        (см. HashSet, TreeSet, LinkedHashSet)
        - влияет на порядок перебора элементов
        Сначала был HashMap, потом HashSet
         */

        Map<String, Integer> m = new HashMap<>();
        m.put("abc", 3); // m["abc"] = 3
        m.put("xyz", 2);
        m.put("kek", 1);
        m.put("abc", 4); //перезапишет значения

        System.out.println(m.get("abc")); //получть 4

        System.out.println(m.get("lol")); //вернёт null
        System.out.println(m.getOrDefault("pqr",42));
        // Если нет значения, то вернёт default

        //m.containsKey("abc") проверить, если ключ
        //...множество других полезных функция

        //Перебор элементов множества
        for (String key: m.keySet()) //keySet() возвращает Set из ключей
            System.out.println(key + " --> " + m.get(key));

        //2 способ
        //m.entrySet(); // множесто entries, entry - пара ключ значений
        for (Map.Entry<String, Integer> e: m.entrySet())
            System.out.println(e.getKey() + " --> " + e.getValue());

        //3 способ (рекомендуемый и современный)
        m.forEach((key, value) -> {
            System.out.println(key + " --> " + value);
            //key - String, value - Integer
        });
    }
}
