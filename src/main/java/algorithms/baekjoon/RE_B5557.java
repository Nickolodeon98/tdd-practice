package algorithms.baekjoon;

import java.io.*;
import java.util.*;

public class RE_B5557 {

  static int N;
  static int[] nums;
  static List<Integer>[] sum;

  public static boolean isInRange(int num1, int num2, char type) {
    return (type == '+') ? (num1 + num2 > 0) && (num1 + num2 <= 20)
        : (num1 - num2 > 0) && (num1 - num2 <= 20);
  }

  public static void solution() {
    sum = new ArrayList[N];

    for (int s = 0; s < sum.length; s++) {
      sum[s] = new ArrayList<>();
    }

    if (isInRange(nums[N - 1], nums[N - 2], '+')) {
      int nNum = nums[N - 1] + nums[N - 2];
      sum[N - 2].add(nNum);
    }

    if (isInRange(nums[N - 1], nums[N - 2], '-')) {
      int nNum = nums[N - 1] - nums[N - 2];
      sum[N - 2].add(nNum);
    }

    for (int i = N - 2; i > 0; i--) {
      for (int j = 0; j < sum[i].size(); j++) {
        int nNum = 0;
        if (isInRange(sum[i].get(j), nums[i - 1], '+')) {
          nNum = sum[i].get(j) + nums[i - 1];
          sum[i-1].add(nNum);
        }
        if (isInRange(sum[i].get(j), nums[i - 1], '-')) {
          nNum = sum[i].get(j) - nums[i - 1];
          sum[i-1].add(nNum);
        }

        if (i == 1) {
          if (sum[i].get(j) + nums[i - 1] == 0) {
            sum[i-1].add(sum[i].get(j) + nums[i - 1]);
          }
          if (sum[i].get(j) - nums[i - 1] == 0) {
            System.out.println("hi");
            sum[i-1].add(sum[i].get(j) - nums[i - 1]);
          }
        }
      }

    }
    int cnt = 0;
    for (List<Integer> num : sum) {
      System.out.println(num);
    }

    for (int s : sum[0]) {
      if (s == 0) cnt++;
    }

    System.out.println(cnt);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.valueOf(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    nums = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.valueOf(st.nextToken());
    }

    solution();
  }
}

