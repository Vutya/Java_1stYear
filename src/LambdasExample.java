import java.io.File;
import java.util.Arrays;

public class LambdasExample {
    public static void main(String[] args) {

        // Сортировка списка/массива

        String[] a = {"abc", "pq", "x", "oil"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        /*
        Comparator, сравниватель. Волшебное устройство,
        которому можно дать две строки, и он говорит, какое
        из утверждений верно:
        1) первая строчка "больше" второй
        2) первая строчка "меньше" второй
        3) первая строчка "равна" второй

        Лексикографический компратора сравнивает первую букву.
        Компаратор длин сравнивает строки их длинами.

        Фактичкски, компаратор - это функция.

    int compare1(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        if (s1.length() == s2.length())
            return 0;
        return -1;
    }

    int compare2(String s1, String s2) {
        return s1.length() - s2.length()
    }

    Юзаем лямбду
    #1 - ставим одну стрелку
    */
        Arrays.sort(a, (String s1, String s2) -> {
            return s1.length() - s2.length();
            });
        System.out.println(Arrays.toString(a));

        // практически всегда можно не писать типы аргументов

        Arrays.sort(a, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(Arrays.toString(a));

        // если единственное, что делает функция - это return,
        // то фигурные скобки можно не писать

        Arrays.sort(a, (String s1, String s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(a));

        // ещё один пример лямбда-выражений
        // мы умеем смотреть список файлов в каталоге
        String[] files = new File("c:/HW_Python").list();
        if (files != null)
            for (String file: files)
                System.out.println(file);

        // напишем фильтр для файлов
        // фильтр, который определяет, какие файлы должны быть выбраны
        /*
        boolean filter(String filename) {
            return filename.endsWith(".exe");
        }
         */
        String[] files2 = new File("c:/windows").list(
                (folder, filename) -> filename.endsWith(".exe")
        );
        for (String file: files2)
            System.out.println(file);
    }
}
