package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B14500 {
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static boolean[][] visited;
  static int[][] board;
  static int max = 0;

  public static void solution() {
    visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        DFS(0, i, j, 0);
      }
    }

    System.out.println(max);
  }

  public static boolean isInRange(int y, int x) {
    return y < board.length && y >= 0 && x < board[y].length && x >= 0;
  }

  public static void DFS(int cnt, int y, int x, int sum) {
    if (cnt == 4) {
      max = Math.max(max, sum);
      return;
    }

    if (cnt == 2) {
      for (int d = 0; d < dir.length - 1; d++) {
        for (int e = d + 1; e < dir.length; e++) {
          int ny1 = y + dir[d][0];
          int nx1 = x + dir[d][1];
          int ny2 = y + dir[e][0];
          int nx2 = x + dir[e][1];

          if (!isInRange(ny1, nx1) || !isInRange(ny2, nx2)) {
            continue;
          }
          if (visited[ny1][nx1] || visited[ny2][nx2]) {
            continue;
          }

          visited[ny1][nx1] = true;
          visited[ny2][nx2] = true;
          DFS(cnt + 2, ny1, nx1, sum + board[ny1][nx1] + board[ny2][nx2]);
          visited[ny1][nx1] = false;
          visited[ny2][nx2] = false;
        }
      }
    }

    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) {
        continue;
      }
      if (visited[ny][nx]) {
        continue;
      }
      visited[ny][nx] = true;
      DFS(cnt + 1, ny, nx, sum + board[ny][nx]);
      visited[ny][nx] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }
    solution();
  }
}