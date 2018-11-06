package objects;

public class PrintableString implements Printable {
    private String str;

    public PrintableString(String s) {
        this.str = s;
    }

    @Override
    public void print() {
        System.out.println(this.str);
    }
}
