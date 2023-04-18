package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumDistances {

  /* For the following given graph, find the minimum number of edges between vertex pair (0, 4) */

  /* Adjacency Matrix */

  public void findMinimumPath(int start) {
//    String name = "JAEROEN";
//
//    int[] targetIndex = {0, 2, 3, 4, 5, 6};
//
//    int index = 0;
//
//    int right = 1;
//    int left = targetIndex.length - 1;
//    boolean[] visited = {false, false, false, false, false, false, false};
//    for () {
//      if (visited[right]) continue;
//      if (visited[left]) continue;
//      findMinimumPath();
//    }

    int[][] adjMatrix = {
        {0, 1, 0, 1, 1, 0, 0},
        {1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0},
        {1, 1, 1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 1, 0}};

//    System.out.println(adjMatrix[0][4]);

    int[][] dist = new int[7][7];

    for (int k = 0; k < dist.length; k++) {
      for (int l = 0; l < dist[k].length; l++) {
        dist[k][l] = 10000;
      }
    }

    dist[start][start] = 0;

    boolean[] visit = new boolean[7];
    for (int i = 0; i < visit.length; i++) {
      visit[i] = false;
    }

    Stack<Integer> possiblePos = new Stack<>();

    possiblePos.push(start);
    int pastPos = start;
    int totalDist = 0;
//      [4, 2, 3, 1]
    while (!possiblePos.isEmpty()) {
      System.out.println(possiblePos);
      System.out.println("current pastPos: " + pastPos);
      int posToVisit = possiblePos.pop();
      if (visit[posToVisit]) continue;
      visit[posToVisit] = true;

      if (posToVisit != start) {
        dist[start][posToVisit] = dist[start][pastPos] + Math.abs(pastPos - posToVisit);
      }
      totalDist = dist[start][posToVisit];
      for (int j = adjMatrix[posToVisit].length-1; j >= 0; j--) {
//        갈 수 있는 곳들의 위치 파악
        if (adjMatrix[posToVisit][j] == 1) possiblePos.push(j);

        pastPos = posToVisit;
      }

    }

    System.out.println("total: " + totalDist);

    for (int[] results : dist) {
      for (int result : results) {
        System.out.print(result + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    MinimumDistances test = new MinimumDistances();
    test.findMinimumPath(4);

  }
}
