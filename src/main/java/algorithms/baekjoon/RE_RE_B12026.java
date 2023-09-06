package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RE_RE_B12026 {

  static int N;
  static char[] street;
  static int[] dp;

  public static void solution() {
    dp = new int[N];

    Arrays.fill(dp, (int)1e9);

    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      if (street[i] == 'B') {
        for (int j = i; j < N; j++) {
          if (street[j] == 'O') {
            dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
          }
        }
      } else if (street[i] == 'O') {
        for (int j = i; j < N; j++) {
          if (street[j] == 'J') {
            dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
          }
        }
      } else if (street[i] == 'J') {
        for (int j = i; j < N; j++) {
          if (street[j] == 'B') {
            dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
          }
        }
      }
    }

    if (dp[N - 1] == (int) 1e9) {
      System.out.println(-1);
    } else System.out.println(dp[N-1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    street = br.readLine().toCharArray();

    solution();
  }

}
