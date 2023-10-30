package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RE_B9655 {
    // 상근: 1, 창영: 2
    // -1 과 -3 을 반복한다.
    // turns[i] : i번째에 돌을 가져간 사람
    // turns[0] : N-1 -> 첫번째는 반드시 상근이가 가져간다.
    // turns[1] : N-2 -> 창영이가 가져갈 수도 있지만, 상근이도 가져갈 수 있다.
    // turns[2] :
    // turns[1] + turns[2]
    static int[] dp;

    public static void solution(int cur) {
        int turn = 1;
        while (cur > 0) {
            if (turn % 2 == 1) {
                dp[cur - 1] = dp[cur] + 1;
                cur -= 1;
            } else {
                dp[cur - 3] = dp[cur] + 1;
                cur -= 3;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        dp = new int[N + 1];
        dp[N] = 0;
        solution(N);

        System.out.println(dp[0] % 2 == 0 ? "CY" : "SK");
    }
}

