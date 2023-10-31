package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_RE_RE_B2240 {
    static int count = 0;
    static int[][][] dp;
    static int[] trees;
    static int W;
    static int T;

    public static void countPlums() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (trees[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1] + 1, dp[i - 1][j - 1][2] + 1);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                } else {
                    // 만약 1초에 1번 움직였는데 2번 나무에 있으면 0초에 0번 움직인것과 0초에 1번 움직인 것을 비교하므로 무효이다.
                    if (i == 1 && j == 1) continue;
                    dp[i][j][2] = Math.max(dp[i - 1][j][2] + 1, dp[i - 1][j - 1][1] + 1);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                }
                count = Math.max(count, dp[i][j][trees[i]]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.valueOf(st.nextToken());
        W = Integer.valueOf(st.nextToken());

        dp = new int[T + 1][W + 2][3];
        trees = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            trees[i] = Integer.valueOf(br.readLine());

        }
        countPlums();

        System.out.println(count);
    }
}