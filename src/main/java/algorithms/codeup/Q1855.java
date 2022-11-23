package algorithms.codeup;

import java.util.Scanner;

public class Q1855 {
    public int fibonacci(int n) {
        /* Fibonacci sequence is a sequence f numbers where each number is a sum of two precedent numbers.
         * Thus, sequence looks as follows: 1 1 2 3 5 8 13 21 34 ...
         * For nth fibonacci number, the repetition occurs n times, each of which adds two numbers, starting from 0 and 1.
         * e.g. 3rd fibonacci number: requires computing 0 + 1, namely, a sum of 1st and 2nd fibonacci numbers.
         * In other words, nth fibonacci number is a sum of (n-2)th and (n-1)th fibonacci numbers.
         * The only information we have is that first and second numbers of the sequence are 1.
         * Therefore, we repeat as far as we get 0. This gives us a hint on how to set a base case and a return statement. */

        if (n <= 2) return 1;

        return fibonacci(n-2) + fibonacci(n-1);
        // if n = 4, fibonacci(2) + fibonacci(3) = 1 + fibonacci(1) + fibonacci(2) = 1 + 1 + 1 = 3
    }

    public static void main(String[] args) {
        Q1855 q1855 = new Q1855();
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();
        System.out.println(q1855.fibonacci(order));
    }
}
