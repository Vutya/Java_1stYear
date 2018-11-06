package objects;

public class Student4 {

    // переменная для подсчёта числа студентов
    static private int count = 0;
    public static int getStudentsCount() {
        // System.out.println(name);
        // Из статического метода нельзя обращаться к нестатическим элементам класса. А наоборот можно.
        return count;
    }
    public static final double PI = 3.14;
    // static final поле часто делают публичным, это константа

    private String name;
    private int course;
    private final boolean b;

    public Student4(String name, int course) {
        this.name = name;
        this.course = course;
        System.out.println("Я создался! " + name);
        count++; // обновить количество студентов

        b = true; // значение final можно задать сразу или в конструкторе.
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

}
