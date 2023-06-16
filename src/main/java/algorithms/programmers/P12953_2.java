package algorithms.programmers;

import java.util.*;

public class P12953_2 {
  public int solution(int[] arr) {
    int answer = 0;
    answer = lcm(arr);
    return answer;
  }

  public int lcm(int[] arr) {
    int answer = arr[0], g;

    for (int i = 1; i < arr.length; i++) {
      g = gcd(answer, arr[i]);
      answer = g * (arr[i] / g) * (answer / g);
    }
    return answer;
  }

  public int gcd(int first, int second) {
    if (first > second) {
      return (first % second == 0) ? second : gcd(second, first % second);
    } else {
      return (second % first == 0) ? first : gcd(first, second % first);
    }
  }
}
