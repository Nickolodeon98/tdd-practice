package algorithms.programmers;

import java.util.*;

public class P1844 {
  public boolean isInRange(int y, int x, int sizeY, int sizeX) {
    return y < sizeY && y >= 0 && x < sizeX && x >= 0;
  }

  public int bfs(int y, int x, int sizeY, int sizeX, int[][] maze) {
    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    int[][] dist = new int[sizeY][sizeX];

    for (int i = 0; i < sizeY; i++) {
      for (int j = 0; j < sizeX; j++) {
        dist[i][j] = 10000;
      }
    }

    Queue<Integer> q = new LinkedList<>();

    dist[y][x] = 0;
    q.add(y);
    q.add(x);
    while (!q.isEmpty()) {
      int sy = q.poll();
      int sx = q.poll();
      for (int i = 0; i < 4; i++) {
        int ny = sy + dir[i][0];
        int nx = sx + dir[i][1];
        if (!isInRange(ny, nx, sizeY, sizeX)) continue;
        if (maze[ny][nx] == 0) continue;
        if (dist[ny][nx] != 10000) continue;
        dist[ny][nx] = dist[sy][sx] + 1;
        q.add(ny);
        q.add(nx);
      }

    }
    // for (int[] d : dist) {
    //     for (int row : d)
    //         System.out.print(row + " ");
    //     System.out.println();
    // }
    return dist[sizeY-1][sizeX-1] == 10000 ? -1 : dist[sizeY-1][sizeX-1] + 1;
  }

  public int solution(int[][] maps) {
    int answer = 0;

    answer = bfs(0, 0, maps.length, maps[0].length, maps);
    return answer;
  }
}
