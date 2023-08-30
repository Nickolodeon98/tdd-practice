package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_B1965 {
  static int[] dp;
  static int[] boxes;
  static int n;
  public static void solution() {
    dp = new int[n];

    Arrays.fill(dp, 1);
    boolean flag = false;

    for (int i = 0; i < boxes.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        if (boxes[i] > boxes[j]) {
          max = Math.max(max, dp[j]);
          flag = true;
        }
      }
      if (flag) {
        dp[i] += max;
        flag = false;
      }
    }


    int ans = Integer.MIN_VALUE;
    for (int d : dp) {
      ans = Math.max(ans, d);
    }
    System.out.println(ans);
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
