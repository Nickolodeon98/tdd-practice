package algorithms.softeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RE_Test2 {
  int vertexCnt;
  List<Integer>[] edges;
  Stack<Integer> answer;
  boolean[] visited;
  boolean[] finished;
  boolean cycle;
  public RE_Test2(int N) {
    this.vertexCnt = N;
    edges = new ArrayList[N+1];
    for (int i = 0; i < edges.length; i++) {
      edges[i] = new ArrayList<>();
    }
    answer = new Stack<>();
    visited = new boolean[N+1];
    finished = new boolean[N+1];
    cycle = false;
  }

  public void solution() {
    for (int j = 1; j <= vertexCnt; j++) {
      if (cycle) {
        finished[j] = true;
        return;
      }
      if (!visited[j]) {
        DFS(j);
      }
    }
    if (!answer.isEmpty()) {
      for (int s : answer) {
        System.out.print(s);
      }
    }

  }

  public void DFS(int v) {
    for (int k = 0; k < edges[v].size(); k++) {
      int cur = edges[v].get(k);

      if (!visited[cur]) {
        DFS(cur);
        visited[cur] = true;
      } else if (!finished[cur]) {
        cycle = true;
        return;
      }
    }
    finished[v] = true;
    answer.push(v);
  }

  public static void main(String[] args) {
    RE_Test2 test = new RE_Test2(7);

    test.edges[1].add(2);
    test.edges[1].add(3);
    test.edges[1].add(4);
    test.edges[2].add(5);
    test.edges[2].add(6);
    test.edges[3].add(7);
    test.edges[3].add(6);
    test.edges[4].add(3);
    test.edges[6].add(5);
    test.solution();
  }
}
