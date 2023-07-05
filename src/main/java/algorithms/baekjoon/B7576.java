package algorithms.baekjoon;

import java.util.*;

public class B7576 {

  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] info;
  Queue<Integer> box = new LinkedList<>();

  public void solution(int[][] structure) {
    info = structure;
    for (int i = 0; i < info.length; i++) {
      for (int j = 0; j < info[i].length; j++) {
        if (info[i][j] == 1) {
          box.offer(i);
          box.offer(j);
        }
      }
    }
    System.out.println(BFS());
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[0].length;
  }

  public int BFS() {
    while (!box.isEmpty()) {
      int cy = box.poll();
      int cx = box.poll();
      for (int d = 0; d < dir.length; d++) {
        int ny = cy + dir[d][0];
        int nx = cx + dir[d][1];
        if (!isInRange(ny, nx)) {
          continue;
        }
        if (info[ny][nx] == 0) {
          info[ny][nx] = info[cy][cx] + 1;
          box.offer(ny);
          box.offer(nx);
        }
      }
    }
    int max = Integer.MIN_VALUE;

    if (hasZero()) {
      return -1;
    } else {
      for (int l = 0; l < info.length; l++) {
        for (int m = 0; m < info[l].length; m++) {
          max = Math.max(max, info[l][m]);
        }
      }
      return max - 1;
    }
  }
  public boolean hasZero() {
    for (int[] num : info) {
      for (int n : num) {
        if (n == 0) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    B7576 test = new B7576();

    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");

    int[][] testMap = new int[Integer.valueOf(size[0])][Integer.valueOf(size[1])];

    for (int i = 0; i < testMap.length; i++) {
      String[] line = sc.nextLine().split(" ");
      for (int j = 0; j < testMap[i].length; j++) {
        testMap[i][j] = Integer.valueOf(line[j]);
      }
    }

    test.solution(testMap);
  }

}
