package algorithms.programmers;

import java.util.*;

public class P12953 {

  public int solution(int[] arr) {
    Arrays.sort(arr);

    int standard = arr[arr.length - 1];

    while (true) {
      for (int i = 0; i < arr.length; i++) {
        if (standard % arr[i] != 0) {
          break;
        }
        if (i == arr.length - 1) {
          return standard;
        }
      }
      standard += arr[arr.length - 1];
    }
  }

}
