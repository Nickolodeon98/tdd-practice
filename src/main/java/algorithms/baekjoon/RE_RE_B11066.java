package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RE_RE_B11066 {

  static List<Integer> costs;
  static int[][] dp;
  static int[] sum;
  public static void solution(int[] chapters) {
    dp = new int[chapters.length][chapters.length];

    sum = new int[chapters.length];
    sum[1] = chapters[1];

    for (int s = 2; s < sum.length; s++) {
      sum[s] = sum[s-1] + chapters[s];
    }

    for (int n = 1; n < chapters.length; n++) {
      for (int from = 1; from + n < chapters.length; from++) {
        int to = from + n;
        dp[from][to] = Integer.MAX_VALUE;
        for (int divide = from; divide < to; divide++) {
          dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
        }
      }
    }

    costs.add(dp[1][chapters.length-1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.valueOf(br.readLine());
    costs = new ArrayList<>();

    for (int t = 0; t < T; t++) {
      int K = Integer.valueOf(br.readLine());
      int[] chapters = new int[K+1];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int k = 1; k <= K; k++) {
        chapters[k] = Integer.valueOf(st.nextToken());
      }
      solution(chapters);
    }

    for (int cost : costs) {
      System.out.println(cost);
    }
  }


}
