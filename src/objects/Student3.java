package objects;
/*
У каждого элемента класса (метода, поля, конструктора, ...) есть модификатор доступа
1) private - виден только внутри класса
2) пустой (internal) - виден только в пакете (в каталоге) класса
3) protected - виден в пакете и в наследниках
4) public - виден везде
 */
public class Student3 {
    // 100% давайте поля делать приватными.
    // Считается, что поля - это внутренне состояние объекта, к которому
    // никто не должен иметь доступ, чтобы случайно его не испортить.
    // Более того, считается, что ненужно даже говорить другим классам, как устроего внутренее состояние.
    // Может, мы не храним имя и курс в явном виде, может мы их вообще берём из БД.
    String name;
    int course;

    // у нас методы и конструкторы почти всегда public.
    // приватными будем делать только вспомогательные методы
    // внутри класса, которые никто не должен иметь возможность вызваать.

    Student3(String name, int course) {
        this.name = name;
        this.course = course;
        // здесь this не убирается
    }

    public void greet() { // тип результата void, аргументов нет
        System.out.println("Привет, я " + name + " с курса " + course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Как написать то же самое для course
    // Alt + Ins

    public void setCourse(int course) {
        this.course = course;
    }
}