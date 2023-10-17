package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Rudolph {

    static int[][] board;
    static int santaPushedRange;
    static int rudolphPunchRange;
    static int time;
    static int seconds = 0;
    static int[] rudolphPos;
    static int[][] santaPos;
    static int[] outed;
    static int[] faint;
    static int[] scores;
    static int[][] rDir = {{-1, 0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static int[][] sDir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static boolean isAllOut() {
        for (int i = 1; i < santaPos.length; i++) {
            if (outed[i] == 0) return false;
        }
        return true;
    }

    public static void countScores() {
        for (int i = 1; i < santaPos.length; i++) {
            if (outed[i] == 0) scores[i]++;
        }
    }

    public static void rudolphPunch(int id, int dirY, int dirX) {
        int nextY = santaPos[id][0] + (rudolphPunchRange * dirY);
        int nextX = santaPos[id][1] + (rudolphPunchRange * dirX);

        scores[id] += rudolphPunchRange;
        if (!isInRange(nextY, nextX)) {
            outed[id] = 1;
            return;
        }
        faint[id] = seconds + 1;

        interact(nextY, nextX, dirY, dirX);
        santaPos[id][0] = nextY;
        santaPos[id][1] = nextX;
        board[nextY][nextX] = id;
    }

    public static void interact(int y, int x, int dirY, int dirX) {
        int victim = board[y][x];
        while (victim != 0) {
            y += dirY;
            x += dirX;
            if (!isInRange(y, x)) {
                outed[victim] = 1;
                break;
            }
            int tmp = board[y][x];
            board[y][x] = victim;
            santaPos[victim][0] = y;
            santaPos[victim][1] = x;
            victim = tmp;
        }
    }

    public static void santaPushedBack(int id, int dirY, int dirX) {
        int nextY = rudolphPos[0] + (-1 * dirY * santaPushedRange);
        int nextX = rudolphPos[1] + (-1 * dirX * santaPushedRange);

        scores[id] += santaPushedRange;
        if (!isInRange(nextY, nextX)) {
            outed[id] = 1;
            return;
        }
        faint[id] = seconds+1;

        interact(nextY, nextX, -1 * dirY, -1 * dirX);

        board[nextY][nextX] = id;
        santaPos[id][0] = nextY;
        santaPos[id][1] = nextX;
    }

    public static double computeDist(int rY, int rX, int cY, int cX) {
        return Math.pow(rY-cY, 2) + Math.pow(rX - cX, 2);
    }

    public static void moveRudolph() {
        double dist = Double.MAX_VALUE;
        int targetY = 0, targetX = 0;
        for (int i = board.length-1; i >= 0; i--) {
            for (int j = board[i].length-1; j >= 0; j--) {
                if (board[i][j] == 0 || board[i][j] == -1) continue;
                int santaId = board[i][j];
                if (outed[santaId] == 1) continue;
                double curDist = computeDist(rudolphPos[0], rudolphPos[1], i, j);
                if (dist > curDist) {
                    dist = curDist;
                    targetY = i;
                    targetX = j;
                }
            }
        }

        if (dist == Double.MAX_VALUE) return;

        Double minDist = Double.MAX_VALUE;
        int dirY = 0, dirX = 0;
        int nextY = 0, nextX = 0;

        for (int d = 0; d < rDir.length; d++) {
            int nY = rudolphPos[0] + rDir[d][0];
            int nX = rudolphPos[1] + rDir[d][1];

            if (!isInRange(nY, nX)) continue;

            double curDist = computeDist(nY, nX, targetY, targetX);

            if (minDist > curDist) {
                minDist = curDist;
                nextY = nY;
                nextX = nX;
                dirY = rDir[d][0];
                dirX = rDir[d][1];
            }
        }

        if (minDist == Double.MAX_VALUE) return;

        if (board[nextY][nextX] != 0) {
            int santaId = board[nextY][nextX];
            rudolphPunch(santaId, dirY, dirX);
        }

        board[rudolphPos[0]][rudolphPos[1]] = 0;
        rudolphPos[0] = nextY;
        rudolphPos[1] = nextX;
        board[nextY][nextX] = -1;
    }

    public static void moveSanta(int num) {
        int y = santaPos[num][0];
        int x = santaPos[num][1];
        double minDist = computeDist(rudolphPos[0], rudolphPos[1], y, x);
        int targetY = -1, targetX = -1;
        int dirY = 0, dirX = 0;
        for (int d = 0; d < sDir.length; d++) {
            int nY = y + sDir[d][0];
            int nX = x + sDir[d][1];

            if (!isInRange(nY, nX)) continue;
            if (board[nY][nX] != 0 && board[nY][nX] != -1) continue;
            double curDist = computeDist(rudolphPos[0], rudolphPos[1], nY, nX);
            if (minDist > curDist) {
                minDist = curDist;
                targetY = nY;
                targetX = nX;
                dirY = sDir[d][0];
                dirX = sDir[d][1];
            }

        }

        if (targetY == -1 && targetX == -1) return;
        board[santaPos[num][0]][santaPos[num][1]] = 0;
        if (board[targetY][targetX] == -1) {
            santaPushedBack(num, dirY, dirX);
            return;
        }


        santaPos[num][0] = targetY;
        santaPos[num][1] = targetX;
        board[targetY][targetX] = num;
    }

    public static void pro() {
//        display(board);
        while (seconds < time) {
            moveRudolph();
//            display(board);
            if (isAllOut()) {
//                System.out.println(Arrays.toString(scores));
                break;
            }
            for (int i = 1; i < santaPos.length; i++) {
                if (faint[i] != 0 || outed[i] == 1) continue;
                moveSanta(i);
//                display(board);
                if (isAllOut()) {
//                    System.out.println(Arrays.toString(scores));
                    break;
                }
            }
            countScores();
            seconds++;
            wakeUp();
        }

        for (int i = 1; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
    }
    public static void wakeUp() {
        for (int i = 1; i < faint.length; i++) {
            if (faint[i] < seconds) faint[i] = 0;
        }
    }
    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 1 && x < board[y].length && x >= 1;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        board = new int[N+1][N+1];
        time = Integer.valueOf(st.nextToken());
        int P = Integer.valueOf(st.nextToken());
        santaPos = new int[P+1][2];
        outed = new int[P+1];
        faint = new int[P+1];
        scores = new int[P+1];
        rudolphPunchRange = Integer.valueOf(st.nextToken());
        santaPushedRange = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        rudolphPos = new int[]{r, c};
        board[r][c] = -1;

        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.valueOf(st.nextToken());
            int sR = Integer.valueOf(st.nextToken());
            int sC = Integer.valueOf(st.nextToken());
            santaPos[num][0] = sR;
            santaPos[num][1] = sC;
            board[sR][sC] = num;
        }

        pro();

    }
}
