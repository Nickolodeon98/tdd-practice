package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RE_RE_B15686 {

  static int N;
  static int M;
  static int[][] board;
  static int closed;
  static int count;
  static int[][] chicken;
  static boolean[] close;
  static List<int[]> total;
  static int totalDist = Integer.MAX_VALUE;

  public static void solution() {
    chicken = new int[13][2];
    count = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 2) {
          chicken[count][0] = i;
          chicken[count][1] = j;
          count++;
        }
      }
    }
    closed = count - M;

    compute();
    System.out.println(totalDist);
  }

  static int min = Integer.MAX_VALUE;
  static int chickenDist;

  public static void compute() {
    chickenDist = 0;
    total = new ArrayList<>();
    combination(0, 0, new int[closed]);

    close = new boolean[chicken.length];
    for (int[] candi : total) {
      close = new boolean[chicken.length];
      for (int c : candi) {
        close[c] = true;
      }

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 0 || board[i][j] == 2) {
            continue;
          }

          if (board[i][j] == 1) {
            for (int k = 0; k < count; k++) {
              if (close[k]) continue;
              min = Math.min(min, Math.abs(i - chicken[k][0]) + Math.abs(j - chicken[k][1]));
            }
          }

          chickenDist += min;
          min = Integer.MAX_VALUE;
        }

      }
      totalDist = Math.min(totalDist, chickenDist);
      chickenDist = 0;
    }


  }

  public static void combination(int cnt, int idx, int[] nums) {
    if (cnt == closed) {
      int[] newNums = Arrays.copyOf(nums, nums.length);

      total.add(newNums);
      return;
    }

    for (int i = idx; i < count; i++) {
      nums[cnt] = i;
      combination(cnt + 1, i + 1, nums);
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.valueOf(st.nextToken());
    M = Integer.valueOf(st.nextToken());

    board = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    solution();
  }

}
