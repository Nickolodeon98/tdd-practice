package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B5557 {
  static List<Integer> nums;
  static int[] ns;
  static int N;
  static int[] dp;
  static List<Integer>[] sum;

  public static void solution() {
    dp = new int[N + 1];
    sum = new ArrayList[N + 1];

    for (int s= 0; s < sum.length; s++) {
      sum[s] = new ArrayList<>();
    }

    sum[N].add(ns[ns.length-1] + ns[ns.length-2]);
    sum[N].add(ns[ns.length-1] - ns[ns.length-2]);

    for (int i = 0; i < sum[N].size(); i++) {
      if (sum[N].get(i) >= 0) {
        dp[N] += 1;
      }
    }

    for (int j = ns.length - 2; j > 0; j--) {
      if (j == 1) {
        for (int k = 0; k < sum[j+1].size(); k++) {
          int plus = sum[j+1].get(k) + ns[j];
          int minus = sum[j+1].get(k) - ns[j];

          if (plus == 0) {
            dp[j]++;
          }
          if (minus == 0) {
            dp[j]++;
          }
        }
      } else {
        for (int k = 0; k < sum[j + 1].size(); k++) {
          if (sum[j + 1].get(k) < 0)
            continue;

          int plus = sum[j + 1].get(k) + ns[j];
          int minus = sum[j + 1].get(k) - ns[j];

          if (plus >= 0 && plus <= 20) {
            sum[j].add(plus);
            dp[j] += 1;
          }
          if (minus >= 0 && minus <= 20) {
            sum[j].add(minus);
            dp[j] += 1;
          }
        }
      }
    }

    for (int d : dp) {
      System.out.println(d + " ");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    nums = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      int num = Integer.valueOf(st.nextToken());
      if (num == 0) continue;
      nums.add(num);
    }

    ns = nums.stream().mapToInt(i->i).toArray();
    solution();
  }

}
