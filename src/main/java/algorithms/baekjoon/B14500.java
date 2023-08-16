package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14500 {
  static int[][] board;
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  static boolean[][] visited;
  static List<Integer> every;
  static int max;

  public static boolean isInRange(int y, int x) {
    return y >= 0 && y < board.length && x >= 0 && x < board[y].length;
  }

  public static void solution() {
    visited = new boolean[board.length][board[0].length];
    every = new ArrayList<>();

    max = Integer.MIN_VALUE;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        DFS(i, j, 0, 0);
      }
    }
    System.out.println(max);
  }

  public static void DFS(int y, int x, int cnt, int tmp) {
    if (cnt == 4) {
      max = Math.max(max, tmp);
      return;
    }

    if (cnt == 2) {
      for (int d = 0; d < dir.length-1; d++) {
        for (int d2 = d + 1; d2 < dir.length; d2++) {
          int ny1 = dir[d2][0] + y;
          int nx1 = dir[d2][1] + x;
          int ny2 = dir[d][0] + y;
          int nx2 = dir[d][1] + x;

          if (isInRange(ny1, nx1) && isInRange(ny2, nx2)) {
            if (visited[ny1][nx1] || visited[ny2][nx2])
              continue;

            visited[ny1][nx1] = true;
            visited[ny2][nx2] = true;
            DFS(ny2, nx2, cnt + 2, tmp + board[ny1][nx1] + board[ny2][nx2]);
            visited[ny1][nx1] = false;
            visited[ny2][nx2] = false;
          }
        }
      }
    }

    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx))
        continue;
      if (visited[ny][nx])
        continue;
      visited[ny][nx] = true;
      DFS(ny, nx, cnt + 1, tmp + board[ny][nx]);
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
