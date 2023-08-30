package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2225 {
  static int[][] dp;
  static int N;
  static int K;
  public static void solution() {
    dp = new int[201][N+1];

    for (int j = 1; j <= K; j++) {
      dp[j][0] = 1;
    }

    for (int i = 0; i <= N; i++) {
      dp[1][i] = 1;
    }

    for (int k = 1; k <= K; k++) {
      for (int n = 1; n <= N; n++) {
        for (int j = 0; j <= n; j++) {
          dp[k][n] += dp[k-1][j];
          dp[k][n] %= 1000000000;
        }
      }
    }

    System.out.println(dp[K][N]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());

    solution();
  }
}
