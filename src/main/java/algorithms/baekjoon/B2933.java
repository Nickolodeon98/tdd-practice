package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2933 {
    static int R, C;
    static char[][] board;
    static int[][] info;
    static boolean[][] visited;
    static int total;
    static int[] heights;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int type = 0;

    public static void destroy(int height, int dir) {
        int pos = (board.length - 1) - (height - 1);
        if (dir == -1) {
            for (int i = 0; i < board[pos].length; i++) {
                if (board[pos][i] == 'x') {
                    board[pos][i] = '.';
                    break;
                }

            }
        } else {
            for (int i = board[pos].length - 1; i >= 0; i--) {
                if (board[pos][i] == 'x') {
                    board[pos][i] = '.';
                    break;
                }
            }
        }

    }

    public static void analyze() {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'x') {
                    if (visited[i][j]) continue;
                    if (type >= 1 && i == board.length - 1) {
                        info[i][j] = 1;
                        visited[i][j] = true;
                        DFS(i, j, 1);
                        continue;
                    }
                    type++;
                    info[i][j] = type;
                    visited[i][j] = true;
                    DFS(i, j, type);
                }
            }
        }
    }

    public static boolean isAllDestroyed() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'x') return false;
            }
        }
        return true;
    }

    public static int levitated() {
        // 모두 파괴되었으면 할 필요가 없다.
        if (isAllDestroyed()) return -1;

        // 여러 개가 있으면 무조건 type 은 1 넘는다.
        if (type > 1) {
            return 4;
        }
        // 한개만 있어도
        for (int i = 0; i < board[board.length - 1].length; i++) {
            if (board[board.length - 1][i] == 'x') return -1;
        }
        return 3;
    }

    public static void moveDownward(int count, int standard) {
        for (int i = board.length - 1; i >= count; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (info[i - count][j] > standard) {
                    board[i][j] = board[i - count][j];
                    board[i - count][j] = '.';
                }
            }
        }
    }

    public static void gravitate() {
        int status = levitated();
        if (status == -1) return;
        int max = -1;
        int posY = -1;
        int leviPosY = 1000000;

        int originPosY = R;
//         한칸이 아니라 여러칸 내려야한다.
        if (status == 3) {
            for (int j = 0; j < C; j++) {
                // 컬럼별 확인 필수
                for (int i = 0; i < R; i++) {
                    if (info[i][j] == 1) posY = i;
                }
                max = Math.max(max, posY);

                posY = -1;
            }
            int dist = R - max;
            if (dist != 0) {
                moveDownward(dist - 1, 0);
            }
            return;
        }


        int min = Integer.MAX_VALUE;
        if (status == 4) {
            for (int j = 0; j < C; j++) {
                // 컬럼별 확인 필수

                for (int i = 0; i < R; i++) {
                    if (info[i][j] > 1) leviPosY = i;
                    if (leviPosY != 1000000 && info[i][j] == 1) break;
                }
                for (int i = R - 1; i >= 0; i--) {
                    if (info[i][j] == 1 && i > leviPosY) originPosY = i;
                }
                int dist = Math.abs(leviPosY - originPosY);
                if (min > dist) {
                    min = dist;
                }
                originPosY = R;
                leviPosY = 1000000;

            }
            if (min != 0) {
                moveDownward(min - 1, 1);
            }
        }
    }


    public static void display(char[][] toShow) {
        for (int i = 0; i < toShow.length; i++) {
            for (int j = 0; j < toShow[i].length; j++) {
                System.out.print(toShow[i][j] + "");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isInRange(int y, int x) {
        return y < board.length && y >= 0 && x < board[y].length && x >= 0;
    }

    public static void DFS(int y, int x, int type) {
        // 가장 아래랑 연결되어있지 않으면 떠 있는 것
        for (int d = 0; d < dir.length; d++) {
            int ny = y + dir[d][0];
            int nx = x + dir[d][1];

            if (!isInRange(ny, nx)) continue;
            if (visited[ny][nx]) continue;

            if (board[ny][nx] == 'x') {
                visited[ny][nx] = true;
                info[ny][nx] = type;
                DFS(ny, nx, type);
            }
        }
    }

    public static void pro() {
        int dir = -1;
        for (int i = 0; i < heights.length; i++) {
            destroy(heights[i], dir);
            analyze();
            gravitate();
            init();
            dir *= -1;
        }

        display(board);
    }

    public static void init() {
        info = new int[R][C];
        visited = new boolean[R][C];
        type = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());

        board = new char[R][C];
        info = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = line[j];
            }
        }

        total = Integer.valueOf(br.readLine());

        heights = new int[total];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < total; i++) {
            heights[i] = Integer.valueOf(st.nextToken());
        }

        pro();
    }
}

