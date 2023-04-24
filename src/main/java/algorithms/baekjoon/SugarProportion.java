package algorithms.baekjoon;

public class SugarProportion {
  public int bottomUp(int grams, int storage, int current, int cnt) {

    cnt++;
    int added = current + storage;

    if (added == grams) return cnt;
    if (added > grams) return -1;

    int withFive = bottomUp(grams, 5, added, cnt);
    if (withFive > 0) return withFive;

    int withThree = bottomUp(grams, 3, added, cnt);
    if (withThree > 0) return withThree;

    if (withFive == -1) return withThree;
    if (withThree == -1) return withFive;

    return Math.min(withFive, withThree);
  }

  public static void main(String[] args) {
    SugarProportion test = new SugarProportion();
    int[] input = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    for (int in : input) {
      int resultFive = test.bottomUp(in, 5, 0, 0);
      int resultThree = test.bottomUp(in, 3, 0, 0);

      if (resultFive == -1) {
        System.out.println(resultThree);
      } else if (resultThree == -1) {
        System.out.println(resultFive);
      } else {
        System.out.println(Math.min(resultFive, resultThree));
      }
    }
  }
}
