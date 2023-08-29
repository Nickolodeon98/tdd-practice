package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049 {
  static int[][] matrices;
  static int N;
  static int[][] dp;
  static int[] multiple;
  public static void solution() {
    dp = new int[N+1][N+1];
    multiple = new int[N+1];

    multiple[0] = 1;
    multiple[1] = matrices[1][0] * matrices[1][1];

    for (int m = 2; m < multiple.length; m++) {
      multiple[m] = multiple[m-1] * matrices[m][1];
    }
    for (int n = 1; n <= N; n++) {
      for (int from = 1; from + n <= N; from++) {
        int to = from + n;
        dp[from][to] = Integer.MAX_VALUE;
        for (int divide = from; divide < to; divide++) {
          dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + (matrices[from][0] * matrices[divide][1] * matrices[to][1]));
        }
      }
    }
    System.out.println(dp[1][N]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    matrices = new int[N+1][2];
    matrices[0] = new int[]{1, 1};
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int r = Integer.valueOf(st.nextToken());
      int c = Integer.valueOf(st.nextToken());

      matrices[i][0] = r;
      matrices[i][1] = c;
    }

    solution();
  }
}
