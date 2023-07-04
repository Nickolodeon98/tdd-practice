package algorithms.baekjoon;

import java.util.*;

public class B2206 {

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
    Queue<Integer> collected = new LinkedList<>();

    int[][][] dist = new int[info.length][info[0].length][2];

    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist[i].length; j++) {
        for (int k = 0; k < 2; k++) {
          dist[i][j][k] = -1;
        }
      }
    }

    collected.offer(0);
    collected.offer(0);
    collected.offer(0);

    dist[0][0][0] = 1;

    while (!collected.isEmpty()) {
      int cy = collected.poll();
      int cx = collected.poll();
      int b = collected.poll();

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
          if (b == 0) {
            dist[ny][nx][1] = dist[cy][cx][0] + 1;
            collected.offer(ny);
            collected.offer(nx);
            collected.offer(1);
          }
          continue;
        }
        dist[ny][nx][b] = dist[cy][cx][b] + 1;
        collected.offer(ny);
        collected.offer(nx);
        collected.offer(b);
      }
    }
    if (dist[info.length-1][info[0].length-1][0] == -1 && dist[info.length-1][info[0].length-1][1] == -1) return -1;
    if (dist[info.length-1][info[0].length-1][0] == -1) return dist[info.length-1][info[0].length-1][1];
    if (dist[info.length-1][info[0].length-1][1] == -1) return dist[info.length-1][info[0].length-1][0];

    return Math.min(dist[info.length-1][info[0].length-1][0], dist[info.length-1][info[0].length-1][1]);
  }

  public static void main(String[] args) {
    B2206 test = new B2206();

    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");
    int[][] testMap = new int[Integer.valueOf(size[0])][Integer.valueOf(size[1])];

    for (int i = 0; i < testMap.length; i++) {
      String line = sc.next();
      for (int j = 0; j < testMap[i].length; j++) {
        testMap[i][j] = line.charAt(j) - '0';
      }
    }

    test.solution(testMap);
  }
}