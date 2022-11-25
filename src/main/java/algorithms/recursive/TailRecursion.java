package algorithms.recursive;

public class TailRecursion {
    public static void recur(int n) {
        if (n <= 0) return;
        recur(n-1);
        System.out.println(n);
        recur(n-2);
    }

    public static void recur2(int n) {
        while (n > 0) {
            recur(n-1);
            System.out.println(n);
            n -= 2;
        }
    }

    public static void main(String[] args) {
        recur(3);
        recur2(3);
    }

}
