package algorithms.baekjoon;

import java.util.Scanner;

public class B11047 {
  public int distributeCoins(int value, int[] coins) {
    int cnt = 0;
    for (int i = coins.length-1; i >= 0; i--) {
      if (value / coins[i] > 0) {
        cnt += value / coins[i];
        value = value % coins[i];
      }
      if (value == 0) break;
    }
    return cnt;
  }

  public static void main(String[] args) {
    B11047 test = new B11047();

    Scanner sc = new Scanner(System.in);

    String[] nums = sc.nextLine().split(" ");
    int n = Integer.parseInt(nums[0]);
    int k = Integer.parseInt(nums[1]);

    int[] coins = new int[n];

    for (int j = 0; j < n; j++) {
      String type = sc.nextLine();
      coins[j] = Integer.parseInt(type);
    }

    System.out.println(test.distributeCoins(k, coins));
  }
}
