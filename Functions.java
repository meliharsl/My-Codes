package pgdp.functions;

public class Functions {

    public static void main(String[] args)
    }

    public static int square(int n) {
        int square = n * n;
        return square;
    }

    public static int sumOfSquares(int a, int b) {
        int aSquared = square(a);
        int bSquared = square(b);
        int sum = aSquared + bSquared;

        return sum;
    }

    public static int cube(int n) {
        // TODO
        return square(n) * n;
    }

    public static int average(int a, int b, int c) {
        // TODO
        int sumabc = a + b + c;
        int durchschnitt = sumabc / 3;
        return durchschnitt;
    }

    public static boolean isPythagoreanTriple(int a, int b, int c) {
        // TODO: Benutze in dieser Methode keine arithmetischen Operatoren (i.e. +, -, *, /, % etc.)!
        return sumOfSquares(a, b) == square(c);
    }
}