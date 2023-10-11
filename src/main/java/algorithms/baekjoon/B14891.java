package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891 {

    static int[][] wheels;
    static int[][] current;
    static boolean[] visited;
    static int score = 0;
    public static void spin(int type, int dir) {
        int[][] temp = new int[4][8];
        copy(wheels, temp);

        if (dir == 1) {
            for (int i = 0; i < 8; i++) {
                temp[type][(i+1)%8] = wheels[type][i];
            }
        }

        // 0 -> 7, 7 -> 6 반시계방향
        if (dir == -1) {
            for (int i = 7; i > 1; i--) {
                temp[type][(i-1)%8] = wheels[type][i];
            }
            temp[type][7] = wheels[type][0];
            temp[type][0] = wheels[type][1];
        }

//        display(temp);
        copy(temp, wheels);
    }

    public static void copy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

    public static void init() {
        current = new int[4][8];
        visited = new boolean[4];
        copy(wheels, current);
    }

    public static void change(int type, int dir) {
        if (visited[type]) return;

        visited[type] = true;
        spin(type, dir);


        if (type == 0) {
            if (current[0][2] != current[1][6]) {
                change(1, dir * -1);
            }
        }

        if (type == 1 || type == 2) {

            if (current[type-1][2] != current[type][6]) {
                change(type-1, dir * -1);
            }
            if (current[type][2] != current[type+1][6]) {
                change(type+1, dir * -1);
            }
        }

        if (type == 3) {
            if (current[2][2] != current[3][6]) change(2, dir * -1);
        }
    }

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void count() {
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) score += Math.pow(2, i);
        }

        System.out.println(score);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        wheels = new int[4][8];

        for (int i = 0; i < 4; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = info[j] - '0';
            }
        }

        init();

        int times = Integer.valueOf(br.readLine());
        for (int k = 0; k < times; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.valueOf(st.nextToken())-1;
            int dir = Integer.valueOf(st.nextToken());
            change(type, dir);
//            System.out.println("here is a current");
//            display(current);
            init();
        }

        count();
    }
}
