package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15683 {
    static int init;

    static int[] one = {0, 1};
    static int[][] two = {{0, 1}, {0, -1}};
    static int[][] three = {{1, 0}, {0, 1}};
    static int[][] four = {{0, -1}, {-1, 0}, {0, 1}};
    static int[][] five = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] reversed = {{-1, 1}, {1, -1}};
    static int[][] board;

    public static void solution() {
    }

    public static int[] spin(int y, int x) {
        int tmp = y;
        x = y;
        y = x;

        return new int[]{y, x};
    }

    static int max = Integer.MIN_VALUE;

    public static void decideDir(int y, int x) {
        int cnt = 0;
        if (board[y][x] == 1) {
            for (int i = 0; i < 4; i++) {
                int ny = y + one[0];
                int nx = x + one[1];

                int[] nPos = spin(ny, nx);

                while (board[ny][nx] == 0) {
                    ny += one[0];
                    nx += one[1];
                    cnt++;
                }

                max = Math.max(max, cnt);

                ny = nPos[0];
                nx = nPos[1];
            }


        }

        // 각 회전 후 감시 결과가 가장 커버를 많이 하는 경우로 CCTV 놓기
        Math.max();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }
    }
}
