package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MinCostPath {

    public int findMinPath(int[][] cache) {
        int[][] memo = new int[cache.length][cache[0].length];
        /* 첫 번째 칸에 도달하는데 드는 최소 비용을 기록합니다. */

        /* 첫 번째 행의 맨 끝에 도달하는데 드는 최소 비용을 기록합니다. */
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        memo[i][j] = cache[i][j];
                        continue;
                    }
                    memo[i][j] = memo[i][j-1] + cache[i][j];
                    continue;
                }
                /* 첫 번째 열의 맨 끝에 도달하는데 드는 최소 비용을 기록합니다. */
                if (j == 0) {
                    memo[i][j] = memo[i-1][j] + cache[i][j]; // 첫번째 열을 채운다.
                    continue;
                }
                /* 위 세 가지 외의 나머지 경우들에서 목적지에 도달하기 위한 최소 비용을 기록합니다. */
                memo[i][j] = Math.min(memo[i-1][j-1], Math.min(memo[i-1][j], memo[i][j-1])) + cache[i][j];
            }

        }
        /* 저장된 모든 칸의 각 칸까지의 최소 경로들을 출력한다. */
        for (int[] row : memo) {
            System.out.println(Arrays.toString(row));
        }
        
        /* 맨 마지막 칸에 기록된 마지막 칸까지의 최소 경로를 반환합니다. */
        return memo[memo.length-1][memo[0].length-1];
    }

    public static void main(String[] args) {
        /* 우선 캐시 배열을 만듭니다. */
        // cache = [[1, 3, 2],
        //          [4, 6, 2],
        //          [1, 2, 4]];

        int[][] cache = {{1, 3, 2}, {4, 6, 2}, {1, 2, 4}};
    }

}
