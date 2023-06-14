//package algorithms.baekjoon;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class BreakWall {
//  class Node {
//    int i, j, cnt;
//
//
//  }
//
//  public int[][] input() {
//    Scanner sc = new Scanner(System.in);
//
//    String[] nAndM = sc.nextLine().split(" ");
//    int N = Integer.parseInt(nAndM[0]);
//    int M = Integer.parseInt(nAndM[1]);
//
//    int[][] mapCpy = new int[N][M];
//
//    for (int n = 0; n < N; n++) {
//      String[] row = sc.nextLine().split("");
//      for (int m = 0; m < M; m++) {
//        mapCpy[n][m] = Integer.parseInt(row[m]);
//      }
//    }
//    return mapCpy;
//  }
//
//  public void graphConstruction() {
//    int[][] map = input();
//
//    Node[][] graph = new Node[map.length][map[0].length];
//    int n = 0;
//    int m = 0;
//
//    List<Integer>[] adj = new ArrayList[map.length];
//
//    int count =0;
//    for (int[] row : map) {
//        adj[count] = List.of(row);
//        count++;
//    }
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < m; j++) {
//        graph[i][j] = new Node();
//      }
//    }
//  }
//
//}
