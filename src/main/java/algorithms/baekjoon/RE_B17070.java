package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B17070 {

  static int[][][] dp;
  static int N;
  static int[][] board;
  static int[][] dir = {{0, -1}, {-1, 0}};
  public static boolean isInRange(int y, int x) {
    return y <= N && y >= 1 && x <= N && x >= 1;
  }

  public static void solution() {
    dp[1][2][0] = 1;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (board[i][j] == 1) {
          continue;
        }
        for (int d = 0; d < dir.length; d++) {
          int ny = i + dir[d][0];
          int nx = j + dir[d][1];


          dp[i][j][d] += dp[ny][nx][d] + dp[ny][nx][2];
        }

        for (int c = 0; c < 3; c++) {
          int ny = i -1;
          int nx = j -1;


          if (board[i - 1][j] == 1 || board[i][j-1] == 1) {
            continue;
          }
          dp[i][j][2] += dp[ny][nx][c];
        }
      }
    }

    System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    board = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1][3];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    solution();
  }

}
