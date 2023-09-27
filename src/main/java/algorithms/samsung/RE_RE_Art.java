package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_RE_Art {

    static int[][] board;
    static int n;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] spin = {{0,1},{0,-1},{-1,0},{1,0}}; // 우좌상하
    static int[][] groups;
    static boolean[][] visited;
    static int[][] changed;
    static int count = 1;
    static int pivot;

    public static void spinRectHorizon(int startY, int endY, int startX, int endX, int dist) {
        int d = 0;

        if (startY == endY && startX == endX) {
            changed[startY][startX] = board[startY][startX];
            return;
        }

        for (int i = startY; i <= endY; i += (endY-startY)) {
            for (int j = startX; j <= endX; j++) {
                int nx = j + (spin[d][1] * dist);
                int ny = 0;
                if (i == startY) {
                    ny = startY + Math.abs(nx - endX);
                    changed[ny][endX] = board[i][j];
                }
                if (i == endY) {
                    ny = endY - Math.abs(nx - startX);
                    changed[ny][startX] = board[i][j];
                }
            }
            d++;
        }

    }

    public static void spinRectVert(int startY, int endY, int startX, int endX, int dist) {
        int d = 2;

        if (startY == endY && startX == endX) {
            changed[startY][startX] = board[startY][startX];
            return;
        }

        for (int i = startX; i <= endX; i += (endX-startX)) {
            for (int j = startY; j <= endY; j++) {
                int ny = j + (spin[d][0] * dist);
                int nx = 0;
                if (i == startX) {
                    nx = startX + Math.abs(ny - startY);
                    changed[startY][nx] = board[j][i];
                }
                if (i == endX) {
                    nx = endX - Math.abs(ny - endY);
                    changed[endY][nx] = board[j][i];
                }
            }
            d++;
        }

    }

    public static void copy(int[][] from, int[][] to) {
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < from[0].length; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    public static void reset() {
        changed = new int[n][n];
        groups = new int[n][n];
        visited = new boolean[n][n];
        count = 1;
    }

    public static void solution() {
        int repeat = 0, score = 0;
        while (repeat < 4) {
            int total = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    DFS(i, j, count++);
                }
            }

            for (int i = 1; i <= count - 1; i++) {
                for (int j = i + 1; j <= count; j++) {
                    total += computeHarmony(i, j);
                }
            }
//            System.out.println(total);
            score += total;
            spinAll();

            copy(changed, board);

            reset();

//            display(board);

            repeat++;
        }
        System.out.println(score);
    }

    public static void spinAll() {
        spinMiddle();
        int i = 0, divisor = 1;

        while (i <= pivot-1-i && pivot +1 + i <= n - 1 - i) {
            spinRectHorizon(i, pivot - 1 - i, i, pivot - 1 - i, pivot -divisor);
            spinRectVert(i, pivot - 1 - i, i, pivot - 1 - i, pivot - divisor);
            spinRectHorizon(i, pivot - 1 - i, pivot + 1 + i, n - 1 - i, pivot - divisor);
            spinRectVert(i, pivot - 1 - i, pivot + 1 + i, n - 1 - i, pivot - divisor);
            spinRectHorizon(pivot + 1 + i, n - 1 - i, i, pivot - 1 - i, pivot - divisor);
            spinRectVert(pivot + 1 + i, n - 1 - i, i, pivot - 1 - i, pivot - divisor);
            spinRectHorizon(pivot + 1 + i, n - 1 - i, pivot + 1 + i, n - 1 - i, pivot - divisor);
            spinRectVert(pivot + 1 + i, n - 1 - i, pivot + 1 + i, n - 1 - i, pivot - divisor);
            divisor += 2;
            i++;
        }
    }

    public static void spinMiddle() {
        changed[pivot][pivot] = board[pivot][pivot];
        for (int i = 1; i <= pivot; i++) {
            for (int d = dir.length-1; d >= 0; d--) {
                int ny = pivot + (dir[(d+1)%4][0] * i);
                int nx = pivot + (dir[(d+1)%4][1] * i);

                int cy = pivot + (dir[d][0] * i);
                int cx = pivot + (dir[d][1] * i);

                changed[cy][cx] = board[ny][nx];
            }
        }
    }



    public static boolean isInRange(int y, int x) {
        return y < n && y >= 0 && x < n && x >= 0;
    }

    public static void display(int[][] info) {
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[0].length; j++) {
                System.out.print(info[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int computeHarmony(int groupA, int groupB) {
        int cntA = 0, cntB = 0, typeA = 0, typeB = 0, adjacent = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (groups[i][j] == groupA) {
                    for (int d = 0; d < dir.length; d++) {
                        int ny = i + dir[d][0];
                        int nx = j + dir[d][1];
                        if (!isInRange(ny, nx)) continue;
                        if (groups[ny][nx] == groupB) adjacent++;
                    }
                    
                    cntA++;
                    typeA = board[i][j];
                }
                if (groups[i][j] == groupB) {
                    cntB++;
                    typeB = board[i][j];
                }
            }
        }

        return (cntA + cntB) * typeA * typeB * adjacent;
    }

    public static void DFS(int y, int x, int cnt) {
        groups[y][x] = cnt;
        for (int d = 0; d < dir.length; d++) {
            int ny = y + dir[d][0];
            int nx = x + dir[d][1];

            if (!isInRange(ny, nx)) continue;
            if (visited[ny][nx]) continue;

            if (board[ny][nx] == board[y][x]) {
                visited[ny][nx] = true;
                groups[ny][nx] = cnt;
                DFS(ny, nx, cnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        pivot = n / 2;
        board = new int[n][n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        groups = new int[n][n];
        visited = new boolean[n][n];
        changed = new int[n][n];
        solution();
    }
}
