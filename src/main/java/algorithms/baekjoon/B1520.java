package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1520 {
//  경로의 수는 1 + 다음 수에서 가는 경로의 수 이다.


  public boolean isInRange(int y, int x, int limitY, int limitX) {
    return y >= 0 && y < limitY && x >= 0 && x < limitX;
  }

  int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public void solution(int M, int N, int[][] map) {
    int[][] memo = new int[M][N];
    Queue<Integer> q = new LinkedList<>();

    q.offer(map.length-1);
    q.offer(map[0].length-1);

    while (!q.isEmpty()) {
      int cy = q.poll();
      int cx = q.poll();

      for (int d = 0; d < dir.length; d++) {
        int ny = cy + dir[d][0];
        int nx = cx + dir[d][1];
        if (!isInRange(ny, nx, M, N)) {
          continue;
        }

        if (map[ny][nx] > map[cy][cx]) {
          memo[ny][nx] += 1;
          q.offer(ny);
          q.offer(nx);
        }
      }

    }

//    for (int[] m : memo) {
//      for (int i : m) {
//        System.out.print(i + " ");
//      }
//      System.out.println();
//    }
    System.out.println(memo[0][0]);
  }

  public static void main(String[] args) {
    B1520 test = new B1520();

    Scanner sc = new Scanner(System.in);
    String[] s = sc.nextLine().split(" ");
    int m = Integer.valueOf(s[0]);
    int n = Integer.valueOf(s[1]);

    int[][] map = new int[m][n];

    for (int i = 0; i < map.length; i++) {
      String[] line = sc.nextLine().split(" ");
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.valueOf(line[j]);
      }
    }
    test.solution(m, n, map);
  }
}
