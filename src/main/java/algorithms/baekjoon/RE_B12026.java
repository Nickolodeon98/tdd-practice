package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RE_B12026 {

  static int[] dp;
  static int N;
  static char[] street;
  static char[] BOJ = {'B', 'O', 'J'};
  static boolean[][] visited;
  public static void solution() {
    dp = new int[N];
    visited = new boolean[N][N];
    Arrays.fill(dp, (int)1e9);

    dp[0] = 0;
    int cur = 0;
    boolean flag= false;
    int i = 0;
    int curIdx = 0;
    while (i < N - 1) {
      if (visited[curIdx][i]) break;
      if (street[i] == BOJ[cur % 3]) {
        for (int j = i + 1; j < N; j++) {
          if (street[j] == BOJ[(cur + 1) % 3]) {
            visited[curIdx][j] = true;
            dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
            if (!flag) {
              curIdx = j;
              flag = true;
            }
          }
        }
      }
      i++;

      if (i >= N-1) {
        cur++;
        i = curIdx;
      }
    }

    System.out.println(dp[N - 1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    street = br.readLine().toCharArray();

    solution();
  }
}
