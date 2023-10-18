package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_B3190 {
    static int[][] board;
    static int[][] apples;
    static int[] dirs;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int bodyLen = 1;
    static Snake snake;
    static class Snake {
        int y;
        int x;
        Snake nextSnake;
        Snake prevSnake;

        Snake(int y, int x) {
            this.y = y;
            this.x = x;
            this.nextSnake = null;
            this.prevSnake = null;
        }

        void setNext(Snake nextSnake) {
            this.nextSnake = nextSnake;
        }

        void setPrev(Snake prevSnake) {
            this.prevSnake = prevSnake;
        }

        void removeLast() {
            Snake tmp = this;
            while (tmp.prevSnake != null) {
                tmp = tmp.prevSnake;
            }
            board[tmp.y][tmp.x] = 0;
            tmp.nextSnake.setPrev(null);
        }
    }

    public static void pro() {
        int seconds = 0;
        int curDir = 1;

        while (true) {
            curDir = (curDir + dirs[seconds] + 4) % 4;
            if (move(curDir) != 1) break;
            seconds++;
        }

        System.out.println(seconds + 1);
    }

    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 0 && x < board[y].length && x >= 0;
    }

    public static int move(int curDir) {
        int nY = snake.y + dir[curDir][0];
        int nX = snake.x + dir[curDir][1];

        if (!isInRange(nY, nX)) return -1;
        if (board[nY][nX] == 2) return -1;

        snake.setNext(new Snake(nY,nX));
        snake.nextSnake.setPrev(snake);

        if (board[nY][nX] == 4) {
            board[nY][nX] = 2;
            bodyLen++;
        } else {
            board[nY][nX] = 2;
            snake.removeLast();
        }

        snake = snake.nextSnake;
        snake.y = nY;
        snake.x= nX;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        board = new int[N][N];
        board[0][0] = 2;
        snake = new Snake(0, 0);
        int K = Integer.valueOf(br.readLine());
        StringTokenizer st = null;
        apples = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            board[r-1][c-1] = 4;
        }

        int L = Integer.valueOf(br.readLine());

        dirs = new int[10001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int seconds = Integer.valueOf(st.nextToken());
            String dir = st.nextToken();
            dirs[seconds] = dir.equals("L") ? -1 : 1;
        }

        pro();
    }
}
