package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2636 {
    static int row;
    static int col;
    static int[][] area;
    static int[][] surround;
    static boolean[][] visited;

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void pro() {
        int[][] start = area;
        int hours = 0;
        int count = 0;
        while (!isAllMelted(start)) {
            init();
            analyse(0, 0, start);
            hours++;
            count = melt(start);
        }

        System.out.println(hours + "\n" + count);
    }

    public static void display(int[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int melt(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (surround[i][j] == -1) continue;
                for (int d = 0; d < dir.length; d++) {
                    int ny = i + dir[d][0];
                    int nx = j + dir[d][1];

                    if (board[i][j] == 1 && surround[ny][nx] == -1) {
                        board[i][j] = 0;
                        cnt++;
                        break;
                    }
                }
            }

        }

        return cnt;
    }

    public static boolean isAllMelted(int[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 0) return false;
            }
        }
        return true;
    }


    // 초기화
    public static void init() {
        surround = new int[row][col];
        visited = new boolean[row][col];
        surround[0][0] = -1;
    }


    public static void analyse(int y, int x, int[][] board) {
        for (int d = 0; d < dir.length; d++) {
            int ny = y + dir[d][0];
            int nx = x + dir[d][1];

            if (!isInRange(ny, nx)) continue;
            if (surround[ny][nx] == -1) continue;

            if (board[ny][nx] == 0) {
                surround[ny][nx] = -1;
                analyse(ny, nx, board);
            }

        }
    }

    public static boolean isInRange(int y, int x) {
        return y < row && y >= 0 && x < col && x >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        area = new int[row][col];
        surround = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                area[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        pro();
    }
}
