package algorithms.programmers;

import java.util.*;

public class P81302_2 {

  public boolean isInRange(int row, int column) {
    return row < 5 && row >= 0 && column < 5 && column >= 0;
  }

  public boolean BFS(int r, int c, String[] seats) {
    int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    Queue<Integer> q = new LinkedList<>();

    q.add(r);
    q.add(c);

    while (!q.isEmpty()) {
      int row = q.poll();
      int col = q.poll();
      for (int i = 0; i < dir.length; i++) {
        int nr = row + dir[i][0];
        int nc = col + dir[i][1];

        int manh = Math.abs(r - nr) + Math.abs(c - nc);
        if (!isInRange(nr, nc) || (nr == r && nc == c)) {
          continue;
        }
        if (seats[nr].charAt(nc) == 'P' && manh <= 2) {
          return false;
        }
        if (seats[nr].charAt(nc) == 'O' && manh < 2) {
          q.add(nr);
          q.add(nc);
        }
      }
    }
    return true;
  }

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    int idx = 0;
    boolean isCorrect = true;
    for (String[] p : places) {
      for (int i = 0; i < p.length; i++) {
        for (int j = 0; j < p[i].length(); j++) {
          if (p[i].charAt(j) != 'P') {
            continue;
          }
          if (!BFS(i, j, p)) {
            isCorrect = false;
            continue;
          }
        }
      }
      answer[idx] = isCorrect ? 1 : 0;
      idx++;
      isCorrect = true;
    }
    return answer;
  }
}
