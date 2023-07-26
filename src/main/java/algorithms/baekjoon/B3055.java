package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055 {

  int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  Queue<int[]> candi = new LinkedList<>();
  Queue<int[]> water = new LinkedList<>();
  char[][] info;
  int time = 0;
  int ans = Integer.MAX_VALUE;

  boolean[][] visited;
  public void solution(char[][] map) {
    info = map;
    visited = new boolean[map.length][map[0].length];

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 'S') {
          candi.offer(new int[]{i, j, time});
        }
        if (map[i][j] == '*') {
          water.offer(new int[]{i, j});
        }
      }
    }

    BFS();
    if (ans == Integer.MAX_VALUE) {
      System.out.println("KAKTUS");
    } else System.out.println(ans);
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[y].length;
  }

  public void BFS() {
    while (!candi.isEmpty()) {
      int wLen = water.size();

      for (int i = 0; i < wLen; i++) {
        int[] wXy = water.poll();

        for (int d = 0; d < dir.length; d++) {
          int ny = wXy[0] + dir[d][0];
          int nx = wXy[1] + dir[d][1];

          if (!isInRange(ny, nx)) continue;
          if (info[ny][nx] == 'X' || info[ny][nx] == 'D' || info[ny][nx] == '*') continue;
          info[ny][nx] = '*';
          water.offer(new int[]{ny, nx});
        }
      }

      int cLen = candi.size();

      for (int i = 0; i < cLen; i++) {
        int[] cXy = candi.poll();
        visited[cXy[0]][cXy[1]] = true;

        for (int d = 0; d < dir.length; d++) {
          int nCy = cXy[0] + dir[d][0];
          int nCx = cXy[1] + dir[d][1];

          if (!isInRange(nCy, nCx)) continue;
          if (visited[nCy][nCx]) continue;
          if (info[nCy][nCx] == '*' || info[nCy][nCx] == 'X') continue;
          if (info[nCy][nCx] == 'D') {
            ans = Math.min(ans, cXy[2] + 1);
            return;
          }
          if (info[nCy][nCx] == '.') {
            info[cXy[0]][cXy[1]] = '.';
            info[nCy][nCx] = 'S';
            candi.offer(new int[]{nCy, nCx, cXy[2] + 1});
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    B3055 test = new B3055();

    Scanner sc = new Scanner(System.in);

    String[] s = sc.nextLine().split(" ");

    int R = Integer.valueOf(s[0]);
    int C = Integer.valueOf(s[1]);

    char[][] map = new char[R][C];

    for (int i = 0; i < map.length; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    test.solution(map);
  }

}
