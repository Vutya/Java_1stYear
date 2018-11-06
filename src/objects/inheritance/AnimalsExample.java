package objects.inheritance;

public class AnimalsExample {
    public static void main(String[] args) {
        Animal a1 = new Animal("Barsik");
        Animal a2 = new Animal("Bobik");
        Animal a3 = new Animal("Burennka");

        a1.greet();
        a2.greet();
        a3.greet();

        // Cat c1 = new Cat();
        // такой конструктор странный, животное не создаётся без имени.
        // Кот - животное.

        // Принцип конструирования объекта. При создании объекта
        // вызываются по очереди конструкторы всех базовых классов.
        // Т.е. при создании Cat должен сначала вызваться Animal, а
        // потом уже Cat.

        // Поэтому при наследовании в конструкторе потомка обязательно
        // вызывается конструктор предка.

        Cat c1 = new Cat();
        Cat c2 = new Cat("Barsik");
        c1.greet(); // Murzik
        c2.greet(); // Barsik

        // Если в базовом классе есть конструктор без аргументов,
        // то можно ничего не писать, даже super.

        c1.catchAMouse();
        c1.catchAMouse();
        // a1.catchAMouse(); // нет такой возможности

        Animal a5 = new Animal("Animal 1");
        Cat c3 = new Cat("Animal 2");

        System.out.println(a5.getSound()); // pfff
        System.out.println(c3.getSound()); // meow

        // Переменная базового класса может хранить объект класса-потомка.
        Animal a6 = new Cat("Animal 3");
        System.out.println(a6.getSound()); // meow

        // List<String> l = new ArrayList<String>().

        c1.catchAMouse();
        // a5.catchAMouse(); не работает, очевидно
        // a6.catchAMouse(); не работает, так как для джавы
        // a6 - Animal, у которого нет метода catchAMouse

        // Но если мы точно знаем, что a6 - Cat, то как вызвать метод?
        ((Cat) a6).catchAMouse(); // приведение типов
        Cat c6 = (Cat) a6; // объект один и тот же, но него
        // указывают переменные разных типов.
        
        // вообще, проверка типа делается оператором instanceof
        System.out.println(a6 instanceof Cat); // true
        System.out.println(a5 instanceof Cat); // false
    }
}
