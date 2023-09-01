package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_RE_B2294 {

  static int n;
  static int k;
  static int[] coins;
  static int[] cases;
  public static void solution() {
    cases = new int[k + 1];
    Arrays.fill(cases, Integer.MAX_VALUE - 1);
    cases[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j <= k; j++) {
        cases[j] = Math.min(cases[j], cases[j - coins[i]] + 1);
      }
    }

    System.out.println(cases[k] == Integer.MAX_VALUE - 1 ? -1 : cases[k]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.valueOf(st.nextToken());
    k = Integer.valueOf(st.nextToken());

    coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = Integer.valueOf(br.readLine());
    }

    solution();
  }

}
