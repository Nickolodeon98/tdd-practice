package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTycoon {

  // 리브로수 정보
  static int[][] board;
  // 각 해의 이동 정보
  static int[][] moves;
  // 영양제의 위치
  static int[][] medicine;
  // 격자의 가로, 세로 길이
  static int n;
  // 영양제 뿌린 년수
  static int m;

  static int[][] dir = {{0, 0}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0},
      {1, 1}};
  static int[][] cross = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  static int year = 0;

  public static boolean isInRange(int y, int x) {
    return y < n && y >= 0 && x < n && x >= 0;
  }

  public static void countHeights() {
    int heights = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        heights += board[i][j];
      }
    }

    System.out.println(heights);
  }

  public static void reset() {
    int[][] tmp = new int[medicine.length][medicine[0].length];
    copy(medicine, tmp);
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (medicine[r][c] == 1) {
          tmp[r][c] = 0;
          continue;
        }

        if (board[r][c] >= 2) {
          board[r][c] -= 2;
          tmp[r][c] = 1;
        }
      }

    }
    copy(tmp, medicine);
  }

  public static void grow() {
    for (int b = 0; b < board.length; b++) {
      for (int t = 0; t < board[b].length; t++) {
        if (medicine[b][t] == 1) {
          // 리브로수 높이 증가
          board[b][t]++;
        }
      }
    }

    for (int b = 0; b < board.length; b++) {
      for (int t = 0; t < board[b].length; t++) {
        for (int c = 0; c < cross.length; c++) {
          if (medicine[b][t] == 1) {
            int nb = b + cross[c][0];
            int nt = t + cross[c][1];

            if (!isInRange(nb, nt)) {
              continue;
            }
            if (board[nb][nt] >= 1) {
              board[b][t]++;
            }
          }
        }

      }
    }
  }

  public static void copy(int[][] target, int[][] copied) {
    for (int i = 0; i < target.length; i++) {
      for (int j = 0; j < target[i].length; j++) {
        copied[i][j] = target[i][j];
      }
    }
  }

  public static void move() {
    int[][] tmp = new int[medicine.length][medicine[0].length];
    // 영양제의 위치를 변경
    for (int y = 0; y < medicine.length; y++) {
      for (int x = 0; x < medicine[y].length; x++) {
        if (medicine[y][x] == 1) {
          medicine[y][x] = 0;

          // 이동 방향 및 칸 수 설정
          int ny = y + (dir[moves[year][0]][0] * moves[year][1]);
          int nx = x + (dir[moves[year][0]][1] * moves[year][1]);
//          System.out.println("Rule -> moveRow: " + moves[year][0] + ", moveCol: " + moves[year][1]);
//          System.out.println("This goes from -> y: " + y + ", x: " + x);
//          System.out.println("To -> ny: " + ny + ", nx: " + nx);
          while (ny < 0) {
            ny += n;
          }
          while (nx < 0) {
            nx += n;
          }

          ny %= n;
          nx %= n;
//          System.out.println("changed to -> ny: " + ny + ", nx: " + nx);
          tmp[ny][nx] = 1;
        }


      }

    }
    copy(tmp, medicine);
  }

  public static void display() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void displayM() {
    for (int i = 0; i < medicine.length; i++) {
      for (int j = 0; j < medicine[i].length; j++) {
        System.out.print(medicine[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pro() {
    while (year < m) {
      // year : 지난 햇수 예) 1년이 지났으면 year = 1
      year++;
//      System.out.println("year: " + year);
//      display();
//      displayM();
      move();
//      display();
//      displayM();
      grow();
//      display();
//      displayM();
      reset();
//      display();
//      displayM();
//      System.out.print("heights: ");
//      countHeights();
    }

    countHeights();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.valueOf(st.nextToken());
    m = Integer.valueOf(st.nextToken());

    board = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }
    moves = new int[m + 1][2];
    for (int k = 1; k <= m; k++) {
      st = new StringTokenizer(br.readLine(), " ");
      moves[k][0] = Integer.valueOf(st.nextToken());
      moves[k][1] = Integer.valueOf(st.nextToken());
//      System.out.println(moves[k][0] + " and " + moves[k][1]);
    }

    medicine = new int[n][n];

    // 최초에는 좌측 하단 4개에 영양제 존재
    medicine[n - 1][0] = 1;
    medicine[n - 1][1] = 1;
    medicine[n - 2][0] = 1;
    medicine[n - 2][1] = 1;

    pro();
  }

}
