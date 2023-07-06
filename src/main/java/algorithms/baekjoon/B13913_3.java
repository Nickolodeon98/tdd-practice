package algorithms.baekjoon;

import java.util.*;

public class B13913_3 {

  int n;
  int k;
  int[] parent = new int[100001];
  int[] time = new int[100001];

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

    Queue<Integer> pos = new LinkedList<>();
    pos.offer(n);
    while (true) {
      int now = pos.poll();

      if (now == k) return;
      int next;

      for (int i = 0; i < 3; i++) {
        if (i == 0) next = now + 1;
        else if (i == 1) next = now - 1;
        else next = 2 * now;

        if (next < 0 || next > 100000) continue;

        if (time[next] == 0) {
          time[next] = time[now] + 1;
          parent[next] = now;
          pos.offer(next);
        }
      }
    }
  }

  public static void main(String[] args) {
    B13913_3 test = new B13913_3();

    Scanner sc = new Scanner(System.in);

    String[] positions = sc.nextLine().split(" ");

    test.solution(Integer.valueOf(positions[0]), Integer.valueOf(positions[1]));
  }
}
