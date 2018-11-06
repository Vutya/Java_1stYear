package objects;

public class RationalExample {
    public static void main(String[] args) {
        System.out.println("Initializing Rationals...");
        Rational num1 = new Rational(1,3);
        Rational num2 = new Rational(2,12);
        Rational num3 = new Rational(34,-85);
        Rational num4 = new Rational(11);
        Rational num5 = new Rational(8,0);
        Rational num6 = new Rational(-0,2);
        Rational num7 = new Rational(-76,-97);

        System.out.println("Rationals to String...");
        System.out.println(num1.toString());
        System.out.println(num2.toString());
        System.out.println(num3.toString());
        System.out.println(num4.toString());
        System.out.println(num5.toString());
        System.out.println(num6.toString());
        System.out.println(num7.toString());

        System.out.println("Rationals to Double...");
        System.out.println(num1.toDouble());
        System.out.println(num2.toDouble());
        System.out.println(num3.toDouble());
        System.out.println(num4.toDouble());
        System.out.println(num5.toDouble());
        System.out.println(num6.toDouble());
        System.out.println(num7.toDouble());

        System.out.println("Arithmetic operations");

        Rational r1 = num1.add(num2);
        System.out.println(num1.toString() + " + " + num2.toString() + " = " + r1.toString());
        // num1.addInPlace(num2);
        // System.out.println(num1.toString());

        Rational r2 = num3.sub(num7);
        System.out.println(num3.toString() + " - " + num7.toString() + " = " + r2.toString());
        //num3.subInPlace(num7);
        // System.out.println(num3.toString());

        Rational r3 = num7.mul(num2);
        System.out.println(num7.toString() + " * " + num2.toString() + " = " + r3.toString());
        // num7.mulInPlace(num2);
        // System.out.println(num7.toString());

        Rational r4 = num3.div(num1);
        System.out.println(num3.toString() + " / " + num1.toString() + " = " + r4.toString());
        // num3.divInPlace(num1);
        // System.out.println(num3.toString());

        System.out.println("Function F:");
        System.out.println("f(1) = " + Rational.f(1));
        System.out.println("f(2) = " + Rational.f(2));
        System.out.println("f(3) = " + Rational.f(3));
        System.out.println("f(20) = " + Rational.f(20));
        // Сделать метод как в задаче с потоками
        /*
        public static double f(int n) {
            double res = 1;
            for (int i = 2; i <= n; i++)
                res += (new Rational(1, i)).toDouble();
            return res;
         }
         */

        System.out.println("Get-methods");
        System.out.println("n: " + num7.getN());
        System.out.println("d: " + num7.getD());

        System.out.println("ZERO: " + Rational.ZERO.toString());
        System.out.println("ONE: " + Rational.ONE.toString());

        System.out.println("Static Greatest Common Divisor of 5 and 17");
        System.out.println(Rational.greatestCommonDivisor(5, 17));

        System.out.println("Static Arithmetic Operations:");
        Rational r5 = new Rational(7,49);
        Rational r6 = new Rational(9, 33);
        System.out.println(r5.toString() + " and " + r6.toString());
        System.out.println("+: " + Rational.add(r5, r6));
        System.out.println("-: " + Rational.sub(r5, r6));
        System.out.println("*: " + Rational.mul(r5, r6));
        System.out.println("/: " + Rational.div(r5, r6));
    }
}
