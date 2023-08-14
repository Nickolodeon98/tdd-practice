package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {

  static int N;
  static int M;
  static int[][] board;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    M = Integer.valueOf(st.nextToken());

    board = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    solution();
  }
  static List<int[]> all;

  public static void solution() {
    List<int[]> home = new ArrayList<>();
    List<int[]> chicken = new ArrayList<>();

    for (int r = 1; r < board.length; r++) {
      for (int c = 1; c < board[r].length; c++) {
        if (board[r][c] == 0) {
          continue;
        }
        if (board[r][c] == 1) {
          home.add(new int[]{r, c});
          continue;
        }
        if (board[r][c] == 2) {
          chicken.add(new int[]{r, c});
        }
      }
    }

    all = new ArrayList<>();

    List<Integer>[] dist = new ArrayList[chicken.size()];

    for (int di = 0; di < dist.length; di++) {
      dist[di] = new ArrayList<>();
    }

    for (int h = 0; h < home.size(); h++) {
      for (int ch = 0; ch < chicken.size(); ch++) {
        int d = Math.abs(home.get(h)[0] - chicken.get(ch)[0]) + Math.abs(home.get(h)[1] - chicken.get(ch)[1]);

        dist[ch].add(d);
      }
    }
    int[][] distHome = new int[dist[0].size()][dist.length];


    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist[i].size(); j++) {
        distHome[j][i] = dist[i].get(j);
      }
    }

    int close = chicken.size() - M;
    boolean[] closed = new boolean[chicken.size()+1];
    int tmp = Integer.MAX_VALUE;
    int chickenDist = 0;
    int[] choices = new int[close];
    visited = new boolean[chicken.size()+1];
    combination(chicken.size(), close, 0, choices);
    int ans = Integer.MAX_VALUE;

    for (int[] a : all) {
      for (int e : a) {
        closed[e] = true;
      }
      for (int[] ints : distHome) {
        for (int c = 0; c < ints.length; c++) {
          if (closed[c]) {
            continue;
          }
          tmp = Math.min(tmp, ints[c]);
        }
        chickenDist += tmp;
        tmp = Integer.MAX_VALUE;
      }
      tmp = Integer.MAX_VALUE;
      if (ans > chickenDist) ans = chickenDist;
      chickenDist = 0;
      closed = new boolean[chicken.size() +1];
    }

    System.out.println(ans);

  }
  public static void combination(int total, int choice, int idx, int[] choices) {
    if (choice == 0) {
      int[] tmp = Arrays.copyOf(choices, choices.length);
      all.add(tmp);
      return;
    }

    for (int i = idx; i < total; i++) {
      if (visited[i] || (idx > 0 && choices[idx-1] > i)) continue;
      int[] tmp = choices;
      tmp[idx] = i;
      visited[i] = true;
      combination(total, choice - 1, idx + 1, tmp);
      visited[i] = false;
    }

  }
}