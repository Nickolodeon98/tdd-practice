package algorithms.programmers;

import java.util.*;

public class P42895 {


  public int solution(int N, int number) {
    int answer = 0;

    List<Set<Integer>> all = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      all.add(new HashSet<Integer>());
    }

    all.get(1).add(N);

    for (int j = 2; j < 9; j++) {
      Set<Integer> numList = all.get(j);

      for (int k = 1; k <= j; k++) {
        Set<Integer> pre = all.get(k);
        Set<Integer> post = all.get(j - k);

        for (int preNum : pre) {
          for (int postNum : post) {
            numList.add(preNum + postNum);
            numList.add(preNum * postNum);
            numList.add(preNum - postNum);

            if (preNum != 0 && postNum != 0) {
              numList.add(preNum / postNum);
            }
          }
        }
      }
      numList.add(Integer.parseInt(String.valueOf(N).repeat(j)));
    }

    for (Set<Integer> belong : all) {
      if (belong.contains(number)) {
        return all.indexOf(belong);
      }
    }

    return -1;
  }


}
