package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070 {
  static int[][] dp;
  static int[][] board;
  static int N;
  static int[][] pos;
  static int[][] dir = {{0, 1}, {1, 1}};
  public static void solution() {
    dp[3][3] = 1;
//      행이 같다면
    if (pos[0][0] == pos[1][0]) {
      for (int d = 0; d < dir.length; d++) {
        int ny1 = pos[1][0];
        int nx1 = pos[1][1];
        int ny2 = pos[1][0] + dir[d][0];
        int nx2 = pos[1][1] + dir[d][1];
        pos = new int[][]{{ny1, nx1}, {ny2, nx2}};

      }

    }

//      열이 같다면
    if (pos[0][1] == pos[1][1]) {
      for (int d = 0; d < dir.length; d++) {
        int ny1 = pos[1][0];
        int nx1 = pos[1][1];
        int ny2 = pos[1][0] + dir[d][1];
        int nx2 = pos[1][1] + dir[d][0];
        pos = new int[][]{{ny1, nx1}, {ny2, nx2}};

      }
    }
//      행과 열 모두 다르다면


  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    board = new int[N+1][N+1];
    dp = new int[N+1][N+1];
    pos = new int[][]{{1, 1}, {1, 2}};

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }
  }
}
