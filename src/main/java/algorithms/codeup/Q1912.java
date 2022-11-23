package algorithms.codeup;

import java.util.Scanner;

public class Q1912 {
    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(--n); // current n times n - 1 is the returned value per each recursion
    }

    public static void main(String[] args) {
        Q1912 q1912 = new Q1912();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(q1912.factorial(num));
    }
}
