package algorithms.baekjoon;

import java.util.Scanner;

public class RE_B2293 {

  int[] dp;
  int N;
  int K;
  int[] coins;
  public void solution() {
    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");

    int num = Integer.valueOf(size[0]);

    N = num;
    K = Integer.valueOf(size[1]);

    dp = new int[K+1];

    coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.valueOf(sc.nextLine());
    }
    dp[0] = 1;
    DP();
  }

  public void DP() {
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j < dp.length; j++) {
        if (j < coins[i]) continue;

        dp[j] += dp[j - coins[i]];
      }
    }

    System.out.println(dp[K]);
  }

  public static void main(String[] args) {
    RE_B2293 test = new RE_B2293();

    test.solution();
  }
}
