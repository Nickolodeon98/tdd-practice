package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B1107 {

  static int N;
  static int M;
  static boolean[] broken;
  static int length;
  static boolean[] visited;
  static int min;
  public static void solution() {
    min = Math.abs(100 - N);

    if (N == 100) {
      System.out.println(0);
      return;
    }

    if (M == 0) {
      min = Math.min(min, String.valueOf(N).length());
      System.out.println(min);
      return;
    }

    visited = new boolean[10];
    DFS(new StringBuilder());
    System.out.println(min);
  }

  public static void DFS(StringBuilder sb) {
    if (sb.length() != 0) {
      int moves = Math.abs(Integer.valueOf(sb.toString()) - N) + sb.length();
      min = Math.min(min, moves);
    }

    if (sb.length() > 6) return;

    for (int i = 0; i < 10; i++) {
      if (broken[i]) {
        continue;
      }
      sb.append(i);
      DFS(sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    M = Integer.valueOf(br.readLine());

    broken = new boolean[10];
    length = String.valueOf(N).length();

    if (M == 0) {
      solution();
      return;
    }
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < M; i++) {
      int t = Integer.valueOf(st.nextToken());
      broken[t] = true;
    }



    solution();
  }
}
