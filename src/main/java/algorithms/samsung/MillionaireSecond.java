package algorithms.samsung;

import java.util.*;

public class MillionaireSecond {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();
    //sc.nextLine();
    for (int test_case = 1; test_case <= T; test_case++) {
      int pricesCnt = sc.nextInt();

      int[] prices = new int[pricesCnt];

      for (int i = 0; i < pricesCnt; i++) {
        prices[i] = sc.nextInt();
      }
      int max = 0;
      for (int price : prices) {
        max = Math.max(price, max);
      }
      int spent = 0;
      int spentCnt = 0;
      int total = 0;
      for (int j = 0; j < pricesCnt; j++) {
        if (prices[j] != max) {
          spent += prices[j];
          spentCnt++;
        } else {
          total += (max * spentCnt) - spent;
          spent = spentCnt = 0;
          if (j + 1 < pricesCnt) {
            max = 0;
            for (int k = j + 1; k < pricesCnt; k++) {
              max = Math.max(prices[k], max);
            }
          }
        }
      }

      System.out.println("#" + test_case + " " + total);
    }
  }
}


