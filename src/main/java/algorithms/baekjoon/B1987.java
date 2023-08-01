package algorithms.baekjoon;

import java.util.Scanner;

public class B1987 {

  int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
  StringBuilder sb = new StringBuilder();
  char[][] info;
  int cnt = Integer.MIN_VALUE;
  public void solution(char[][] map) {
    info = map;
    sb.append(map[0][0]);
    DFS(0,0, sb.toString());

    System.out.println(cnt);
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[y].length;
  }

  public void DFS(int y, int x, String s) {
    cnt = Math.max(cnt, sb.length());

    for(int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) continue;
      if (s.contains(String.valueOf(info[ny][nx]))) continue;

      sb.append(info[ny][nx]);
      DFS(ny, nx, sb.toString());
      sb.deleteCharAt(sb.length()-1);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] line = sc.nextLine().split(" ");

    int y = Integer.valueOf(line[0]);
    int x = Integer.valueOf(line[1]);

    char[][] map = new char[y][x];

    for (int i = 0; i < map.length; i++) {
      String s = sc.nextLine();
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    B1987 test = new B1987();

    test.solution(map);
  }
}
