package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {

  boolean[] visited;

  public void BFS(int N, int K) {
    visited = new boolean[200001];

    Queue<Integer> candi = new LinkedList<>();

    candi.offer(N);
    candi.offer(0);
    visited[N] = true;
    while (!candi.isEmpty()) {
      int pos = candi.poll();
      int time = candi.poll();

      if (pos == K) {
        System.out.println(time);
        return;
      }

      for (int i = 0; i < 3; i++) {
        int nPos = pos;
        if (i == 0 && pos > 0)
          nPos -= 1;
        else if (i == 1)
          nPos += 1;
        else
          nPos *= 2;

        if (nPos > 200000 || nPos < 0) continue;
        if (visited[nPos])
          continue;

        visited[nPos] = true;

        candi.offer(nPos);
        candi.offer(time + 1);
      }
    }
  }

  public static void main(String[] args) {
    B1697 test = new B1697();
    Scanner sc = new Scanner(System.in);

    String[] line = sc.nextLine().split(" ");

    test.BFS(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
  }
}
