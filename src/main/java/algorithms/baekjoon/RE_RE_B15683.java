package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RE_RE_B15683 {
    static CCTV camera;
    static int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] board;
    static int[][] changed;
    static int n;
    static int m;
    static class CCTV {
        List<List<Integer>> dir;

        public CCTV(List<List<Integer>> dir) {
            this.dir = dir;
        }
    }

    public static void spin(int idx) {
        List<Integer> ranges = camera.dir.get(idx);
        for (int e : ranges) {
            ranges.set(ranges.indexOf(e), (e+1)%4);
        }
    }

    // CCTV 가 감시할 수 있는 영역을 모두 저장한다.
    public static void init() {
        List<List<Integer>> every = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(0);
        every.add(first);

        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(3);
        every.add(second);

        List<Integer> third = new ArrayList<>();
        third.add(0);
        third.add(3);
        every.add(third);

        List<Integer> fourth = new ArrayList<>();
        fourth.add(0);
        fourth.add(2);
        fourth.add(3);
        every.add(fourth);

        List<Integer> fifth = new ArrayList<>();
        fifth.add(0);
        fifth.add(1);
        fifth.add(2);
        fifth.add(3);
        every.add(fifth);

        camera = new CCTV(every);
    }


    public static void solution() {
        init();

        coverage();

//        // 1번 카메라를 90도 돌린다.
//        spin(0);
//        // 2번 카메라를 90도 돌린다.
//        spin(1);
    }

    public static boolean isInRange(int y, int x) {
        return y < n && y >= 0 && x < m && x >= 0;
    }

    public static void view(int y, int x, int type) {
        List<Integer> pos = camera.dir.get(type-1);

        for (int p : pos) {
            int ny = y + direct[p][0];
            int nx = x + direct[p][1];

            while (isInRange(ny, nx) && board[ny][nx] != 6) {
                if (board[ny][nx] == 0) {
                    changed[ny][nx] = -1;
                }
                ny += direct[p][0];
                nx += direct[p][1];
            }
        }

        display(changed);
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

    public static void coverage() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || board[i][j] == 6) continue;
                for (int k = 0; k < 4; k++) {
                    view(i, j, board[i][j]);
                    spin(board[i][j]-1);
                }
            }

        }
    }

    public static void permutation() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        board = new int[n][m];

        changed = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        solution();
    }
}
