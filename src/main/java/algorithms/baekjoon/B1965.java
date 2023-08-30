package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1965 {

  static int[] boxes;
  static int[][] dp;
  static int n;
  public static void solution() {
    dp = new int[n][n];

    for (int i = 1; i < n; i++) {
      dp[i-1][i] = boxes[i-1] < boxes[i] ? 2 : 1;
    }

    for (int j = 0; j < n; j++) {
      for (int k = j+2; k < n; k++) {
        dp[j][k] = dp[j][k-1] + dp[k-1][k] - 1;
      }
    }

    System.out.println(dp[0][n-1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.valueOf(br.readLine());

    boxes = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      boxes[i] = Integer.valueOf(st.nextToken());
    }
    solution();
  }

}
