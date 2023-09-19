package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeKillAll {

  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int[][][] board;
  static int k;
  static int years;
  static int limit;
  static int[][] cross = {{-1,-1},{-1,1},{1,-1},{1,1}};
  public static boolean isInRange(int y, int x) {
    return y < board.length && y >= 0 && x < board[y].length && x >= 0;
  }


  public static void grow() {

    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        int cnt = 0;
        if (board[y][x][0] == 0 || board[y][x][0] == -1 || board[y][x][0] == -2) continue;
        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];

          if (!isInRange(ny, nx)) {
            continue;
          }

          if (board[ny][nx][0] == 0 || board[ny][nx][0] == -1 || board[ny][nx][0] == -2) {
            continue;
          }

          cnt++;

        }
        board[y][x][0] += cnt;
      }
    }

  }

  public static void spread() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        int cnt = 0;
        if (board[y][x][0] == 0 || board[y][x][0] == -1 || board[y][x][0] == -2) continue;
        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];

          if (!isInRange(ny, nx)) {
            continue;
          }
          if (board[ny][nx][0] == 0) {
//            System.out.println("hi");
            board[ny][nx][1] += 1;
//            display2();
            cnt++;
          }
        }
        if (cnt >= 1)
          board[y][x][1] = cnt * 1000;
      }
    }

//    display2();
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x][0] == 0 || board[y][x][0] == -1 || board[y][x][0] == -2) continue;
        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];
//          System.out.println("ny: " + ny + ", nx: " + nx);
          if (!isInRange(ny, nx)) {
            continue;
          }
          if (board[ny][nx][1] > 0 && board[ny][nx][1] < 1000 && board[y][x][1] >= 1000 && board[y][x][0] > 0) {
//            System.out.println(board[y][x][1]/1000);
            board[ny][nx][0] += board[y][x][0] / (board[y][x][1]/1000);
            board[ny][nx][1]--;
          }
        }
      }
    }
  }

  public static int spray() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x][0] == 0 || board[y][x][0] == -1 || board[y][x][0] == -2) continue;

        board[y][x][1] = board[y][x][0];

        for (int c = 0; c < cross.length; c++) {
          for (int r = 1; r <= k; r++) {
            int ny = y + cross[c][0]*r;
            int nx = x + cross[c][1]*r;

            if (!isInRange(ny, nx)) {
              continue;
            }
            if (board[ny][nx][0] == 0 || board[ny][nx][0] == -1 || board[ny][nx][0] == -2) {
//              board[ny][nx][1] = -1;
              break;
            }
            board[y][x][1] += board[ny][nx][0];
          }
        }
      }
    }

    int max = -1;
    int row = 0;
    int col = 0;
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x][0] == 0 || board[y][x][0] == -1 || board[y][x][0] == -2)
          continue;
        if (max < board[y][x][1]) {
          max = board[y][x][1];
          row = y;
          col = x;
        }
      }
    }
//    System.out.println(row + " " + col);
    board[row][col][0] = -2;
    for (int c = 0; c < cross.length; c++) {
      for (int range = 1; range <= k; range++) {
        int nr = row + cross[c][0]*range;
        int nc = col + cross[c][1]*range;

        if (!isInRange(nr, nc)) continue;

        if (board[nr][nc][0] == -1) continue;

        if (board[nr][nc][0] == 0) {
          board[nr][nc][0] = -2;
          break;
        }
        board[nr][nc][0] = -2;

      }
    }

    return max;

  }

  public static void countDeads() {
    int year = 0;
    int total = 0;
    while (year < limit) {
      display();
      grow();
      display();
      display2();
      clear();
      spread();
      display();
      display2();
      clear();
      if (year == years) reset();
      total += spray();
      display();
      display2();
      clear();
      year++;
      System.out.println("year: " + year);
    }

    System.out.println(total);
  }

  public static void display() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        System.out.print(board[y][x][0] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void display2() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        System.out.print(board[y][x][1] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void clear() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x][1] > 0) board[y][x][1] = 0;
      }
    }
  }
  public static void reset() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x][0] == -2) board[y][x][0] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    // 여기에 코드를 작성해주세요.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.valueOf(st.nextToken());
    limit = Integer.valueOf(st.nextToken());
    k = Integer.valueOf(st.nextToken());
    years = Integer.valueOf(st.nextToken());

    board = new int[n][n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        board[i][j][0] = Integer.valueOf(st.nextToken());
      }

    }

    countDeads();
  }

}
