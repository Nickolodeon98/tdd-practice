package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RE_RE_RE_B15683 {
    static int[][] board;
    static int[][] tmp;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<Integer>[] cctv;
    static List<String> allCases;
    static int min = Integer.MAX_VALUE;

    public static void allCameras() {
        cctv[0].add(2);

        cctv[1].add(1);
        cctv[1].add(3);

        cctv[2].add(0);
        cctv[2].add(1);

        cctv[3].add(0);
        cctv[3].add(1);
        cctv[3].add(3);

        cctv[4].add(3);
        cctv[4].add(2);
        cctv[4].add(1);
        cctv[4].add(0);
    }

    public static void permutation(String s, int limit) {

        if (s.length() == limit) {
            allCases.add(s);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            permutation(s + i, limit);
        }

    }

    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 0 && x < board[y].length && x >= 0;
    }

    public static void spin(int y, int x, int id, int pos) {
        for (int d : cctv[id - 1]) {
            int nextD = (d + pos + 4) % 4;
            int ny = y;
            int nx = x;

            while (true) {
                ny += dir[nextD][0];
                nx += dir[nextD][1];
                if (!isInRange(ny, nx)) break;
                if (board[ny][nx] == 6) break;
                if (board[ny][nx] != 0) continue;
                tmp[ny][nx] = -1;
            }
        }
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

    public static void pro() {
        allCameras();
        permutation("", countCameras());
        for (int i = 0; i < allCases.size(); i++) {
            char[] cases = allCases.get(i).toCharArray();
            int l = 0;
//            System.out.println(Arrays.toString(cases));
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    if (board[j][k] != 0 && board[j][k] != 6 && board[j][k] != -1)
                        spin(j, k, board[j][k], cases[l++]-'0');
                }
            }
//            display(tmp);
            min = Math.min(min, countHidden());
            copy(board, tmp);
        }

        System.out.println(min);
    }

    public static void copy(int[][] from, int[][] to) {
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < from[i].length; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    public static int countHidden() {
        int count = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (tmp[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int countCameras() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 && board[i][j] != 6) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        board = new int[N][M];
        tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        copy(board, tmp);


        cctv = new ArrayList[5];
        for (int i = 0; i < cctv.length; i++) cctv[i] = new ArrayList<>();
        allCases = new ArrayList<>();

        pro();
    }
}
