package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1303 {

  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static char[][] board;
  static boolean[][] visited;
  static int cntW = 0;
  static int cntB = 0;
  static int good = 0;
  static int bad = 0;
  static char[] types = {'W', 'B'};
  public static void solution() {

    visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (visited[i][j]) continue;
        visited[i][j] = true;

        if (board[i][j] == 'W') {
          DFS(i, j, 'W');
          good += Math.pow(cntW, 2);
          cntW = 0;
          continue;
        }

        if (board[i][j] == 'B') {
          DFS(i, j, 'B');
          bad += Math.pow(cntB, 2);
          cntB = 0;
        }
      }
    }

    System.out.println(good + " " + bad);
  }

  public static boolean isInRange(int y, int x) {
    return y >= 0 && y < board.length && x >= 0 && x < board[y].length;
  }

  public static void DFS(int y, int x, char type) {
    if (type == 'W') cntW++;
    else if (type == 'B') cntB++;

    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) continue;
      if (visited[ny][nx]) continue;
      if (board[ny][nx] != type) continue;
      visited[ny][nx] = true;
      DFS(ny, nx, type);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());

    board = new char[M][N];

    for (int i = 0; i < M; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    solution();
  }
}
