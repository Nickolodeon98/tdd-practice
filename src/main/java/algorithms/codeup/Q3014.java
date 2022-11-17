package algorithms.codeup;

import java.util.Arrays;
import java.util.Scanner;

public class Q3014 {
    public void fastSort(int[] data) {


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[n];

        System.out.println(n);

        String line = sc.nextLine();

        String[] data = line.split(" ");

//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = Integer.parseInt(data[i]);
//        }

        System.out.println(Arrays.toString(data));
    }
}
