package algorithms.baekjoon;

import java.util.*;

public class B7576_2 {

  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  Queue<Integer> tomatoes = new LinkedList<>();
  int[][] info;
  int cnt = 1;
  public void solution(int[][] box) {
    info = box;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <box.length; i++) {
      for (int j = 0; j < box[i].length; j++) {
        if (box[i][j] == 1) {
          tomatoes.offer(i);
          tomatoes.offer(j);
        }
      }
    }
    BFS();
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

        if (!isInRange(ny, nx))
          continue;
        if (info[ny][nx] >= 1 || info[ny][nx] == -1)
          continue;
        info[ny][nx] = info[cy][cx] + 1;
        tomatoes.offer(ny);
        tomatoes.offer(nx);
      }
    }
    int max = Integer.MIN_VALUE;

    if (hasZero()) {
      System.out.println(-1);
      return;
    }

    for (int[] i : info) {
      for (int num : i) {
        max = Math.max(max, num);
      }
    }

    System.out.println(max - 1);
  }

  public boolean hasZero() {
    for (int i = 0; i < info.length; i++) {
      for (int j = 0; j < info[i].length; j++) {
        if (info[i][j] == 0) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    B7576_2 test = new B7576_2();
    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");
    int[][] map = new int[Integer.valueOf(size[1])][Integer.valueOf(size[0])];

    for (int i = 0; i < map.length; i++) {
      String[] line = sc.nextLine().split(" ");
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.parseInt(line[j]);
      }
    }
    test.solution(map);
  }
}
