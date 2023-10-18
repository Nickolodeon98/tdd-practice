package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3190 {

    static int[][] board;
    static int[][] apples;
    static int[] dirs;

    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    static int bodyLen = 1;
    static int[] snakePos;
    public static void pro() {
        int seconds = 0;
        int curDir = 1;
//        System.out.println(Arrays.toString(dirs));

        while(true) {
//            display(board);
            curDir = (curDir + dirs[seconds] + 4) % 4;
            if (move(curDir) != 1) break;
            seconds++;
        }


        System.out.println(seconds+1);
    }

    public static void display(int[][] toShow) {
        for (int i = 0; i < toShow.length; i++) {
            for (int j = 0; j < toShow[i].length; j++) {
                System.out.print(toShow[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 1 && x < board[0].length && x >= 1;
    }

    public static int move(int curDir) {
        int nY = snakePos[0] + dir[curDir][0];
        int nX = snakePos[1] + dir[curDir][1];
        if (!isInRange(nY, nX)) return -1;
        if (board[nY][nX] == 2) return -1;

        if (board[nY][nX] == 4) {
            board[nY][nX] = 2;
            bodyLen++;
        } else {
            board[nY][nX] = 2;
            board[snakePos[0]][snakePos[1]] = 0;
        }

        snakePos[0] = nY;
        snakePos[1] = nX;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        board = new int[N+1][N+1];
        board[1][1] = 2;
        snakePos = new int[]{1,1};

        int K = Integer.valueOf(br.readLine());
        StringTokenizer st = null;
        apples = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            apples[i][0] = r;
            apples[i][1] = c;
            board[r][c] = 4;
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
