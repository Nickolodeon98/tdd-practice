package algorithms.baekjoon;

import java.sql.SQLOutput;

public class B17406 {
  boolean[] visited;
  int[][] arr;
  public void solution() {
    arr = new int[][]
          {{1, 2, 3, 2, 5, 6},
          {3, 8, 7, 2, 1, 3},
          {8, 2, 3, 1, 4, 5},
          {3, 4, 5, 1, 1, 1},
          {9, 3, 2, 1, 4, 3}};
    int[] condition = new int[]{3, 4, 2};
    spin(condition);
  }

  public void DFS() {

  }

  public void spin(int[] condition) {
    int temp = 0;
    for (int i = condition[0] - condition[2] - 1; i <= condition[0] + condition[2]-1; i++) {
      for (int j = condition[1] - condition[2] - 1; j <= condition[1] + condition[2]-1; j++) {
        if (((i == condition[0] - condition[2] - 1) || (i == condition[0] + condition[2] - 1)) || ((j == condition[1] - condition[2] - 1) || (j == condition[1] + condition[2] - 1))) {

          if (i == condition[0] - condition[2] - 1) {
            if (j + 1 > condition[1] + condition[2] - 1) {
              temp = arr[i + 1][j];
              arr[i + 1][j] = arr[i][j];
              if (i + 2 <= condition[0] + condition[2] - 1) {
                arr[i + 2][j] = temp;
              }
            } else {
              temp = arr[i][j + 1];
              arr[i][j + 1] = arr[i][j];
              if (j + 2 <= condition[1] + condition[2] - 1) {
                arr[i][j+2] = temp;
              }
            }
          }

          if (i == condition[0] + condition[2] - 1) {
            if (j - 1 < condition[1] - condition[2] - 1) {
              temp = arr[i - 1][j];
              arr[i - 1][j] = arr[i][j];
            } else {
              temp = arr[i][j - 1];
              arr[i][j - 1] = arr[i][j];
            }
          }

//          arr[i][j] = temp;
        }

      }

    }

    for (int[] a : arr) {
      for (int b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    B17406 test = new B17406();

    test.solution();
  }

}
