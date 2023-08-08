package algorithms.softeer;

import java.util.*;
import java.io.*;

public class S1529 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] size = br.readLine().split(" ");

    int n = Integer.valueOf(size[0]);
    int m = Integer.valueOf(size[1]);

    List<Integer>[] board = new ArrayList[n + 1];
    List<Integer>[] boardR = new ArrayList[n + 1];

    for (int k = 0; k < board.length; k++) {
      board[k] = new ArrayList<>();
      boardR[k] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      String[] line = br.readLine().split(" ");
      board[Integer.valueOf(line[0])].add(Integer.valueOf(line[1]));
      boardR[Integer.valueOf(line[1])].add(Integer.valueOf(line[0]));
    }

    String[] pos = br.readLine().split(" ");
    int S = Integer.valueOf(pos[0]);
    int T = Integer.valueOf(pos[1]);

    boolean[] fromS = new boolean[n + 1];
    fromS[T] = true;
    BFS(S, board, fromS);

    boolean[] fromT = new boolean[n + 1];
    fromT[S] = true;
    BFS(T, board, fromT);

    boolean[] toT = new boolean[n + 1];
    BFS(S, boardR, toT);

    boolean[] toS = new boolean[n + 1];
    BFS(T, boardR, toS);
    int cnt = 0;
    for (int c = 0; c < n + 1; c++) {
      if (fromS[c] && fromT[c] && toS[c] && toT[c]) {
        cnt++;
      }
    }
    System.out.println(cnt - 2);
  }


  public static void BFS(int start, List<Integer>[] board, boolean[] visited) {
    Queue<Integer> candi = new LinkedList<>();

    candi.offer(start);

    while (!candi.isEmpty()) {
      int cur = candi.poll();

      if (!visited[cur]) {
        candi.offer(cur);
        visited[cur] = true;
      }

      for (int node : board[cur]) {
        if (visited[node]) {
          continue;
        }
        visited[node] = true;
        candi.offer(node);
      }
    }
  }
}
