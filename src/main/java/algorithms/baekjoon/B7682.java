package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7682 {

  static int[][] dir = {{0, 0}, {1, 1}, {2, 2}};
  static int[][] dir2 = {{0, 2}, {1, 1}, {2, 0}};
  static int[][] horizontal = {{0, 0}, {0, 1}, {0, 2}};
  static int[][] vertical = {{0, 0}, {1, 0}, {2, 0}};

  public static boolean isTicTacToe(char[][] board, char c) {
    boolean flagD1 = true;
    boolean flagD2 = true;
    boolean flagV = true;
    boolean flagH = true;

    boolean flagVH = false;
    for (int i = 0; i < 3; i++) {
      flagV = true;
      flagH = true;

      for (int h = 0; h < horizontal.length; h++) {
        if (board[i + horizontal[h][0]][horizontal[h][1]] != c) {
          flagH = false;
        }
      }

      for (int v = 0; v < vertical.length; v++) {
        if (board[vertical[v][0]][i + vertical[v][1]] != c) {
          flagV = false;
        }
      }

      if (flagH || flagV) {
        flagVH = true;
        break;
      }
    }

    for (int d = 0; d < dir.length; d++) {
      if (board[dir[d][0]][dir[d][1]] != c) {
        flagD1 = false;
      }

      if (board[dir2[d][0]][dir2[d][1]] != c) {
        flagD2 = false;
      }
    }

    return flagVH || flagD1 || flagD2;
  }

  public static int count(char[][] board, char toCount) {
    int cnt = 0;
    for (char[] b : board) {
      for (char c : b) {
        if (c == toCount) {
          cnt++;
        }
      }
    }

    return cnt;
  }


  public static boolean solution(char[][] board) {
    if (count(board, 'X') - count(board, 'O') > 1) {
      return false;
    }
    if (count(board, 'X') > 5 || count(board, 'O') > 4) {
      return false;
    }

    if (count(board, 'X') < count(board, 'O')) {
      return false;
    }

    if (isTicTacToe(board, 'X') && !isTicTacToe(board, 'O')) {
      if (count(board, 'X') > count(board, 'O')) {
        return true;
      } else {
        return false;
      }
    }
    if (isTicTacToe(board, 'O') && !isTicTacToe(board, 'X')) {
      if (count(board, 'O') >= count(board, 'X')) {
        return true;
      } else {
        return false;
      }
    }
    if (isTicTacToe(board, 'O') && isTicTacToe(board, 'X')) return false;
    if (count(board, '.') == 9) return false;

    if (count(board, 'O') == 4 && count(board, 'X') == 5)
      return true;

    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[][] board = new char[3][3];
    String line = br.readLine();

    while (!line.equals("end")) {
      for (int i = 0; i < 3; i++) {
        for (int j = i * 3; j < i * 3 + 3; j++) {
          board[i][j % 3] = line.charAt(j);
        }
      }

//      for (char[] chars : board) {
//        for (char aChar : chars) {
//          System.out.print(aChar + " ");
//        }
//        System.out.println();
//      }

      System.out.println(solution(board) ? "valid" : "invalid");
      board = new char[3][3];

      line = br.readLine();
    }

  }

}
