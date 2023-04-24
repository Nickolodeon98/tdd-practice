package algorithms.baekjoon;

import java.util.Scanner;

public class SugarAllocation {

  public int completeSearch(int grams, int storage, int cnt) {
    if (grams == 0) {
      return cnt;
    } else if (grams < 0) return -1;

    cnt++;

    int remains = grams + storage;

    int withFive = completeSearch(remains, 5, cnt);
    int withThree = completeSearch(remains, 3, cnt);

    if (withFive == -1) return withThree;
    if (withThree == -1) return withFive;

    return Math.min(withFive, withThree);
  }

  public static void main(String[] args) {
    SugarAllocation test = new SugarAllocation();

    int[] input = {18, 4, 6, 9, 11};
    for (int in : input) {
      int resultFive = test.completeSearch(in, 5, 0);
      int resultThree = test.completeSearch(in, 3, 0);

      if (resultFive == -1) {
        System.out.println(resultThree);
      } else if (resultThree == -1) {
        System.out.println(resultFive);
      } else {
        int answer = Math.min(resultFive, resultThree);
        System.out.println(answer);
      }
    }
  }
}
