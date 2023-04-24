package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.List;

public class SugarDelivery {


  public int algo(int grams) {
    int remains = 0;
    int[] options = {5, 3};
    int cnt = 0;
    int min = 0;
    List<Integer> results = new ArrayList<>();
    int tempGrams = grams;
    for (int i = 0; i < options.length; i++) {
      while (grams > 0) {
        cnt++;
//       1. 11 > 5, cnt = 1
//        1-2. 6 > 5, cnt = 2
//      2. 11 > 3, cnt = 1;
//        2 - 2. 8 > 3, cnt = 2;
//        2-3. 5 > 3, cnt = 3;
        if (grams > options[i]) {
          remains = grams - options[i];
//      1. remains = 11 - 5 = 6;
//          1-2. remains = 6 - 5 = 1;
//      2. remains = 11 - 3 = 8;
//          2-2. remains = 8 - 3 = 5;
//          2-3. remains = 5 - 3 = 2;
        } else {
          results.add(cnt);
          grams = tempGrams;
          break;
        }
//      예: 11
//        3보다 적게 남으면 아래
        if (remains < 3) {
          results.add(-1);
//          results = [-1];
//          2-3. results = [-1, -1];
          grams = tempGrams;
          break;
        } else if (remains < 5) {
//        5보다 적게 남고 3으로 배분 가능하면 아래
          if (remains % 3 == 0) {
            grams = remains;
//         3으로도 배분 못하면 끝
          } else {
            results.add(cnt);
            grams = tempGrams;
            break;
          }
//      5를 뺀 이후에 5 또는 3으로 배분 가능하면 아래
//          1. remains = 6 -> 6 % 3 == 0
//          2-2. remains = 5 -> 5 % 5 == 0
        } else if (remains % 5 == 0 || remains % 3 == 0) {
          grams = remains;
//          2-2. grams = 5;

//          1. grams = 6;
//        5와 3의 조합으로 배분이 되면 아래
//         2. remains = 8 -> 8 % 5 % 3 == 0
        } else if ((remains % 5) % 3 == 0) {
          grams = remains;
//        5를 뺀 이후에 5와 3 모두 배분이 안 되면 아래
        } else {
          results.add(cnt);
          grams = tempGrams;
          break;
        }
      }
      cnt = 0;
    }
    for (int r : results) {
      min = Math.min(min, r);
    }

    return min;
  }

}
