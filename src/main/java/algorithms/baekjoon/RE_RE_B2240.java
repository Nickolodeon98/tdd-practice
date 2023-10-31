package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_RE_B2240 {
    static int count = Integer.MIN_VALUE;
    static int[][][] dp;
    static int W;
    static int T;

    public static void init() {
        for (int j = 0; j < dp[0].length; j++) {
            for (int i = j; i >= 0; i--) {
                dp[i][j][1] = Integer.MIN_VALUE;
                dp[i][j][2] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j += 2) {
                dp[i][j][2] = Integer.MIN_VALUE;
                if (j + 1 >= dp[0].length) break;
                dp[i][j + 1][1] = Integer.MIN_VALUE;
            }
        }
        dp[1][0][1] = 1;
        dp[1][1][2] = 1;
        dp[2][1][2] = 1;
        dp[2][2][1] = 1;
    }

    public static void countPlums(int second, int treeNum) {
        // 자두는 처음에 1번 나무 아래에 있으므로 자두는 만약 처음에 2번에서 떨어지면 1번 움직이고 먹고, 1번에서 떨어지면 안 움직이고 먹는다.
        // dp[t][w][n] = t초에 자두가 w번 움직이면 n 번 나무에서 먹을 수 있는 최대 개수
        // 예) 1초에 한번 움직이면 2번에서 떨어지는 자두만 먹을 수 있고
        // dp[1][1][1] = 0; dp[1][1][2] = 1;
        // 1초에 한번도 안움직이면 1번에서 떨어지는 자두만 먹을 수 있다.
        // dp[1][0][1] = 1; dp[1][0][2] = 0;
        // 2초에는 1초에 먹을 수 있는 개수에 + 1을 하는 것인데, 이 때 2초에 움직인 횟수도 지난 움직인 횟수를 보고 결정해야 하는데,
        // 2초에 2번 움직이고 1번 나무에서 자두를 먹을 때의 최대 개수는 2번 나무에서 1초에 1번 움직이고 먹은 자두의 개수 + 1 과 1초에 1번 나무에서 이미 2번 움직이고 먹은 자두의 개수 + 1
        // 중 최대를 찾으면 된다.
        // 아래 두가지 경우는 -1 처리한다. 불가능이기 때문이다.
        // dp[0][1][1] = -1, dp[0][0][2] = -1;
        // dp[1][1][1] = -1, dp[1][0][2] = -1;
        // dp[2][2][2] = -1
        // dp[3][3][1]

        // dp[a][b][n] 에서 a < b 이면 무조건 -1
        // dp[t][짝수 or 0][2] 는 무조건 -1
        // dp[t][홀수][1] 은 무조건 -1

        // dp[1][1][1] = Math.max(dp[0][1][1] + 1, dp[0][0][2] + 1)
        // dp[1][1][2] = Math.max(dp[0][1][2] + 1, dp[0][0][1] + 1)
        // dp[2][2][1] = Math.max(dp[1][1][2] + 1, dp[1][2][1] + 1)

        // dp[i][j][1] = Math.max(dp[i-1][j][1] + 1, dp[i-1][j-1][2] + 1)
        // dp[i][j][2] = Math.max(dp[i-1][j][2] + 1, dp[i-1][j-1][1] + 1)

        for (int j = 1; j <= W; j++) {
            if (treeNum == 1) {
                dp[second][j][1] = Math.max(dp[second - 1][j][1] + 1, dp[second - 1][j - 1][2] + 1);
            }
            else {
                dp[second][j][2] = Math.max(dp[second - 1][j][2] + 1, dp[second - 1][j - 1][1] + 1);
            }


            count = Math.max(count, dp[second][j][treeNum]);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.valueOf(st.nextToken());
        W = Integer.valueOf(st.nextToken());

        dp = new int[T + 1][W + 1][3];

        init();
        for (int i = 1; i <= T; i++) {
            int treeNum = Integer.valueOf(br.readLine());

            countPlums(i, treeNum);
        }

        System.out.println(count);
    }
}
