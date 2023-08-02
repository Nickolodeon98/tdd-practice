package algorithms.programmers;

import java.util.*;

public class RE_P77484 {
  int[] ranks = {6, 6, 5, 4, 3, 2, 1};

  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];

    List<Integer> winNums = new ArrayList<>();

    for (int num : win_nums) {
      winNums.add(num);
    }

    List<Integer> ls = new ArrayList<>();

    int cnt = 0;
    for (int l : lottos) {
      ls.add(l);
      if (l == 0) {
        cnt++;
      }
    }

    winNums.retainAll(ls);

    answer[0] = ranks[winNums.size() + cnt];
    answer[1] = ranks[winNums.size()];

    return answer;
  }
}
