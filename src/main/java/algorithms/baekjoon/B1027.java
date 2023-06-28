package algorithms.baekjoon;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1027 {

  int[] buildings;
  int[] sight;
  public void solution() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(reader.readLine());

    buildings = new int[N];
    sight = new int[N];

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    for (int i = 0; i < N; i++) {
      buildings[i] = Integer.valueOf(tokenizer.nextToken());
    }
    findTop();
    Arrays.sort(sight);
    System.out.println(sight[sight.length-1]);
  }


  public void findTop() {
    for (int j = 0; j < buildings.length - 1; j++) {
      sight[j] += 1;
      sight[j+1] += 1;
      double slope = (buildings[j+1] - buildings[j]);

      for (int k = j + 2; k < buildings.length; k++) {
        double newSlope = (double) (buildings[k] - buildings[j]) / (k - j);
        if (newSlope <= slope) continue;
        slope = newSlope;
        sight[k]++;
        sight[j]++;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    B1027 test = new B1027();

    test.solution();
  }
}
