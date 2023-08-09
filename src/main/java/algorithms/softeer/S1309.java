package algorithms.softeer;

import java.io.*;
import java.util.*;

public class S1309 {


  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(br.readLine());

    int[][] competitions = new int[4][N];
    int[][] results = new int[4][N];
    int[] finals = new int[N];

    for (int i = 0; i < 3; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        competitions[i][j] = Integer.valueOf(line[j]);
        results[i][j] = Integer.valueOf(line[j]);
        finals[j] += Integer.valueOf(line[j]);
      }
    }
    for (int f = 0; f < finals.length; f++) {
      competitions[3][f] = finals[f];
      results[3][f] = finals[f];
    }

    Map<Integer, Integer>[] rankings = new HashMap[4];

    for (int r = 0; r < rankings.length; r++) {
      rankings[r] = new HashMap<>();
    }

    Stack<Integer> sort = new Stack<>();
    int[] prev = new int[]{-1, -1};
    int first = 1;
    int cnt = 0;
    for (int[] comp : competitions) {
      Arrays.sort(comp);

      for (int k = comp.length - 1; k >= 0; k--) {
        if (prev[0] == comp[k]) {
          rankings[cnt].put(comp[k], prev[1]);
          first++;
          continue;
        }
        prev[0] = comp[k];
        prev[1] = first;
        rankings[cnt].put(comp[k], first++);
      }
      cnt++;
      first = 1;
    }

    for (int row = 0; row < results.length; row++) {
      for (int col = 0; col < results[row].length; col++) {
        results[row][col] = rankings[row].get(results[row][col]);
        System.out.print(results[row][col] + " ");
      }
      System.out.println();
    }
  }

}
