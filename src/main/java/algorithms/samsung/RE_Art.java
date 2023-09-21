package algorithms.samsung;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_Art {


  static int n;
  static int[][] board;
  static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  static boolean[][] visited;
  static int[][] area;
  static int[][] rectangle;

  public static boolean isInRange(int y, int x) {
    return y < n && y >= 0 && x < n && x >= 0;
  }

  public static int computeScore(int typeA, int typeB) {
    int containedNumA = 0;
    int containedNumB = 0;

    int aY = 0;
    int aX = 0;
    int bY = 0;
    int bX = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (area[i][j] == typeA) {
          aY = i;
          aX = j;
          containedNumA++;
        }
        if (area[i][j] == typeB) {
          bY = i;
          bX = j;
          containedNumB++;
        }
      }
    }

//    boolean[][][] counted = new boolean[n][n][4];

    int adjacent = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (area[i][j] == typeA) {
          for (int d = 0; d < dir.length; d++) {
            int ny = i + dir[d][0];
            int nx = j + dir[d][1];

            if (!isInRange(ny, nx)) {
              continue;
            }

//            if (counted[ny][nx][d]) {
//              continue;
//            }

            if (area[ny][nx] == typeB) {
//              counted[ny][nx][d] = true;
              adjacent++;
            }
          }
        }
      }
    }

    int harmony = (containedNumA + containedNumB) * board[aY][aX] * board[bY][bX] * adjacent;
//    System.out.println(harmony);
    return harmony;
  }


  public static void DFS(int y, int x, int type) {
//    area = new int[n][n];
    area[y][x] = type;
    for (int d = 0; d < dir.length; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];

      if (!isInRange(ny, nx)) {
        continue;
      }

      if (visited[ny][nx]) {
        continue;
      }

      if (board[y][x] == board[ny][nx]) {
        area[ny][nx] = type;
        visited[ny][nx] = true;
        DFS(ny, nx, type);
      }
    }
  }

  public static void display(int[][] toShow) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(toShow[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void solution() {
    int score = 0;

    for (int tryout = 0; tryout <= 3; tryout++) {
      int type = 1;
      visited = new boolean[n][n];
//    spin();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (visited[i][j]) {
            continue;
          }
          DFS(i, j, type);
          type++;
        }
      }

//    display(area);
      for (int i = 1; i < type - 1; i++) {
        for (int j = i + 1; j < type; j++) {
          score += computeScore(i, j);
        }
      }

      spin();
    }
//    display(changed);

    System.out.println(score);

  }

  public static boolean inRectangle(int y, int x, int startY, int endY, int startX, int endX) {
    return y < endY && y >= startY && x < endX && x >= startX;
  }

  public static void copy(int[][] target, int[][] copied) {
    for (int t = 0; t < target.length; t++) {
      for (int c = 0; c < copied.length; c++) {
        copied[t][c] = target[t][c];
      }
    }
  }

  public static void spinRectangle(int pivot, int startY, int endY, int startX, int endX) {
    // 격자 크기가 홀수이면 가운데를 바꿔준다.
    int currentY = startY;
    int currentX = startX;

//    rectangle[startY + 1][endX - 1] = board[startY][endX - 1];
//    rectangle[endY - 2][startX] = board[endY - 1][startX];
//    for (int count = 1; count < pivot; count++) {
    for (int d = 3; d >= 0; d--) {
      for (int range = 1; range < pivot; range++) {
        int ny = currentY;
        int nx = currentX;
        if (!inRectangle(ny, nx, startY, endY, startX, endX)) {
//          System.out.println("opps! not in a range for ny and nx");
//          currentY += around[d+1][0];
//          currentX += around[d+1][1];
          continue;
        }
//        System.out.println("ny: " + currentY + ", nx: " + currentX);

        int yTo = ny + dir[d][0] * (pivot - 1);
        int xTo = nx + dir[d][1] * (pivot - 1);

        if (!inRectangle(yTo, xTo, startY, endY, startX, endX)) {
          if (yTo - endY >= 0)
            yTo = ny + dir[d-1][0] * (yTo - endY);
          if (yTo - startY < 0)
            yTo = ny + dir[d-1][0] * Math.abs(yTo - endY);
          if (xTo - endX >= 0)
            xTo = nx + dir[d-1][1] * (xTo - endX);
          if (xTo - startX < 0)
            xTo = nx + dir[d-1][0] * Math.abs(xTo - startY);
//          System.out.println("opps! not in a range for yTo and xTo");
//          continue;
        }

        rectangle[yTo][xTo] = board[ny][nx];
        currentY = yTo;
        currentX = xTo;
//        System.out.println("currentY: " + currentY + ", currentX: " + currentX);
//        System.out.println("---------------------------------");
      }
//      System.out.println("------------turnaround------------");
    }
//      copy(to, tmp);
//    }
    display(rectangle);
  }

  public static void spin() {
    // 정중앙의 열 좌표
    int pivot = n / 2;
    rectangle = new int[n][n];

//    board[pivot][pivot] // 완전 정중앙
    rectangle[pivot][pivot] = board[pivot][pivot];
    for (int d = 0; d < dir.length; d++) {
      for (int range = 1; range <= pivot; range++) {
        int ny = pivot + dir[d][0] * range; // 상 하 좌 우 행
        int nx = pivot + dir[d][1] * range; // 상 하 좌 우 열
        int goalY = pivot + dir[(d + 1) % 4][0] * range;
        int goalX = pivot + dir[(d + 1) % 4][1] * range;

        rectangle[goalY][goalX] = board[ny][nx];
      }
    }

    display(rectangle);


    for (int i = 0; ; i++) {

      // 만약 홀수이면 가운데를 바꿔준다.
      if (pivot - i <= i) {
        if ((n / 2) % 2 == 1) {
          rectangle[i - 1][i - 1] = board[i - 1][i - 1];
          rectangle[i - 1][pivot + 1 + (i - 1)] = board[i - 1][pivot + 1 + (i - 1)];
          rectangle[pivot + 1 + (i - 1)][i - 1] = board[pivot + 1 + (i - 1)][i - 1];
          rectangle[pivot + 1 + (i - 1)][pivot + 1 + (i - 1)] = board[pivot + 1 + (i - 1)][pivot + 1
              + (i - 1)];
        }
        break;
      }
      // 왼쪽 위
      spinRectangle(pivot - i - i, i, pivot - i, i, pivot - i);
//      spinRectangle(pivot, i, pivot - i, i, pivot - i, rectangle, result);
      // 오른쪽 위
      spinRectangle(pivot - i - i, i, pivot - i, pivot + 1 + i, n - i);
//      spinRectangle(pivot, i, pivot - i, pivot + 1 + i, n - i, rectangle, result);
      // 왼쪽 아래
      spinRectangle(pivot - i - i, pivot + 1 + i, n - i, i, pivot - i);
//      spinRectangle(pivot, pivot + 1 + i, n - i, i, pivot - i, rectangle, result);
      // 오른쪽 아래
      spinRectangle(pivot - i - i, pivot + 1 + i, n - i, pivot + 1 + i, n - i);
//      spinRectangle(pivot, pivot + 1 + i, n - i, pivot + 1 + i, n - i, rectangle, result);
//
//      spinRectangle(pivot, 1, pivot - 1, 1, pivot - 1);
//      spinRectangle(pivot, 1, pivot - 1, pivot + 2, n - 1);
//      spinRectangle(pivot, pivot + 2, n - 1, 1, pivot - 1);
//      spinRectangle(pivot, pivot + 2, n - 1, pivot + 2, n - 1);
    }

//    display(rectangle);

    copy(rectangle, board);
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.valueOf(br.readLine());
    board = new int[n][n];

    StringTokenizer st = null;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    visited = new boolean[n][n];

    area = new int[n][n];

    solution();
  }


}




