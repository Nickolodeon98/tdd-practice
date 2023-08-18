package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107 {
  static int N;
  static int[] broken;
  static boolean[] visited;

  public static void solution() {
    visited = new boolean[10];

    for (int b : broken) {
      visited[b] = true;
    }
    if (N == 100) {
      System.out.println(0);
      return;
    }
    move();
  }

  public static boolean isInRange(int pos) {
    return pos >= 0;
  }

  public static void move() {
    String channel = String.valueOf(N);
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    StringBuilder sb3 = new StringBuilder();

    for (int i = 0; i < channel.length(); i++) {
      int move1 = (channel.charAt(i) - '0') - 9;
      int move2 = 0;
      int move3 = 0;
      while (visited[(channel.charAt(i) - '0') - move1]) {
        move1++;
      }
      while (visited[(channel.charAt(i) - '0') - move2]) {
        if (move2 != 0 && channel.charAt(i) - '0' - move2 <= 0) break;
        move2++;
      }
      while (visited[(channel.charAt(i) - '0') - move3]) {
        if (move3 != 0 && channel.charAt(i) - '0' - move3 >= 9) {
          break;
        }
        if (move3 < 0) break;
        move3--;
      }
      sb1.append((channel.charAt(i) - '0') - move1);
      sb2.append((channel.charAt(i) - '0') - move2);
      sb3.append((channel.charAt(i) - '0') - move3);
    }

    System.out.println(sb1);
    System.out.println(sb2);
    System.out.println(sb3);

    int count1 = Math.abs(N - Integer.valueOf(sb1.toString()));
    int count2 = Math.abs(N - Integer.valueOf(sb2.toString()));
    int count3 = Math.abs(N - Integer.valueOf(sb3.toString()));

    int min = Math.min(sb1.length() + count1, sb2.length() + count2);
    min = Math.min(min, sb3.length() + count3);

    System.out.println(min);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    int M = Integer.valueOf(br.readLine());

    broken = new int[M];

    if (M == 0) {
      solution();
      return;
    }
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < M; i++) {
      int t = Integer.valueOf(st.nextToken());
      broken[i] = t;
    }

    solution();
  }

}
