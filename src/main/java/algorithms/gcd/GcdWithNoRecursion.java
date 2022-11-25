package algorithms.gcd;

public class GcdWithNoRecursion {
    public int findGcd(int a, int b) {
        while (a > 1 && b > 1) {
            if (a > b) a -= b;
            if (b > a) b -= a;
            if (a == b) return a;
        }
        return 1;
    }

}
