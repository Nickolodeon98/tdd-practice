package algorithms.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MazeProblem {

  static int[][] dir = {{-1,0}, {1,0}, {0, -1}, {0, 1}, {-1,-1}, {-1,1},{1,-1},{1,1}};
  static int[][] maze;
  static boolean[][] visited;
  static Stack<int[]> paths = new Stack<>();
  public static boolean isInRange(int y, int x) {
    return y < maze.length && y >= 0 && x < maze[y].length && x >= 0;
  }

  public static void init(int y, int x) {
    paths.push(new int[]{y,x, 0});
    visited = new boolean[maze.length][maze[0].length];

    while (!paths.isEmpty()) {
      int[] cur = paths.pop();
      int r = cur[0];
      int c = cur[1];
      int di = cur[2];
//      System.out.println("(" + (r+1) + ", " + (c+1) + ", " + di + ")");
      for (int d = di; d < dir.length; d++) {
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];
        if (!isInRange(nr, nc)) continue;
        if (nr == maze.length-1 && nc == maze[nr].length-1) {
          System.out.println("found!");
          return;
        }

        if (visited[nr][nc]) continue;

        if (maze[nr][nc] == 0) {
          visited[nr][nc] = true;
          paths.push(new int[]{r, c, d+1});
          System.out.println("(" + (r+1) + ", " + (c+1) + ", " + di + ")");
          r = nr;
          c = nc;
          d = 0;
        }
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(br.readLine());
    maze = new int[N][N];
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        maze[i][j] = Integer.valueOf(st.nextToken());
      }
    }
    init(0, 0);
  }
}
