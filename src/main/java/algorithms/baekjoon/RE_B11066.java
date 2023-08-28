package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RE_B11066 {
  /* dp[i][j] = i 페이지부터 j 페이지까지의 합
   * dp[0][0] = chapters[0]
   * dp[1][1] = chapters[1]
   * <= from + n
   * */
  static int[][] dp;
  static int K;
  static List<Integer> ans  = new ArrayList<>();
  public static void solution(int[] chapters) {
    dp = new int[K+1][K+1];

//    for (int[] memo : dp) {
//      Arrays.fill(memo, Integer.MAX_VALUE);
//    }

    int[] sum = new int[K+1];
    sum[1] = chapters[1];
    for (int s = 2; s < chapters.length; s++) {
      sum[s] = sum[s-1] + chapters[s];
    }

//    for (int i : sum) {
//      System.out.println(i);
//    }

//    dp[0][0] = 0;
//    for (int d = 1; d <= K; d++) {
//      dp[d][d] = chapters[d];
//      dp[d-1][d] = dp[d-1][d-1] + dp[d][d];
//    }

    for (int n = 1; n <= K; n++) {
      for (int from = 1; from + n <= K; from++) {
        int to = from + n;
        dp[from][to] = Integer.MAX_VALUE;
        for (int divide = from; divide < to; divide++) {
            dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from-1]);
        }
      }
    }
    ans.add(dp[1][K]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.valueOf(br.readLine());

    for (int i = 0; i < T; i++) {
      K = Integer.valueOf(br.readLine());
      int[] chapters = new int[K+1];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int k = 1; k <= K; k++) {
        chapters[k] = Integer.valueOf(st.nextToken());
      }
      solution(chapters);
    }

    for (Integer an : ans) {
      System.out.println(an);
    }
  }
}
