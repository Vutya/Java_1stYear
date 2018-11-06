package objects;

public class Drawing implements Printable {

    private int rows;
    private int columns;
    private char[][] img;

    public Drawing(int r, int c, char ch) {
        this.rows = r;
        this.columns = c;

        this.img = new char[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                this.img[i][j] = ch;
    }

    public Drawing(Drawing d) {
        this.rows = d.rows;
        this.columns = d.columns;

        this.img = new char[rows][columns];
        for (int i = 0; i < rows; i++)
            System.arraycopy(d.img[i], 0, this.img[i], 0, this.columns);
    }

    @Override
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(img[i][j]);
            System.out.println();
        }
    }

    public Drawing setPoint(int row, int col, char new_ch) {
        Drawing res = new Drawing(this);
//        try {
        res.img[row][col] = new_ch;
//        } catch (Exception e) {
//            System.out.println("Wrong coordinates.");
//        }
        return res;
    }

    public Drawing drawVerticalLine(int col, int row1, int row2, char s) {
        Drawing res = new Drawing(this);
        for (int i = Math.min(row1, row2); i <= Math.max(row1, row2); i++)
            res.img[i][col] = s;
        return res;
    }

    public Drawing drawHorizontalLine(int row, int col1, int col2, char s) {
        Drawing res = new Drawing(this);
        for (int i = Math.min(col1, col2); i <= Math.max(col1, col2); i++)
            res.img[row][i] = s;
        return res;
    }

    public Drawing drawRectangle(int row1, int col1, int row2, int col2, char s) {
        Drawing res = new Drawing(this);
        res = res.drawVerticalLine(col1, row1, row2, s);
        res = res.drawVerticalLine(col2, row1, row2, s);
        res = res.drawHorizontalLine(row1, col1, col2, s);
        res = res.drawHorizontalLine(row2, col1, col2, s);
        return res;
    }

    public Drawing drawLine(int row1, int col1, int row2, int col2, char s) {
        Drawing res = new Drawing(this);
        int x_Dd = 0;   //функции погершности по x и y
        int y_Dd = 0;
        int dx = col2 - col1;   // приращения по х и у на всем отрезке
        int dy = row2 - row1;
        int incX = 0;   // шаги приращения по х и у =0
        int incY = 0;
        if (dx != 0)
            incX = dx / Math.abs(dx);
        if (dy != 0)
            incY = dy /Math.abs(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        int d = Math.max(dx, dy);   // выбор max(dx,dy) в качестве тестовой величины
        int x = col1;
        int y = row1;
        res.img[y][x] = s; // установка пикселя в начале отрезка
        for (int i = 1; i <= d; i++) {
            x_Dd += dx; // приращение ошибки при перемещении на пиксель
            y_Dd += dy;
            if (x_Dd >= d) {    // условие шага по х
                x += incX;
                x_Dd -= d;
            }
            if (y_Dd >= d) {    // условие шага по у
                y += incY;
                y_Dd -= d;
            }
            res.img[y][x] = s;
        }
        return res;
    }

    public Drawing drawCircle(int row, int col, int rad, char s) {
        Drawing res = new Drawing(this);
        int x = 0;
        int y = rad;
        int delta = 1 - 2 * rad;
        int error;
        while (y >= 0) {
            res.img[row + y][col + x] = s;
            res.img[row + y][col - x] = s;
            res.img[row - y][col + x] = s;
            res.img[row - y][col - x] = s;
            error = 2 * (delta + y) - 1;
            if (delta < 0 && error <= 0) {
                delta += 2 * ++x + 1;
                continue;
            }
            error = 2 * (delta - x) - 1;
            if (delta > 0 && error > 0) {
                delta += 1 - 2 * --y;
                continue;
            }
            x += 1;
            delta += 2 * (x - y);
            y -= 1;
        }
        return res;
    }

    public Drawing draw(int x, int y, Drawing d) {
        Drawing res = new Drawing(this);
        for (int i = 0; i < d.rows && y + i < this.rows; i++)
            for (int j = 0; j < d.columns && x + j < this.columns; j++)
                res.img[y + i][x + j] = d.img[i][j];
        return res;
    }
}
