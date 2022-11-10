package algorithms.codetree;

import java.util.*;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int size = sc.nextInt();

        int[][] twoDArray = new int[size][2];
        for (int i = 0; i < size; i++) {
            twoDArray[i][0] = sc.nextInt();
            twoDArray[i][1] = sc.nextInt();
        }

        int[][] newArray = new int[num][num];
        int cnt = 1;
        for (int[] oneDArray : twoDArray) {
            newArray[oneDArray[0]-1][oneDArray[1]-1] = cnt;
            cnt++;
        }

        for (int[] resultElements : newArray) {
            for (int l = 0; l < num; l++) {
                System.out.print(resultElements[l] + " ");
            }
            System.out.println();
        }

    }
}
