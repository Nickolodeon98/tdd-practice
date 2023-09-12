package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDimensionalTetris {

  static int[][] blueBoard;
  static int[][] redBoard;
  static int[][] yellowBoard;
  static final int BOARD_SIZE = 4;
  static int score = 0;

  enum Board {
    RED, YELLOW
  }

  public static void solution(int t, int x, int y) {

    putBlock(t, x, y);
//    System.out.println("1.");
//    for (int[] red : redBoard) {
//      for (int r : red) {
//        System.out.print(r + " ");
//      }
//      System.out.println();
//    }

//    System.out.println("2.");

//    for (int[] yellow : yellowBoard) {
//      for (int ye : yellow) {
//        System.out.print(ye + " ");
//      }
//      System.out.println();
//    }

    score += countWins();
    checkTransparent();

//    System.out.println("3.");
//    for (int[] red : redBoard) {
//      for (int r : red) {
//        System.out.print(r + " ");
//      }
//      System.out.println();
//    }
  }

  private static void checkTransparent() {

    for (int red = 0; red < BOARD_SIZE; red++) {
      if (redBoard[red][0] == 1) {
        for (int r = 0; r < BOARD_SIZE; r++) {
          for (int pos = BOARD_SIZE + 1; pos > 0; pos--) {
            redBoard[r][pos] = redBoard[r][pos - 1];
          }
          redBoard[r][0] = 0;
        }
      }
      if (redBoard[red][1] == 1) {
        for (int r = 0; r < BOARD_SIZE; r++) {
          for (int pos = BOARD_SIZE + 1; pos > 1; pos--) {
            redBoard[r][pos] = redBoard[r][pos - 1];
          }
          redBoard[r][1] = 0;
        }
      }
    }
    for (int yellow = 0; yellow < BOARD_SIZE; yellow++) {
      if (yellowBoard[0][yellow] == 1) {
        for (int y = 0; y < BOARD_SIZE; y++) {
          for (int pos = BOARD_SIZE + 1; pos > 0; pos--) {
            yellowBoard[pos][y] = yellowBoard[pos - 1][y];
          }
          yellowBoard[0][y] = 0;
        }
      }
      if (yellowBoard[1][yellow] == 1) {
        for (int y = 0; y < BOARD_SIZE; y++) {
          for (int pos = BOARD_SIZE + 1; pos > 1; pos--) {
            yellowBoard[pos][y] = yellowBoard[pos - 1][y];
          }
          yellowBoard[1][y] = 0;
        }
      }
    }
  }

  public static void putBlock(int type, int row, int column) {
    if (type == 1) {
      blueBoard[row][column] = 1;
      moveBlock(Board.RED, row, 1);
      moveBlock(Board.YELLOW, column, 1);
    }

    if (type == 2) {
      blueBoard[row][column] = 1;
      blueBoard[row][column + 1] = 1;
      moveBlock(Board.RED, row, 2);
      moveBlock(Board.YELLOW, column, 2);
    }

    if (type == 3) {
      blueBoard[row][column] = 1;
      blueBoard[row + 1][column] = 1;
      moveBlock(Board.RED, row, 3);
      moveBlock(Board.YELLOW, column, 3);
    }
  }

  public static void moveBlock(Board color, int pivot, int type) {
    int end = 0;

    if (type == 1) {
      if (color == Board.RED) {
        while (end < BOARD_SIZE + 2 && redBoard[pivot][end] == 0) {
          end++;
        }
//        if (end == BOARD_SIZE + 2) {
//          end--;
//        }
        redBoard[pivot][end-1] = 1;
      }
      if (color == Board.YELLOW) {
        while (end < BOARD_SIZE + 2 && yellowBoard[end][pivot] == 0) {
          end++;
        }

        yellowBoard[end-1][pivot] = 1;
      }
    }

    if (type == 2) {
      if (color == Board.RED) {
        while (end + 1 < BOARD_SIZE + 2 && redBoard[pivot][end] == 0 && redBoard[pivot][end + 1] == 0) {
          end++;
        }

        redBoard[pivot][end-1] = 1;
        redBoard[pivot][end] = 1;

      }

      if (color == Board.YELLOW) {
        while (end < BOARD_SIZE + 2 && yellowBoard[end][pivot] == 0 && yellowBoard[end][pivot + 1] == 0) {
          end++;
        }

        yellowBoard[end-1][pivot] = 1;
        yellowBoard[end-1][pivot + 1] = 1;
      }
    }

    if (type == 3) {
      if (color == Board.RED) {
        while (end < BOARD_SIZE + 2 && redBoard[pivot][end] == 0 && redBoard[pivot + 1][end] == 0) {
          end++;
        }

        redBoard[pivot][end-1] = 1;
        redBoard[pivot + 1][end-1] = 1;
      }

      if (color == Board.YELLOW) {
        while (end + 1 < BOARD_SIZE + 2 && yellowBoard[end][pivot] == 0 && yellowBoard[end + 1][pivot] == 0) {
          end++;
        }

        yellowBoard[end-1][pivot] = 1;
        yellowBoard[end][pivot] = 1;
      }
    }
  }

  public static int countWins() {
    boolean flagR = true;
    boolean flagY = true;
    int cnt = 0;

    for (int c = BOARD_SIZE + 1; c >= 2; ) {
      for (int r = 0; r < BOARD_SIZE; r++) {
        if (flagR)
          flagR = redBoard[r][c] == 1;
//        if (flagY)
//          flagY = yellowBoard[c][r] == 1;
      }
      if (flagR) {
        for (int column = c; column >= 1; column--) {
          for (int a = 0; a < BOARD_SIZE; a++) {
            redBoard[a][column] = redBoard[a][column - 1];
          }
          for (int b = 0; b < BOARD_SIZE; b++) {
            redBoard[b][0] = 0;
          }
        }

        cnt++;
        c++;
      }
//      if (flagY) {
//        for (int row = c; row >= 1; row--) {
//          for (int r = 0; r < BOARD_SIZE; r++) {
//            yellowBoard[row][r] = yellowBoard[row - 1][r];
//          }
//          for (int r = 0; r < BOARD_SIZE; r++) {
//            yellowBoard[0][r] = 0;
//          }
//        }
//        cnt++;
//        c++;
//      }

      flagR = true;
      c--;
    }


    for (int c = BOARD_SIZE + 1; c >= 2; ) {
      for (int r = 0; r < BOARD_SIZE; r++) {
        if (flagY)
          flagY = yellowBoard[c][r] == 1;
      }

      if (flagY) {
        for (int row = c; row >= 1; row--) {
          for (int r = 0; r < BOARD_SIZE; r++) {
            yellowBoard[row][r] = yellowBoard[row - 1][r];
          }
          for (int r = 0; r < BOARD_SIZE; r++) {
            yellowBoard[0][r] = 0;
          }
        }
        cnt++;
        c++;
      }

      flagY = true;
      c--;
    }

    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.valueOf(br.readLine());

    blueBoard = new int[BOARD_SIZE][BOARD_SIZE];
    redBoard = new int[BOARD_SIZE][BOARD_SIZE + 2];
    yellowBoard = new int[BOARD_SIZE + 2][BOARD_SIZE];

    StringTokenizer st = null;
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int t = Integer.valueOf(st.nextToken());
      int x = Integer.valueOf(st.nextToken());
      int y = Integer.valueOf(st.nextToken());

      solution(t, x, y);

    }
    System.out.println(score);
    int total = 0;
    for (int[] red : redBoard) {
      for (int r : red) {
        total += r;
      }
    }

    for (int[] yellow : yellowBoard) {
      for (int y : yellow) {
        total += y;
      }
    }

    System.out.println(total);
  }
}
