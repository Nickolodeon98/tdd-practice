package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_B2225 {
    static int N;
    static int K;
    static int[][] dp;

    public static void solution() {
        // dp[K][i] = K개를 합해서 i 가 되는 경우의 수의 개수
        // dp[K-1][i] = K - 1개를 합해서 i 가 되는 경우의 수
        // K 개를 합해서 i 가 되는 경우의 수는 K-x개를 합해서 i-n 이 되는 경우의 수에 x개를 사용해서 n이 되는 경우의 수를 더한 것과 같다.
        // dp[K][i] = dp[K-x][i-n] + dp[x][n];
        // 계속 밑으로 내려가다보면 base case 가 나온다. 2개로 N을 만드는 경우의 수는 1개로 N-3 을 만드는 경우의 수 + 1개로 3을 만드는 경우의 수와 같이 나눌 수 있다.
        // dp[1] 은 모두 1로 채워져 있어야 한다. 1개로 어떤 수를 만드는 방법은 1가지이므로. 즉 아래 점화식은 무조건 1 + 1 = 2이다.
        // 맞는 것이, 2개로 3을 만드는 방법은 1 + 2, 2 + 1, 3 + 0, 0 + 3 네개이다.
        // dp[2][N] = dp[2-1][N-3] + dp[1][3] = 1 + 1 = 2;
        // dp[2][N] = dp[2-1][N] + dp[1][0] = 1 + 1 = 2;
        // 즉, dp[2][N] += N - ? AND ?

//        Arrays.fill(dp[1], 1);

//        dp[1][0] = 0;

//        for (int i = 1; i < dp.length; i++) {
//            dp[i][0] = 1;
//
//        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] += dp[k][j-1];
//                    System.out.println("dp[" + (i-k) + "][" + (K-j) + "] (" + dp[i-k][K-j] + ") + dp[" + k + "][" + (K-j) + "] (" + dp[k][K-j] + ") = dp[" + i + "][" + K + "] (" + (dp[i][K]) + ")");
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(dp[N][K] % 1000000000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        dp = new int[K + 1][N + 1];

        solution();

    }
}
