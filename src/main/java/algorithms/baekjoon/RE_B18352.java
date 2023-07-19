package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RE_B18352 {

  boolean[][] connected;
  boolean[] visited;
  int cnt = 0;
  public void solution(int total, int[][] map, int start, int goal) {
    connected = new boolean[total+1][total+1];
    visited = new boolean[total+1];

    for (int[] m : map) {
      connected[m[0]][m[1]] = true;
    }

    BFS(start, goal, total);
  }

  public void BFS(int start, int goal, int total) {
    Queue<Integer> candi = new LinkedList<>();
    Stack<Integer> shortest = new Stack<>();
    candi.offer(start);
    visited[start] = true;

    while (!candi.isEmpty()) {
      int cur = candi.poll();

      if (cnt == goal) {
        System.out.println(cur);
        System.out.println(shortest.peek());
        cnt = 0;
      }

      for (int i = 1; i <= total; i++) {
        if (visited[i]) continue;
        if (!connected[cur][i]) continue;

        visited[i] = true;
        candi.offer(i);
        shortest.push(cur);
        cnt++;
      }
    }
  }

  public static void main(String[] args) {
    RE_B18352 test = new RE_B18352();

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

    test.solution(n, map, start, k);
  }
}
