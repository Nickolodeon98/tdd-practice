package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_RE_B5557 {
  static int N;
  static int[] nums;
  static long[][] dp;
  public static void solution() {
    dp = new long[nums.length][21];

    dp[0][nums[0]] = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j <= 20; j++) {
        if (j - nums[i] >= 0 && j - nums[i] <= 20)
          dp[i][j] += dp[i-1][j-nums[i]];

        if (j + nums[i] >= 0 && j + nums[i] <= 20)
          dp[i][j] += dp[i-1][j+nums[i]];
      }
    }

    System.out.println(dp[N-2][nums[N-1]]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.valueOf(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    nums = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.valueOf(st.nextToken());
    }

    solution();
  }

}
