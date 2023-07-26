package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10971 {

  boolean[] visited;
  int[][] info;
  int ans = Integer.MAX_VALUE;
  public void solution(int N, int[][] W) {
    info = W;
    visited = new boolean[N];
    visited[0] = true;

    DFS(0,0, 0, 0);

    System.out.println(ans);
  }

  public void DFS(int start, int cur, int cost, int count) {
    if (count == info.length-1) {
      if (info[cur][start] != 0) {
        cost += info[cur][start];
        if (cost < ans)
          ans = cost;
      }
      return;
    }
    for (int dest = 0; dest < info[cur].length; dest++) {
      if (visited[dest]) {
        continue;
      }
      if (info[cur][dest] == 0) continue;
      visited[dest] = true;
      DFS(start, dest, cost + info[cur][dest], count + 1);
      visited[dest] = false;
    }
  }

  public static void main(String[] args) {
    B10971 test = new B10971();
    Scanner sc = new Scanner(System.in);

    int num = Integer.valueOf(sc.nextLine());

    int[][] map = new int[num][num];

    for (int i = 0; i < map.length; i++) {
      String[] line = sc.nextLine().split(" ");
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.valueOf(line[j]);
      }
    }
    test.solution(num, map);
  }
}
