package algorithms.codeup;

import java.util.Scanner;

public class Q1854 {
    public long digitSum(long n) {
        if (n == 0) return 0;
        /* 예 2: n 이 432일 때 */
        long digit = n % 10; // Here you get 2, which is a first digit of 432.
        n = n / 10; // you get tenth digit from a number divided by 10. Here you get 43.
        // return statement below equals to 2 + digitSum(43), which is equal to 2 + 3 + digitSum(4),
        // then consecutively 2 + 3 + 4 = 9
        return digit + digitSum(n);
    }

    public static void main(String[] args) {
        Q1854 q1854 = new Q1854();
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(q1854.digitSum(num));
    }
}
