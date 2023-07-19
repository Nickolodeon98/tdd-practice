package algorithms.baekjoon;

import java.util.Scanner;

public class B18352 {

  boolean[] visited;
  public void solution(int[][] map, int k, int start) {
    visited = new boolean[map.length];
    int startIdx = 0;

    for (int i = 0; i < map.length; i++) {
        if (start == map[i][0]) startIdx = i;
        DFS(map, startIdx, k, 0);
    }

  }
  public void DFS(int[][] map, int startIdx, int limit, int cnt) {
    if (cnt == limit) {
      System.out.println(map[startIdx][1]);
      return;
    }

    for (int i = 0; i < map.length; i++) {
      if (visited[i]) continue;

      if (map[i][0] == map[startIdx][1]) {
        visited[i] = true;
        DFS(map, i, limit, cnt + 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    B18352 test = new B18352();

    Scanner sc = new Scanner(System.in);

    String[] info = sc.nextLine().split(" ");

    int n = Integer.valueOf(info[0]);
    int m = Integer.valueOf(info[1]);
    int k = Integer.valueOf(info[2]);
    int start = Integer.valueOf(info[3]);

    int[][] map = new int[n][2];

    for (int i = 0; i < m; i++) {
      String[] line = sc.nextLine().split(" ");

      map[i][0] = Integer.valueOf(line[0]);
      map[i][1] = Integer.valueOf(line[1]);
    }

    test.solution(map, k, start);
  }
}
