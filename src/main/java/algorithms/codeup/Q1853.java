package algorithms.codeup;

public class Q1853 {
    public int sumOfN(int n) {
        if (n == 0) return 0;
        return n + sumOfN(--n);
    }

    public static void main(String[] args) {
        Q1853 q1853 = new Q1853();
        System.out.println(q1853.sumOfN(10));
    }
}
