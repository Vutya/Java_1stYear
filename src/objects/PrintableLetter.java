package objects;

public class PrintableLetter implements Printable {
    private char ch;
    private int count;

    public PrintableLetter(char c, int n) {
        this.ch = c;
        this.count = n;
    }

    @Override
    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(ch);
        System.out.println();
    }
}
