package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B10971 {
  static boolean[] visited;
  static int[][] board;
  static int N;
  static int min = Integer.MAX_VALUE;
  public static void solution() {
    visited = new boolean[N];

    visited[0] = true;
    DFS(0, 0, 1);
    System.out.println(min);
  }

  public static void DFS(int cur, int sum, int cnt) {
    if (cnt == N) {
      if (board[cur][0] != 0)
        min = Math.min(min, sum + board[cur][0]);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i]) continue;
      if (board[cur][i] == 0) continue;
      visited[i] = true;
      DFS(i, sum + board[cur][i], cnt + 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    board = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    solution();
  }
}
