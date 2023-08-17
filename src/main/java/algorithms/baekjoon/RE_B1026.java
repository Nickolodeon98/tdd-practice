package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B1026 {

  static int N;
  static int K;
  static String[] words;
  static boolean[] learnt;
  static int count = 0;
  static int max = 0;

  public static int solution() {
    learnt = new boolean[26];

    if (K < 5) {
      return 0;
    }

    learnt['a' - 97] = true;
    learnt['n' - 97] = true;
    learnt['t' - 97] = true;
    learnt['i' - 97] = true;
    learnt['c' - 97] = true;

    if (K == 5) {
      cntReadable();
      return count;
    }

    K -= 5;

    combination(0, 0);

    return max;
  }

  public static void cntReadable() {
    boolean check = true;

    for (String word : words) {
      for (char w : word.toCharArray()) {
        if (!learnt[w - 97]) {
          check = false;
        }
      }
      if (check) {
        count++;
        continue;
      }
      check = true;
    }
  }

  public static void combination(int cnt, int idx) {
    if (K == cnt) {
      cntReadable();
      max = Math.max(max, count);
      count = 0;
    }

    for (int i = idx; i < learnt.length; i++) {
      if (learnt[i]) {
        continue;
      }

      learnt[i] = true;
      combination(cnt + 1, i);
      learnt[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());

    words = new String[N];

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      words[i] = word;
    }

    System.out.println(solution());
  }
}