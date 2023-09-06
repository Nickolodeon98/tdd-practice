package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 {

  static int N;
  static int L;
  static int R;
  static int[][] A;
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static List<int[]>[][] separator;
  static boolean[][] visited;
  static boolean[][] added;

  public static boolean isInRange(int y, int x) {
    return y < N && y >= 0 && x < N && x >= 0;
  }

  public static void solution() {
    separator = new ArrayList[N][N];
    visited = new boolean[N][N];

    for (int s = 0; s < separator.length; s++) {
      for (int k = 0; k < separator[s].length; k++) {
        separator[s][k] = new ArrayList<>();
      }
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        pro(r, c);
      }
    }

    added = new boolean[N][N];
    int total = 0;
    int cnt = 1;
    for (int y = 0; y < separator.length; y++) {
      for (int x = 0; x < separator[y].length; x++) {
//        total = 0;
        if (separator[y][x].isEmpty()) {
//          System.out.println(y + " and " + x + " is empty");
          continue;
        }
        for (int[] l : separator[y][x]) {
//          System.out.print(A[y][x] + "\n" + A[l[0]][l[1]] + "\n");
          if (added[l[0]][l[1]]) {
            continue;
          }
          total += A[l[0]][l[1]];
          added[l[0]][l[1]] = true;
          cnt++;
        }
        if (added[y][x]) {
          continue;
        }
        total += A[y][x];
        added[y][x] = true;
//        System.out.println(total);
      }
//      System.out.println();
    }

//    System.out.println(total);
//    System.out.println(cnt);

//    for (int y = 0; y < separator.length; y++) {
//      for (int x = 0; x < separator[y].length; x++) {
//        if (separator[y][x].isEmpty()) {
//          continue;
//        }
//        for (int[] l : separator[y][x]) {
//          System.out.println("y: " + y + " x: " + x + " and " + l[0] + " " + l[1]);
//        }
//        System.out.println();
//      }
//    }

     visit = new boolean[N][N];

      DFS(0, 0);
      System.out.println(count);

    for (boolean[] adds : added) {
      for (boolean add : adds) {
        System.out.print(add + " ");
      }
      System.out.println();
    }
  }


  static boolean[][] visit;
  static int count = 0;
  public static void DFS(int y, int x) {
    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) continue;
      if (!added[ny][nx]) {
        continue;
      }
      if (visit[ny][nx]) continue;

      visit[ny][nx] = true;
      DFS(ny, nx);
      visit[ny][nx] = false;
    }
  }

  public static void pro(int r, int c) {
    Queue<Integer> candi = new LinkedList<>();
    candi.offer(r);
    candi.offer(c);

    while (!candi.isEmpty()) {
      int y = candi.poll();
      int x = candi.poll();

      if (visited[y][x]) {
        continue;
      }
      visited[y][x] = true;
      for (int d = 0; d < dir.length; d++) {
        int ny = dir[d][0] + y;
        int nx = dir[d][1] + x;

        if (!isInRange(ny, nx)) {
          continue;
        }

        if (visited[ny][nx]) {
          continue;
        }
        int diff = Math.abs(A[y][x] - A[ny][nx]);
        if (diff < L || diff > R) {
          continue;
        }

        separator[y][x].add(new int[]{ny, nx});

        candi.offer(ny);
        candi.offer(nx);
      }

    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    L = Integer.valueOf(st.nextToken());
    R = Integer.valueOf(st.nextToken());

    A = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    solution();
  }
}
