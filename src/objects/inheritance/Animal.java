package objects.inheritance;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return "pfffff";
    }

    public void greet() {
        System.out.println("Hallo, I'm " + name);
    }
}
