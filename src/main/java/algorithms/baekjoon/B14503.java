package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
    static int[][] board;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int curDir;
    static int[] pos;
    static int cleaned = 0;
    static boolean finished = false;


    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 0 && x < board.length && x >= 0;
    }

    public static void pro() {
        while (!finished) {
            clean();
        }

        System.out.println(cleaned);
    }

    public static void clean() {
        if (board[pos[0]][pos[1]] == 0) {
            board[pos[0]][pos[1]] = -1;
            cleaned++;
        }

        boolean dirty = false;
        for (int d = 0; d < dir.length; d++) {
            int ny = pos[0] + dir[d][0];
            int nx = pos[1] + dir[d][1];

            if (board[ny][nx] == 0) {
                dirty = true;
            }

        }
        boolean moved = false;
        if (dirty) {
            while (!moved) {
                curDir = (curDir - 1 + 4) % 4;

                int ny = pos[0] + dir[curDir][0];
                int nx = pos[1] + dir[curDir][1];

                if (board[ny][nx] == 0) {
                    pos[0] = ny;
                    pos[1] = nx;
                    moved = true;
                }
            }
            return;
        }

        int ny = pos[0] - dir[curDir][0];
        int nx = pos[1] - dir[curDir][1];

        if (board[ny][nx] == 1) {
            finished = true;
            return;
        }

        pos[0] = ny;
        pos[1] = nx;


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        board = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());

        curDir = Integer.valueOf(st.nextToken());

        pos = new int[]{r, c};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        pro();
    }

}
