package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {

    static int n;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] board;
    static int size = 2;
    static int[] sharkPos;
    static int[][] dist;
    static int eaten = 0;
    public static int[] findFish() {
        int cnt = 0;
        int y = 0;
        int x = 0;
        getDistance(sharkPos[0], sharkPos[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && board[i][j] != 9 && board[i][j] < size && dist[i][j] != Integer.MAX_VALUE) {
                    if (cnt > 0) {
                        if (dist[i][j] < dist[y][x]) {
                            y = i;
                            x = j;
                        }
                    } else {
                        y = i;
                        x = j;
                    }
                    cnt++;
                }
            }
        }
        if (cnt == 0) return null;
        return new int[]{y, x};
    }

    public static boolean vacant() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 9 && board[i][j] != 0) return false;
            }
        }

        return true;
    }

    public static void pro() {
        int seconds = 0;
        while (!vacant()) {
            // 물고기 위치 파악
            int[] curPos = findFish();
            if (curPos == null) break;
            // 물고기 있는 칸으로 이동
            move(curPos[0], curPos[1]);
            seconds += dist[curPos[0]][curPos[1]];
            // 지난 시간
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        System.out.println(seconds);
    }

    public static void getDistance(int y, int x) {
        Queue<Integer> candi = new LinkedList<>();

        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        candi.offer(y);
        candi.offer(x);
        dist[y][x] = 0;
        while (!candi.isEmpty()) {
            int r = candi.poll();
            int c = candi.poll();

            for (int d = 0; d < dir.length; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if (!isInRange(nr, nc)) continue;
                if (board[nr][nc] > size) continue;
                if (dist[nr][nc] != Integer.MAX_VALUE) continue;
                dist[nr][nc] = Math.min(dist[nr][nc], dist[r][c] + 1);
                candi.offer(nr);
                candi.offer(nc);
            }
        }
//        System.out.println("board");
//        display(board);
//        System.out.println("dist");
//        display(dist);
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
        return y < n && y >= 0 && x < n && x >= 0;
    }

    public static void move(int y, int x) {
        board[sharkPos[0]][sharkPos[1]] = 0;
        sharkPos[0] = y;
        sharkPos[1] = x;
        board[y][x] = 0;
        eaten++;
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
                if (board[i][j] == 9) sharkPos = new int[]{i,j};
            }
        }
//        getDistance(sharkPos[0], sharkPos[1]);

        pro();

    }
}