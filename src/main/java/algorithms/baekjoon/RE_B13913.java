package algorithms.baekjoon;

import java.util.*;

public class RE_B13913 {
  int n;
  int k;
  int[] time = new int[100001];
  int[] parent = new int[100001];
  public void solution(int n, int k) {
    this.n = n;
    this.k = k;
    BFS();
    System.out.println(time[k]);

    Stack<Integer> show = new Stack<>();
    show.push(k);
    int idx = k;
    while (idx != n) {
      show.push(parent[idx]);
      idx = parent[idx];
    }

    while (!show.isEmpty()) {
      System.out.print(show.pop() + " ");
    }
  }

  public void BFS() {
    Queue<Integer> walks = new LinkedList<>();
    walks.offer(n);

    while (!walks.isEmpty()) {
      int now = walks.poll();

      if (now == k) return;

      for (int i = 0; i < 3; i++) {
        int next;

        if (i == 0) next = now + 1;
        else if (i == 1) next = now - 1;
        else next = 2 * now;

        if (next < 0 || next > 100000) continue;
        if (time[next] != 0) continue;
        time[next] = time[now] + 1;
        parent[next] = now;
        walks.offer(next);
      }
    }
  }

  public static void main(String[] args) {
    RE_B13913 test = new RE_B13913();
    Scanner sc = new Scanner(System.in);

    String[] pos = sc.nextLine().split(" ");

    test.solution(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]));
  }
}
