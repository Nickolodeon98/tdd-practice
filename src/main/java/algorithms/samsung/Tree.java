package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree {

  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int[][] cross = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  static int k;
  static int years;
  static int limit;
  static int[][] board;
  static int[][] already;
  static int[][] countTrees;
  static int[][] map;

  public static boolean isInRange(int y, int x) {
    return y < board.length && y >= 0 && x < board[y].length && x >= 0;
  }

  public static void copy(int[][] target, int[][] copied) {
    for (int i = 0; i < target.length; i++) {
      for (int j = 0; j < target[i].length; j++) {
        target[i][j] = copied[i][j];
      }
    }
  }

  public static void grow() {

    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        int cnt = 0;
        if (board[y][x] == 0 || board[y][x] == -1 || board[y][x]== -2) {
          continue;
        }
        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];

          if (!isInRange(ny, nx)) {
            continue;
          }

          if (board[ny][nx] == 0 || board[ny][nx] == -1 || board[ny][nx] == -2) {
            continue;
          }

          cnt++;

        }
        board[y][x] += cnt;
      }
    }

  }

  public static void spread() {
    map = new int[board.length][board[0].length];
    copy(map, board);
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        int cnt = 0;
        if (board[y][x] == 0 || board[y][x] == -1 || board[y][x] == -2) {
          continue;
        }
        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];

          if (!isInRange(ny, nx)) {
            continue;
          }
          if (board[ny][nx] == 0) {
            cnt++;
          }
        }

        for (int d = 0; d < dir.length; d++) {
          int ny = y + dir[d][0];
          int nx = x + dir[d][1];

          if (!isInRange(ny, nx)) {
            continue;
          }
          if (board[ny][nx] == 0) {
            map[ny][nx] += board[y][x] / cnt;
          }
        }
      }
    }
    copy(board, map);
  }

  public static int spray() {
    countTrees = new int[board.length][board[0].length];

    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (board[y][x] == 0 || board[y][x] == -1 || board[y][x] == -2) {
          continue;
        }

        countTrees[y][x] = board[y][x];

        for (int c = 0; c < cross.length; c++) {
          for (int r = 1; r <= k; r++) {
            int ny = y + cross[c][0] * r;
            int nx = x + cross[c][1] * r;

            if (!isInRange(ny, nx)) {
              continue;
            }
            if (board[ny][nx] == 0 || board[ny][nx] == -1 || board[ny][nx] == -2) {
              break;
            }
            countTrees[y][x] += board[ny][nx];
          }
        }
      }
    }

    int max = -1;
    int row = 0;
    int col = 0;
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        if (countTrees[y][x] == 0 || board[y][x] == 0 || board[y][x] == -1 || board[y][x] == -2) {
          continue;
        }
        if (max < countTrees[y][x]) {
          max = countTrees[y][x];
          row = y;
          col = x;
        }
      }
    }

    if (board[row][col] != 0) {
      board[row][col] = -2;
      already[row][col] = years;
      for (int c = 0; c < cross.length; c++) {
        for (int range = 1; range <= k; range++) {
          int nr = row + cross[c][0] * range;
          int nc = col + cross[c][1] * range;

          if (!isInRange(nr, nc)) {
            continue;
          }

          if (board[nr][nc] == 0 || board[nr][nc] == -1 || board[nr][nc] == -2) {
            if (board[nr][nc] == 0 || board[nr][nc] <= -2) {
              board[nr][nc] = -2;
              already[nr][nc] = years;
            }
            break;
          }

          board[nr][nc] = -2;
          already[nr][nc] = years;

        }
      }
    }
    return max == -1 ? 0 : max;
  }

  public static void countDeads() {
    int year = 0;
    int total = 0;

    already = new int[board.length][board[0].length];
    map = new int[board.length][board[0].length];
    countTrees = new int[board.length][board[0].length];

    while (year < limit) {
      grow();
      spread();
      int sprayed = spray();
      total += sprayed;
      reInit();
      year++;
      rollback();
    }

    System.out.println(total);
  }

  public static void reInit() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] <= -2 && already[i][j] == 0) {
          board[i][j] = 0;
        }
      }
    }
  }

  public static void rollback() {
    for (int i = 0; i < already.length; i++) {
      for (int j = 0; j < already[i].length; j++) {
        if (already[i][j] > 0) {
          already[i][j]--;
        }
      }
    }
  }

  public static void display() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        System.out.print(board[y][x] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    // 여기에 코드를 작성해주세요.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.valueOf(st.nextToken());
    limit = Integer.valueOf(st.nextToken());
    k = Integer.valueOf(st.nextToken());
    years = Integer.valueOf(st.nextToken());

    board = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }

    }

    countDeads();
  }

}