package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Amusement {

    static int n;
    static int[][] board;
    static Map<Integer, List<Integer>> info;
    static int[] scoreBoard = {0, 1, 10, 100, 1000};
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] ppl;

    public static boolean isInRange(int y, int x) {
        return y <= n && y >= 1 && x <= n && x >= 1;
    }

    public static void solution() {
        for (int i = 0; i < n * n; i++) {
            int row = 0;
            int col = 0;
            int cnt = 0;
            int me = ppl[i][0];
            List<Integer> friends = info.get(me);

            int maxFriends = 0;
            int maxBlanks = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {

                    int cntFriends = 0;
                    int cntBlanks = 0;
                    if (board[j][k] == 0) {
                        if (cnt == 0) {
                            row = j;
                            col = k;
                        }
                        cnt++;
                        for (int d = 0; d < dir.length; d++) {
                            int ny = j + dir[d][0];
                            int nx = k + dir[d][1];

                            if (!isInRange(ny, nx)) continue;

                            if (friends.contains(board[ny][nx])) cntFriends++;
                            if (board[ny][nx] == 0) cntBlanks++;
                        }

                        if (cntFriends > maxFriends) {
                            maxBlanks = cntBlanks;
                            maxFriends = cntFriends;
                            row = j;
                            col = k;
                        } else if (cntFriends == maxFriends) {
                            if (cntBlanks > maxBlanks) {
                                maxBlanks = cntBlanks;
                                row = j;
                                col = k;
                            }
                        }
                    }

                }
            }
            board[row][col] = me;
        }
//        display();
        countScore();
    }

    public static void display() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void countScore() {
        int score = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                cnt = 0;
                for (int d = 0; d < dir.length; d++) {
                    int ny = i + dir[d][0];
                    int nx = j + dir[d][1];

                    if (!isInRange(ny, nx)) continue;
                    if (!info.containsKey(board[i][j])) continue;
                    if (info.get(board[i][j]).contains(board[ny][nx])) cnt++;
                }

                score += scoreBoard[cnt];
            }
        }

        System.out.println(score);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());

        board = new int[n + 1][n + 1];

        info = new HashMap<>();
        ppl = new int[n * n][5];
        StringTokenizer st = null;

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int me = Integer.valueOf(st.nextToken());
            ppl[i][0] = me;
            info.put(me, new ArrayList<>());
            for (int j = 1; j < 5; j++) {
                int friend = Integer.valueOf(st.nextToken());
                info.getOrDefault(me, new ArrayList<>()).add(friend);
                info.put(me, info.get(me));
                ppl[i][j] = friend;
            }
        }
        solution();
    }
}
