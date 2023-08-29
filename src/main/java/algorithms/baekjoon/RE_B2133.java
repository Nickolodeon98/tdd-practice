package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RE_B2133 {
  static int N;
  static int[] dp;
  public static void solution() {
    if (N == 0) {
      System.out.println(1);
      return;
    }

    if (N % 2 != 0) {
      System.out.println(0);
      return;
    }

    dp[0] = 1;
    dp[2] = 3;
    for (int n = 4; n <= N; n += 2) {
      dp[n] = (dp[n-2] * dp[2]);
      for (int m = 4; n - m >= 0; m += 2) {
         dp[n] += (dp[n-m] * 2);
      }
    }

    System.out.println(dp[N]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    dp = new int[N+1];

    solution();
  }

}
