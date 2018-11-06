package objects;

public class DrawingExamples {
    public static void main(String[] args) {
        System.out.println("Creating object...");
        Drawing pic = new Drawing(10,10,'?');
        pic.print();

        System.out.println("Setting point...");
        Drawing pic1 = pic.setPoint(1,2,'*');
        pic1.print();

        System.out.println("Drawing vertical and horizonral lines...");
        Drawing pic2 = pic.drawVerticalLine(8, 4, 9, 'o');
        pic2 = pic2.drawHorizontalLine(9, 1,8,'i');
        System.out.println();
        pic2.print();

        System.out.println("Drawing rectangles...");
        pic2 = pic2.drawRectangle(1,1, 2, 2,'%');
        pic2 = pic2.drawRectangle(4,6, 7, 0,'@');
        System.out.println();
        pic2.print();

        System.out.println("Drawing lines...");
        Drawing lines = new Drawing(12, 25, ' ');
        lines = lines.drawLine(0,0, 6,3, '*');
        lines = lines.drawLine(0,20, 6,5, '*');
        lines = lines.drawLine(11,20, 11,0, '*');
        lines = lines.drawLine(11, 24, 0, 24, '*');
        lines = lines.drawLine(7, 12, 3, 19, '*');
        lines.print();

        System.out.println("Roma");
        Drawing Roma = new Drawing(12, 90, ' ');
        // Р
        Roma = Roma.drawLine(0 , 0, 11, 0, '*');
        Roma = Roma.drawLine(3, 17, 0, 0, '*');
        Roma = Roma.drawLine(3, 17, 8, 0, '*');
        // О
        // Roma.drawRectangle(1, 21, 11, 38, '*');
        Roma = Roma.drawCircle(6, 29, 5, '*');
        // М
        Roma = Roma.drawVerticalLine(42, 11, 1, '*');
        Roma = Roma.drawVerticalLine(60, 11, 1, '*');
        Roma = Roma.drawLine(10, 51, 1, 60, '*');
        Roma = Roma.drawLine(10, 51, 1, 42, '*');
        // А
        Roma = Roma.drawHorizontalLine(7, 79 , 68, '*');
        Roma = Roma.drawLine(1, 74, 10, 83, '*');
        Roma = Roma.drawLine(10, 65, 1, 74, '*');
        Roma.print();

        System.out.println("Drawing one picture over the other...");
        lines = lines.draw(1,1, pic2);
        lines = lines.draw(19, 5, pic2);
        System.out.println();
        lines.print();
        System.out.println("Copying object...");
        Drawing cop = new Drawing(lines);
        System.out.println();
        cop.print();

        System.out.println("Drawing house...");
        Drawing door = new Drawing(7, 7, ' ');
        door = door.drawRectangle(0 , 0, 6, 6, '#');
        door = door.setPoint(3, 5, '*');
        Drawing window1 = new Drawing(7, 7, ' ');
        window1 = window1.drawCircle(3, 3, 2, '@');
        Drawing window2 = new Drawing(5, 8, ' ');
        window2 = window2.drawRectangle(0, 0, 4, 7, '@');
        window2 = window2.drawVerticalLine(3, 1, 3, '|');
        window2 = window2.drawVerticalLine(4, 1, 3, '|');
        Drawing roof = new Drawing(8, 17, ' ');
        roof = roof.drawLine(7, 0, 0, 7, '/');
        roof = roof.drawLine(0, 9, 7, 16, '\\');
        roof = roof.setPoint(0, 8, '+');
        roof = roof.drawHorizontalLine(7, 1, 15, '-');

        Drawing house = new Drawing (19, 53, ' ');
        house = house.drawRectangle(18, 52, 7, 0, 'o');
        house = house.draw(0, 0, roof);
        house = house.draw(18, 0, roof);
        house = house.draw(36, 0, roof);
        house = house.draw(40, 11, door);
        house = house.draw(4, 11, window2);
        house = house.draw(16, 11, window2);
        house = house.draw(28, 11, window2);
        house = house.draw(23, 3, window1);
        house = house.draw(41, 3, window1);
        house = house.draw(5, 3, window1);
        house.print();
    }
}
