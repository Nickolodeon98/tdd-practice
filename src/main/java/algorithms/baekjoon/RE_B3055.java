package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RE_B3055 {

  boolean[][] visited;
  Queue<int[]> candi = new LinkedList<>();
  Queue<int[]> water = new LinkedList<>();
  int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

  char[][] info;
  int time = 0;
  int ans = Integer.MAX_VALUE;
  public void solution(char[][] map) {
    visited = new boolean[map.length][map[0].length];
    info = map;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == '*') {
          water.offer(new int[]{i,j});
        }
        if (map[i][j] == 'S') {
          visited[i][j] = true;
          candi.offer(new int[]{i,j,time});
        }
      }
    }

    BFS();
    System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[y].length;
  }

  public void BFS() {

    while (!candi.isEmpty()) {
      int wLen = water.size();

      for (int i = 0; i < wLen; i++) {
        int[] w = water.poll();

        for (int d = 0; d < dir.length; d++) {
          int nWy = w[0] + dir[d][0];
          int nWx = w[1] + dir[d][1];

          if (!isInRange(nWy, nWx)) continue;
          if (info[nWy][nWx] == 'X' || info[nWy][nWx] == 'D' || info[nWy][nWx] == '*') continue;
          info[nWy][nWx] = '*';
          water.offer(new int[]{nWy,nWx});
        }
      }

      int cLen = candi.size();

      for (int j = 0; j < cLen; j++) {
        int[] c = candi.poll();

        for (int d = 0; d < dir.length; d++) {
          int nCy = c[0] + dir[d][0];
          int nCx = c[1] + dir[d][1];

          if (!isInRange(nCy, nCx)) continue;

          if (info[nCy][nCx] == 'D')
            ans = Math.min(ans, c[2] + 1);
          if (info[nCy][nCx] == '*' || info[nCy][nCx] == 'X') continue;
          if (visited[nCy][nCx]) continue;
          visited[nCy][nCx] = true;
          info[c[0]][c[1]] = '.';
          info[nCy][nCx] = 'S';
          candi.offer(new int[]{nCy,nCx,c[2]+1});
        }
      }
    }
  }

  public static void main(String[] args) {
    RE_B3055 test = new RE_B3055();

    Scanner sc = new Scanner(System.in);
    String[] line = sc.nextLine().split(" ");
    char[][] map = new char[Integer.valueOf(line[0])][Integer.valueOf(line[1])];

    for (int i = 0; i < map.length; i++) {
      String s = sc.nextLine();
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = s.charAt(j);
      }
    }
    test.solution(map);
  }
}
