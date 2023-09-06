package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_B16234 {

  static int N;
  static int L;
  static int R;
  static int[][] A;
  static boolean[][] visited;
  static boolean[][] visit;
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static List<int[]>[][] separators;
  static int cnt = 0;
  static int total = 0;
  static boolean flag = true;
  public static void solution() {
    visited = new boolean[N][N];
    separators = new ArrayList[N][N];

    for (int s = 0; s < separators.length; s++) {
      for (int e = 0; e < separators[s].length; e++) {
        separators[s][e] = new ArrayList<>();
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        BFS(i, j);
      }
    }

    if (isAllEmpty()) {
      flag = false;
      return;
    }

    visit = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        BFS2(i, j);
        total = cnt = 0;
      }
    }

  }

  public static boolean isAllEmpty() {
    for (List<int[]>[] separator : separators) {
      for (List<int[]> sep : separator) {
        if (!sep.isEmpty()) return false;
      }
    }
    return true;
  }

  public static void BFS2(int y, int x) {
    Queue<Integer> candi = new LinkedList<>();
    Queue<Integer> storage = new LinkedList<>();
    candi.offer(y);
    candi.offer(x);
    storage.offer(y);
    storage.offer(x);

    while (!candi.isEmpty()) {
      int r = candi.poll();
      int c = candi.poll();

      if (visit[r][c]) {
        continue;
      }
      total += A[r][c];
      visit[r][c] = true;
      cnt++;

      if (separators[r][c].isEmpty()) {
        continue;
      }
      for (int[] separator : separators[r][c]) {
//          현재 위치를 확인한 후에 다음 위치로 갈 준비를 한다.
//          현재 위치에서 갈 수 있는 곳을 현재 위치로 설정해 탐색한다.
        int nr = separator[0];
        int nc = separator[1];

        candi.offer(nr);
        candi.offer(nc);
        storage.offer(nr);
        storage.offer(nc);

//        System.out.println(
//            "(" + r + ", " + c + ") is connected to (" + separator[0] + ", " + separator[1] + ")");
      }
    }

    if (total == 0 || cnt == 0) return;

    while (!storage.isEmpty()) {
      int r = storage.poll();
      int c = storage.poll();
      A[r][c] = total / cnt;
    }
  }

  public static boolean isInRange(int y, int x) {
    return y < N && y >= 0 && x < N && x >= 0;
  }

  public static void BFS(int r, int c) {
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
        separators[y][x].add(new int[]{ny, nx});

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

    int ans = 0;
    while(true) {
      solution();
      if (!flag) break;
      ans++;
    }

    System.out.println(ans);
//
//    for (int[] grounds : A) {
//      for (int ground : grounds) {
//        System.out.print(ground + " ");
//      }
//      System.out.println();
//    }
  }
}
