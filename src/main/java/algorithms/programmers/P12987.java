package algorithms.programmers;

import java.util.*;

public class P12987 {

  public int solution(int[] A, int[] B) {
    int answer = -1;
    int cnt = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    int min = 0;
    int max = B.length - 1;

    for (int i = A.length - 1; i >= 0; i--) {
      if (min > max) {
        break;
      }
      if (A[i] < B[min]) {
        min++;
        cnt++;
      } else {
        if (A[i] < B[max]) {
          max--;
          cnt++;
        } else {
          min++;
        }
      }
    }
    answer = cnt;

    return answer;
  }
}
