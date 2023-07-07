package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RE_B2206 {

  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] info;

  public void solution(int[][] map) {
    info = map;

    System.out.println(BFS());
  }

  public boolean isInRange(int y, int x) {
    return y >= 0 && y < info.length && x >= 0 && x < info[0].length;
  }

  public int BFS() {
    Queue<Integer> walls = new LinkedList<>();

    int[][][] dist = new int[info.length][info[0].length][2];

    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist[i].length; j++) {
        for (int k = 0; k < 2; k++) {
          dist[i][j][k] = -1;
        }
      }
    }

    walls.offer(0);
    walls.offer(0);
    walls.offer(0);
    dist[0][0][0] = 1;

    while (!walls.isEmpty()) {
      int cy = walls.poll();
      int cx = walls.poll();
      int b = walls.poll();

      for (int d = 0; d < dir.length; d++) {
        int ny = cy + dir[d][0];
        int nx = cx + dir[d][1];

        if (!isInRange(ny, nx)) {
          continue;
        }
        if (dist[ny][nx][b] != -1) {
          continue;
        }
        if (info[ny][nx] == 1) {
          if (b == 0 && dist[ny][nx][1] == -1) {
            dist[ny][nx][1] = dist[cy][cx][0] + 1;
            walls.offer(ny);
            walls.offer(nx);
            walls.offer(1);
          }
          continue;
        }

        dist[ny][nx][b] = dist[cy][cx][b] + 1;
        walls.offer(ny);
        walls.offer(nx);
        walls.offer(b);
      }
    }

    if (dist[info.length-1][info[0].length-1][0] == -1 && dist[info.length-1][info[0].length-1][1] == -1) return -1;
    if (dist[info.length-1][info[0].length-1][0] == -1) return dist[info.length-1][info[0].length-1][1];
    if (dist[info.length-1][info[0].length-1][1] == -1) return dist[info.length-1][info[0].length-1][0];

    return Math.min(dist[info.length-1][info[0].length-1][0], dist[info.length-1][info[0].length-1][1]);
  }

  public static void main(String[] args) {
    RE_B2206 test = new RE_B2206();
    Scanner sc = new Scanner(System.in);

    String[] line = sc.nextLine().split(" ");
    int[][] map = new int[Integer.valueOf(line[0])][Integer.valueOf(line[1])];

    for (int i = 0; i < map.length; i++) {
      String row = sc.nextLine();
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = row.charAt(j) - '0';
      }
    }

    test.solution(map);
  }
}