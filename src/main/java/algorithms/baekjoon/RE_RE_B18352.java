package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RE_RE_B18352 {

  public void solution(int n, List<Integer>[] map, int start, int k) {
    BFS(n, map, start, k);
  }

  public void BFS(int n, List<Integer>[] map, int cur, int k) {
    Queue<Integer> candi = new LinkedList<>();

    int[] dist = new int[n+1];

    Arrays.fill(dist, Integer.MAX_VALUE);

    candi.offer(cur);
    dist[cur] = 0;

    List<Integer> ans = new ArrayList<>();
    while (!candi.isEmpty()) {
      int current = candi.poll();

      if (dist[current] == k) ans.add(current);
      if (dist[current] > k) continue;

      for (int next : map[current]) {
        if (dist[next] != Integer.MAX_VALUE) continue;
        dist[next] = dist[current] + 1;
        candi.offer(next);
      }
    }
    StringBuilder sb = new StringBuilder();
    Collections.sort(ans);
    for (int a : ans) {
      sb.append(a + "\n");
    }
    System.out.println(ans.isEmpty() ? -1 : sb);
  }


  public static void main(String[] args) {
    RE_RE_B18352 test = new RE_RE_B18352();

    Scanner sc = new Scanner(System.in);

    String[] info = sc.nextLine().split(" ");

    int n = Integer.valueOf(info[0]);
    int m = Integer.valueOf(info[1]);
    int k = Integer.valueOf(info[2]);
    int start = Integer.valueOf(info[3]);

    List<Integer>[] map = new List[n+1];

    for (int j = 1; j <= n; j++) map[j] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      String[] line = sc.nextLine().split(" ");

      map[Integer.valueOf(line[0])].add(Integer.valueOf(line[1]));
    }

    test.solution(n, map, start, k);
  }
}
