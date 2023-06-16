package algorithms.programmers;

import java.util.*;

public class P154540 {

  boolean[][] visited;
  //     상, 하, 좌, 우
  int[] dy = {1, -1, 0, 0};
  int[] dx = {0, 0, -1, 1};

  public List<Integer> solution(String[] maps) {
    List<Integer> answer = new ArrayList<>();
    visited = new boolean[maps.length][maps[0].length()];

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[i].length(); j++) {
        if (visited[i][j]) {
          continue;
        }
        if (maps[i].charAt(j) == 'X') {
          continue;
        }
        answer.add(BFS(i, j, maps));
      }
    }
    if (answer.isEmpty()) {
      answer.add(-1);
    }
    Collections.sort(answer);
    return answer;
  }

  public int BFS(int y, int x, String[] maps) {
    visited[y][x] = true;
    Queue<Integer> lands = new LinkedList<>();
    int sum = 0;

    lands.add(y);
    lands.add(x);

    while (!lands.isEmpty()) {
      int cy = lands.poll();
      int cx = lands.poll();

      sum += maps[cy].charAt(cx) - '0';

      for (int d = 0; d < 4; d++) {
        int ny = cy + dy[d];
        int nx = cx + dx[d];

        if (!isInRange(ny, nx, maps)) {
          continue;
        }

        if (visited[ny][nx]) {
          continue;
        }

        if (maps[ny].charAt(nx) == 'X') {
          continue;
        }

        lands.add(ny);
        lands.add(nx);
        visited[ny][nx] = true;
      }

    }
    return sum;
  }

  private boolean isInRange(int y, int x, String[] maps) {
    return y >= 0 && y < maps.length && x >= 0 && x < maps[0].length();
  }

}
