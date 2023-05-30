package algorithms.programmers;

import java.util.*;

public class P77484 {

  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];

    Arrays.sort(lottos);
    Arrays.sort(win_nums);

    int lotPtr = 0;
    int winPtr = 0;
    int count = 0;
    int countZero = 0;
    while (lotPtr < 6 && winPtr < 6) {
      if (lottos[lotPtr] == 0) {
        countZero++;
        lotPtr++;
        continue;
      }
      if (lottos[lotPtr] < win_nums[winPtr]) {
        lotPtr++;
        continue;
      }
      if (lottos[lotPtr] > win_nums[winPtr]) {
        winPtr++;
        continue;
      }
      lotPtr++;
      winPtr++;
      count++;
    }

    int maxRank = count + countZero;
    int minRank = count;
    int[] rankings = {6, 6, 5, 4, 3, 2, 1};
    answer[0] = rankings[maxRank];
    answer[1] = rankings[minRank];

    return answer;
  }
}
