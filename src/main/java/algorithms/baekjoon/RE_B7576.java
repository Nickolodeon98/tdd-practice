package algorithms.baekjoon;

import java.util.*;

public class RE_B7576 {

  Queue<Integer> tomatoes = new LinkedList<>();
  int[][] info;
  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public void solution(int[][] box) {
    info = box;

    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[i].length; j++) {
        if (box[i][j] == 1) {
          tomatoes.offer(i);
          tomatoes.offer(j);
        }
      }
    }

    BFS();

  }

  public boolean hasZero() {
    for (int[] i : info) {
      for (int num : i) {
        if (num == 0) return true;
      }
    }
    return false;
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[0].length;
  }

  public void BFS() {
    while (!tomatoes.isEmpty()) {
      int cy = tomatoes.poll();
      int cx = tomatoes.poll();

      for (int d = 0; d < dir.length; d++) {
        int ny = cy + dir[d][0];
        int nx = cx + dir[d][1];

        if (!isInRange(ny, nx)) continue;
        if (info[ny][nx] > 0 || info[ny][nx] == -1) continue;
        info[ny][nx] = info[cy][cx] + 1;
        tomatoes.offer(ny);
        tomatoes.offer(nx);
      }
    }

    if (hasZero()) {
      System.out.println(-1);
      return;
    }

    int max = Integer.MIN_VALUE;
    for (int[] line : info) {
      for (int each : line) {
        max = Math.max(max, each);
      }
    }

    System.out.println(max-1);
  }

  public static void main(String[] args) {
    RE_B7576 test = new RE_B7576();

    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");

    int[][] map = new int[Integer.valueOf(size[1])][Integer.valueOf(size[0])];

    for (int i = 0; i < map.length; i++) {
      String[] row = sc.nextLine().split(" ");
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.valueOf(row[j]);
      }
    }

    test.solution(map);
  }

}
