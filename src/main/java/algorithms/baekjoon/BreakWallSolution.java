package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreakWallSolution {

  class Node {
    int i, j, cnt;
  }

  List<List<Node>> adj = new ArrayList<>();


  public int[][] getInput() {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    int[][] map = new int[N][];

    for (int i = 0; i < ) {
      String[] userPrompts = sc.nextLine().split(" ");
    }

    return map;
  }

  int[][] dir = {{}, {}, {}, {}};
  public void graphConstruction() {
    Node[][][] a = new Node[NM][NM][2];

    List<List<Node>> dist = new ArrayList<>();

    for (int j = 0; j < dist.size(); j++) {
      dist.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int d = 0; d < dir.length; d++) {
          int ni = i + dir[d][0];
          int nj = j + dir[d][1];

          if (ni < 1 || ni > n || nj < 1 || nj > m) continue;
          if (a[ni][nj] == 0) {
            a[i][j][0] = new Node(ni, nj, 0);
            a[i][j][1] = new Node(ni, nj, 1);
          }
          if (a[ni][nj] == 1) {
            a[i][j][0] = new Node(ni, nj, 1);
          }
        }
      }
    }




  }

}
