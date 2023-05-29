package algorithms.programmers;

public class P67256 {

  public int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1},
      {2, 2}};

  public int getLeng(int[] target, int[] toCompare) {
    int length = 0;
    length = Math.abs(target[0] - toCompare[0]) + Math.abs(target[1] - toCompare[1]);

    return length;
  }

  public String solution(int[] numbers, String hand) {
    String answer = "";
    int[] LptrPos = {3, 0};
    int[] RptrPos = {3, 2};

    for (int elem : numbers) {
      if (elem == 1 || elem == 4 || elem == 7) {
        answer += "L";
        LptrPos = keypad[elem];
      } else if (elem == 3 || elem == 6 || elem == 9) {
        answer += "R";
        RptrPos = keypad[elem];
      } else {
        if (getLeng(keypad[elem], LptrPos) < getLeng(keypad[elem], RptrPos)) {
          answer += "L";
          LptrPos = keypad[elem];
        } else if (getLeng(keypad[elem], LptrPos) > getLeng(keypad[elem], RptrPos)) {
          answer += "R";
          RptrPos = keypad[elem];
        } else {
          if (hand.equals("left")) {
            answer += "L";
            LptrPos = keypad[elem];
          } else if (hand.equals("right")) {
            answer += "R";
            RptrPos = keypad[elem];
          }
        }
      }
    }

    return answer;
  }
}
