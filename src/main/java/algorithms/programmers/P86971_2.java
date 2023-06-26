package algorithms.programmers;

import java.util.*;

public class P86971_2 {

  boolean[][] graph;
  int wiresTotal;

  public int constructGraph(int[][] wires) {
    int answer = Integer.MAX_VALUE;
    graph = new boolean[wiresTotal + 1][wiresTotal + 1];

    for (int i = 0; i < wires.length; i++) {
      graph[wires[i][0]][wires[i][1]] = true;
      graph[wires[i][1]][wires[i][0]] = true;
    }

    for (int j = 0; j < wires.length; j++) {
      graph[wires[j][0]][wires[j][1]] = false;
      graph[wires[j][1]][wires[j][0]] = false;

      answer = Math.min(answer, BFS(1));

      graph[wires[j][0]][wires[j][1]] = true;
      graph[wires[j][1]][wires[j][0]] = true;
    }

    return answer;
  }

  boolean[] visited;

  public int BFS(int current) {
    visited = new boolean[graph.length];
    Queue<Integer> q = new LinkedList<>();
    int cnt = 1;

    q.add(current);

    while (!q.isEmpty()) {
      int cWire = q.poll();
      visited[cWire] = true;

      for (int i = 1; i <= wiresTotal; i++) {
        if (visited[i]) {
          continue;
        }

        if (graph[cWire][i] || graph[i][cWire]) {
          q.add(i);
          cnt++;
        }
      }
    }

    return Math.abs(2 * cnt - wiresTotal);
  }

  public int solution(int n, int[][] wires) {
    int answer = -1;
    wiresTotal = n;
    answer = constructGraph(wires);
    return answer;
  }

}
