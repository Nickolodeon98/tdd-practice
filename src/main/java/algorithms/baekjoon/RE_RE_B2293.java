package algorithms.baekjoon;

public class RE_RE_B2293 {

  int[] coins;
  int[] memo;
  public void solution(int goal, int[] coins) {
    this.coins = coins;
    memo = new int[goal+1];

    memo[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= goal; j++) {
        memo[j] += memo[j - coins[i]];
      }
    }

    System.out.println(memo[goal]);
  }

  public static void main(String[] args) {
    RE_RE_B2293 test = new RE_RE_B2293();

    test.solution(10, new int[]{1, 2, 5});
  }
}
