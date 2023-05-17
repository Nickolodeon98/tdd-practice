package algorithms.samsung;

import java.util.*;

public class Millionaire {

  public static boolean isAllMinusOne(List<Integer> money) {
    for (int i : money) {
      if (i != -1) {
        return false;
      }
    }
    return true;
  }

  public static int select(List<Integer> prices) {
    int max = 0;
    int maxIdx = -1;
    int idx = 0;
    for (int price : prices) {
      if (max < price) {
        max = price;
        maxIdx = idx;
      }
      idx++;
    }
    if (maxIdx == 0) {
      prices.removeAll(prices);
      return 0;
    }

    int sum = 0;
    int cnt = 0;
    for (int i = 0; i < maxIdx; i++) {
      if (prices.get(i) == -1) {
        continue;
      }
      sum += prices.get(i);
      prices.set(i, -1);
      cnt++;
    }
    prices.set(maxIdx, -1);

    int total = (max * cnt) - sum;

    return total;
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();
    sc.nextLine();
    for (int test_case = 1; test_case <= T; test_case++) {
      int cntTests = sc.nextInt();
      sc.nextLine();

      String[] costs = sc.nextLine().split(" ");

      List<Integer> money = new ArrayList<>();

      for (String cost : costs) {
        money.add(Integer.parseInt(cost));
      }

      int revenue = 0;
      while (!isAllMinusOne(money) && !money.isEmpty()) {
        revenue += select(money);
      }
      System.out.println("#" + test_case + " " + revenue);
    }
  }
}

