package algorithms.programmers;

public class P67256_2 {

  public int[] getPos(int key) {
    int[] pos = new int[2];
    if (key == 0) {
      pos[0] = 3;
      pos[1] = 1;
      return pos;
    }

    pos[0] = (int) Math.ceil(key / 3.0) - 1;

    pos[1] = key % 3 == 0 ? 2 : (key % 3) - 1;

    return pos;
  }

  public int getDist(int[] one, int[] other) {
    return Math.abs(one[0] - other[0]) + Math.abs(one[1] - other[1]);
  }

  public String solution(int[] numbers, String hand) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    int[] leftH = {3, 0};
    int[] rightH = {3, 2};

    for (int number : numbers) {
      if (number == 1 || number == 4 || number == 7) {
        sb.append("L");
        leftH = getPos(number);
        continue;
      }
      if (number == 3 || number == 6 || number == 9) {
        sb.append("R");
        rightH = getPos(number);
        continue;
      }
      int leftDist = getDist(leftH, getPos(number));
      int rightDist = getDist(rightH, getPos(number));
      if (leftDist == rightDist) {
        if (hand.equals("left")) {
          sb.append("L");
          leftH = getPos(number);
          continue;
        }
        sb.append("R");
        rightH = getPos(number);
        continue;
      }
      if (Math.min(leftDist, rightDist) == leftDist) {
        sb.append("L");
        leftH = getPos(number);
        continue;
      }
      sb.append("R");
      rightH = getPos(number);
    }
    answer = sb.toString();
    return answer;
  }
}
