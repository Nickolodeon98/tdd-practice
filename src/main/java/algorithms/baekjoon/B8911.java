package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B8911 {

  static int[][] moves = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
  static final int HORIZONTAL = 0;
  static List<int[]> records;

  static List<Integer> areas;
  public static void solution(String control) {
    int y = 0;
    int x = 0;
    int toward = 0;
    records = new ArrayList<>();

    for (int i = 0; i < control.length(); i++) {
      char move = control.charAt(i);

      if (move == 'F') {
        y += moves[toward][0];
        x += moves[toward][1];
        records.add(new int[]{y, x});
      } else if (move == 'B') {
        y -= moves[toward][0];
        x -= moves[toward][1];
        records.add(new int[]{y, x});
      } else if (move == 'L') {
        toward++;
        if (toward == 4) {
          toward = 0;
        }
      } else if (move == 'R') {
        toward--;
        if (toward == -1) {
          toward = 3;
        }
      }
    }
    int minH = 0;
    int maxH = 0;
    int minV = 0;
    int maxV = 0;
    for (int[] record : records) {
      minH = Math.min(minH, record[0]);
      maxH = Math.max(maxH, record[0]);
      minV = Math.min(minV, record[1]);
      maxV = Math.max(maxV, record[1]);
    }
    areas.add(Math.abs(maxH-minH) * Math.abs(maxV-minV));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.valueOf(br.readLine());
    areas = new ArrayList<>();
    for (int i = 0; i < T; i++) {
      String control = br.readLine();
      solution(control);
    }

    for (int area : areas) {
      System.out.println(area);
    }
  }
}
