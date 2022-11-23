package algorithms.codeup;

import java.util.Scanner;

public class Q1852 {
    public void inlineOut(int n) {
        if (n == 0) return;
        inlineOut(n-1);
        System.out.print(n);
    }


    public static void main(String[] args) {
        Q1852 q1852 = new Q1852();
        Scanner sc = new Scanner(System.in);
        int targetNum = sc.nextInt();
        q1852.inlineOut(targetNum);
    }
}
