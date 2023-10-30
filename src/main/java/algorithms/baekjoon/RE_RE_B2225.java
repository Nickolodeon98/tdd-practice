package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class RE_RE_B2225 {

    static int N;
    static int K;
    static int[][] dp;

    public static void solution() {
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
//
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] += dp[i-k][j-1];
                    dp[i][j] %= 1000000000;
                }

            }

        }

        System.out.println(dp[N][K]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        dp = new int[N + 1][K + 1];

        solution();

    }
}
