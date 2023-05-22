package algorithms.programmers;

import java.util.*;

public class P81302 {

  public boolean isInRange(int y, int x) {
    return y < 5 && y >= 0 && x < 5 && x >= 0;
  }

  public boolean isValid(List<char[]> chairs, int y, int x) {
    int[][] dir
        = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1},
        {0, -1}, {2, 0}, {-2, 0}, {0, 2}, {0, -2}};

    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];
      if (!isInRange(ny, nx)) {
        continue;
      }
      if (chairs.get(ny)[nx] == 'P') {
        return false;
      }
    }

    return true;
  }

  public int[] solution(String[][] places) {
    int[] answer = {};
    List<List<char[]>> seats = new ArrayList<>();
    List<char[]> moved = new ArrayList<>();

    for (int i = 0; i < places.length; i++) {
      for (int j = 0; j < places[i].length; j++) {
        char[] seat = places[i][j].toCharArray();
        moved.add(seat);
      }
      seats.add(moved);
    }
    boolean flag = true;
    int cnt = 0;
    for (List<char[]> chairs : seats) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (!isValid(chairs, i, j)) {
            flag = false;
            continue;
          }
        }
      }

      if (flag == false) {
        System.out.println(0);
        continue;
      }
      System.out.println(1);

    }
    return answer;
  }
}
