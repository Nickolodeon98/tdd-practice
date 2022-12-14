package algorithms.dynamicprogramming;

import java.util.Arrays;

public class OptimalStrategyInProgress {

    public static void fillMatrix() {
        int[] columns = {2, 7, 40, 19};

        int[][] memo = new int[columns.length][columns.length];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == j) {
                    memo[i][j] = columns[i];
                    continue;
                }
                if (i > j) {
                    memo[i][j] = 0;
                    continue;
                }
                memo[i][j] = memo[i][j-1] + columns[j];
            }
        }

        for (int[] row : memo) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static void main(String[] args) {
        fillMatrix();
    }

}
