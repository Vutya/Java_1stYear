package objects;

public class Rational {
    public static final Rational ONE = new Rational(1 ,1);
    public static final Rational ZERO = new Rational(0 ,1);

    // numerator, denominator - числитель, знаменатель
    private int n;
    private int d;

    public Rational(int n, int d) {
        int gcd = greatestCommonDivisor(n, d);
        if (d < 0)
            this.n = (Math.abs(d) / d) * n / gcd;
        else
            this.n = n /gcd;
        this.d = Math.abs(d) / gcd;
    }

    public Rational(int n) {
        this.n = n;
        this.d = 1;
    }

    public static int greatestCommonDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        return a + b;
    }

    public String toString() {
        if (d == 1)
            return Integer.toString(n);
        else if (d == 0)
            return "NaN";
        return n + "/" + d;
    }

    public double toDouble() {
        return (double) n / d;
    }

    public int getN() {
        return n;
    }

    public int getD() {
        return d;
    }

    public Rational add(Rational r) {
        return new Rational(this.n * r.d + r.n * this.d, this.d * r.d);
    }

    public Rational sub(Rational r) {
        return new Rational(this.n * r.d - r.n * this.d, this.d * r.d);
    }

    public Rational mul(Rational r) {
        return new Rational(this.n * r.n, this.d * r.d);
    }

    public Rational div(Rational r) {
        return new Rational(this.n * r.d, this.d * r.n);
    }

    /* public void addInPlace(Rational r) {
        int a = this.n * r.getD() + r.getN() * this.d;
        int b = this.d * r.getD();
        int divisor = greatestCommonDivisor(a, b);
        this.n = a / divisor;
        this.d = b / divisor;
    }

    public void subInPlace(Rational r) {
        int a = this.n * r.getD() - r.getN() * this.d;
        int b = this.d * r.getD();
        int divisor = greatestCommonDivisor(a, b);
        this.n = a / divisor;
        this.d = b / divisor;
    }

    public void mulInPlace(Rational r) {
        int a = this.n * r.getN();
        int b = this.d * r.getD();
        int divisor = greatestCommonDivisor(a, b);
        this.n = a / divisor;
        this.d = b / divisor;
    }

    public void divInPlace(Rational r) {
        int a = this.n * r.getD();
        int b = this.d * r.getN();
        int divisor = greatestCommonDivisor(a, b);
        this.n = a / divisor;
        this.d = b / divisor;
    }*/

    public static double f(int n) {
        Rational res = ONE;
        for (int i = 2; i <= n; i++)
            res = res.add(new Rational(1, i));
        return res.toDouble();
    }

    static Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }

    static Rational sub(Rational r1, Rational r2) {
        return r1.sub(r2);
    }

    static Rational mul(Rational r1, Rational r2) {
        return r1.mul(r2);
    }

    static Rational div(Rational r1, Rational r2) {
        return r1.div(r2);
    }
}
