package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B13913_2 {

  int n, k;
  int[] time = new int[100001];
  int[] parent = new int[100001];

  public void solution() {
    n = 5;
    k = 17;

    Stack<Integer> st = new Stack<>();
    int idx = k;
    while (parent[idx] != n) {
      st.push(parent[idx]);
      idx = parent[idx];
    }

    System.out.println(st);
  }

  public void BFS() {
    Queue<Integer> waits = new LinkedList<>();

    time[n] = 1;
    waits.offer(n);

    while (!waits.isEmpty()) {
      int now = waits.poll();

      if (now == k) return;

      for (int i = 0; i < 3; i++) {
        int next;
        if (i == 0) next = now + 1;
        else if (i == 1) next = now - 1;
        else next = now * 2;

        if (next < 0 || next > 100000) continue;

        time[next] = time[now] + 1;
        parent[next] = now;
        waits.offer(next);
      }
    }
  }

  public static void main(String[] args) {
    B13913_2 test = new B13913_2();

    test.solution();
  }
}
