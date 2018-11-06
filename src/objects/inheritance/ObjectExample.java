package objects.inheritance;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectExample {

    /* Класс Object
    Все классы прямо или косвенно наследуют класс Object.

    Если написать public class X { ...
    Это значит, что public class X extends Object { ...

    У нас в иерархии животных
    Cat extends Animal extends Object
     */

    public static void main(String[] args) {
        // Следствие 1, переменная типа Object может хранить любой тип

        Object x = "asdf"; // x - String
        Object y = new File("c:/Windows");
        Object z = new ArrayList<String>();
        // Ctrl + Q - помощь по методу

        Object x1 = new int[] {10 ,20 ,30}; // Даже массив - это объект, потому что
        // не объекты - это 8 базовых типов

        Object y1 = 42; // Присвоили int, заворачивание в Integer

        // Метод println может распечатать что угодно, потому что он принимает Object в качестве аргумента
        System.out.println(new File("c:/Windows"));

        // Слествие 2, любой объект наследует все методы класса Object

        // Например, у любого объекта есть метод toString()
        // Он превращает в строку текста. Используется чаще всего только для отладки.

        List<String> list = Arrays.asList("asdf", "cc");
        System.out.println(list.toString());

        System.out.println(list); // toString вызывается автоматически

        /*
        @Override
        public String toString() {} - заголовок для переопределения метода
         */

        // Метод toString внутри Object по умолчанию печатает не очень понятную информацию c @.
        // Указывается тип элементов массива и внутренний номер массива.
        System.out.println(new int[0]);
        System.out.println("asdf".equals("asdf"));

        // Ещё один метод внутри Object - equals - сравнение объектов по содержанию.

        // "asdf".equals("asdf"); сравнения содержания строк
        // == сравнивает объекты(один и тот же или разные).
        // equals внутри Object  сравнивает так же, как и ==.

        // Практически во всех языках есть класс Object, от которого ВСЕ наследуют что-то.

    }
}
