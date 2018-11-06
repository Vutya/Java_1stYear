package objects;

public class PrintableExample {
    public static void main(String[] args) {
        Drawing lines = new Drawing(12, 25, ' ');
        lines = lines.drawLine(0,0, 6,3, '*');
        lines = lines.drawLine(0,20, 6,5, '*');
        lines = lines.drawLine(11,20, 11,0, '*');
        lines = lines.drawLine(11, 24, 0, 24, '*');
        lines = lines.drawLine(7, 12, 3, 19, '*');


        PrintableLetter pl = new PrintableLetter('x', 10);

        PrintableString ps = new PrintableString("asdf");

        Printable pa = new Printable() {
            @Override
            public void print() {
                System.out.println("You haven't seen me, I'm anonymous.");
            }
        };

        Printable plambda = () -> {
            System.out.println("You haven't seen me too, I'm from Lambda.");
        };

        Printable[] arr = {lines, pl, ps, pa, plambda};

        for (Printable p: arr)
            p.print();
    }
}
