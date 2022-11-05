package algorithms.codetree;

import java.util.Scanner;

public class MatrixToZero {
    public void findNumFromMatrix() {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][];
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((s = sc.next()) != null) matrix[i][j] = Integer.parseInt(s);
            }
        }
        int r = 0;
        int c = 0;
        if ((s = sc.next()) != null) r = Integer.parseInt(s);
        if ((s = sc.next()) != null) c = Integer.parseInt(s);

        for (int k = 0; k < r; k++) {
            for (int l = 0; l < c; l++) {
                if (matrix[k][l] < matrix[r-1][c-1]) {
                    matrix[k][l] = 0;
                }
            }
        }
        for (int[] ints : matrix) {
            for (int cnt = 0; cnt < ints.length; cnt++) {
                System.out.print(ints[cnt] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixToZero matrixToZero = new MatrixToZero();
        matrixToZero.findNumFromMatrix();
    }
}
