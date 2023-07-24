package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B2667 {

  int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
  int[][] info;
  boolean[][] visited;
  public void solution(int[][] map) {
    info = map;
    visited = new boolean[map.length][map.length];
    int cnt = 0;
    List<Integer> counts = new ArrayList<>();
    for (int i = 0; i < info.length; i++) {
      for (int j = 0; j < info.length; j++) {
        if (visited[i][j]) continue;
        if (info[i][j] == 1) {
          counts.add(BFS(i, j));
          cnt++;
        }

      }
    }
    Collections.sort(counts);
    System.out.println(cnt);
    for (int c : counts) {
      System.out.println(c);
    }
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info.length;
  }

  public int BFS(int y, int x) {
    Queue<Integer> candi = new LinkedList<>();

    candi.offer(y);
    candi.offer(x);

    int[][] dist = new int[info.length][info.length];

    for (int[] di : dist) {
      Arrays.fill(di, -1);
    }

    dist[y][x] = 1;
    int count = 1;
    while (!candi.isEmpty()) {
      int cy = candi.poll();
      int cx = candi.poll();

      visited[cy][cx] = true;

      for (int d = 0; d < dir.length; d++) {
        int ny = cy + dir[d][0];
        int nx = cx + dir[d][1];

        if (!isInRange(ny, nx))
          continue;
        if (dist[ny][nx] != -1)
          continue;
        if (info[ny][nx] == 0)
          continue;

        dist[ny][nx] = dist[cy][cx] + 1;
        count++;
        candi.offer(ny);
        candi.offer(nx);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    B2667 test = new B2667();
    Scanner sc = new Scanner(System.in);

    int size = Integer.valueOf(sc.nextLine());

    int[][] map = new int[size][size];

    for (int i = 0; i < size; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < size; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    test.solution(map);
  }
}
