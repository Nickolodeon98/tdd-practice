package algorithms.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class RE_RE_B1520 {
  int[][] memo;
  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] info;
  public void solution(int[][] map) {
    memo = new int[map.length][map[0].length];
    info = map;
    for (int[] m : memo) {
      Arrays.fill(m, -1);
    }

    System.out.println(DFS(0, 0));
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[0].length;
  }

  public int DFS(int y, int x) {
    if (y == info.length-1 && x == info[0].length -1)
      return 1;

    if (memo[y][x] != -1)
      return memo[y][x];

    memo[y][x] = 0;
    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) continue;

      if (info[ny][nx] < info[y][x])
        memo[y][x] += DFS(ny, nx);
    }

    return memo[y][x];
  }

  public static void main(String[] args) {
    RE_RE_B1520 test = new RE_RE_B1520();

    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");

    int row = Integer.valueOf(size[0]);
    int col = Integer.valueOf(size[1]);

    int[][] map = new int[row][col];

    for (int i = 0; i < row; i++) {
      String[] line = sc.nextLine().split(" ");
      for (int j = 0; j < col; j++) {
        map[i][j] = Integer.valueOf(line[j]);
      }
    }
    test.solution(map);
  }
}
