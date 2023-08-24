package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_B1697 {

  static int N;
  static int K;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;
  public static boolean isInRange(int num) {
    return num >= 0 && num < 200000;
  }

  public static void solution() {
    visited = new boolean[200000];
    Queue<Integer> candi = new LinkedList<>();

    candi.offer(N);
    candi.offer(0);

    while (!candi.isEmpty()) {
      int cur = candi.poll();
      int time = candi.poll();

      if (cur == K) {
        min = Math.min(min, time);
      }

      for (int i = 0; i < 3; i++) {
        int pos = 0;
        if (i == 0) pos = cur + 1;
        else if (i == 1) pos = cur - 1;
        else pos = 2 * cur;
        if (!isInRange(pos)) continue;
        if (visited[pos]) continue;
        visited[pos] = true;
        candi.offer(pos);
        candi.offer(time + 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());

    solution();
    System.out.println(min);
  }

}
