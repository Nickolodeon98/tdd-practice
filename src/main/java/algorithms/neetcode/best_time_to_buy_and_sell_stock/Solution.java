package algorithms.neetcode.best_time_to_buy_and_sell_stock;

class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length-1; i++) {
      int toCompare = i + 1;

      while (toCompare < prices.length) {
        maxProfit = Math.max(maxProfit, prices[toCompare] - prices[i]);
        toCompare++;
      }
    }

    return maxProfit;
  }
}

