package algorithms.programmers;

public class P43165 {

  public int plusOrMinus(int target, int value, int idx, int sign, int[] numbers) {
    int ret = 0;

    if (sign == 0) {
      value += numbers[idx];
    } else if (sign == 1) {
      value -= numbers[idx];
    }

    idx++;

    if (idx >= numbers.length) {
      if (value == target) {
        return 1;
      } else {
        return 0;
      }
    }

    for (int i = 0; i < 2; i++) {
      ret += plusOrMinus(target, value, idx, i, numbers);
    }

    return ret;
  }

  public int solution(int[] numbers, int target) {
    int answer = 0;

    answer = plusOrMinus(target, 0, 0, 0, numbers) + plusOrMinus(target, 0, 0, 1, numbers);

    return answer;
  }

}
