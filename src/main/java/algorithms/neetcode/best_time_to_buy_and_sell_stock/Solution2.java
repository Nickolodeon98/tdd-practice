package algorithms.neetcode.best_time_to_buy_and_sell_stock;

class Solution2 {
  public int maxProfit(int[] prices) {
    int left = 0;
    int right = 1;
    int maxProfit = 0;
    while (left < prices.length-1 && right < prices.length) {
      maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
      if (prices[left] > prices[right]) {
        left++;
        right = left+1;
      } else {
        right++;
      }
    }

    return maxProfit;
  }
}

