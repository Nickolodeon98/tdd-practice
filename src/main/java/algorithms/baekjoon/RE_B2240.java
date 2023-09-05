package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_B2240 {

  static int T;
  static int W;
  static int[][][] dp;
  static int[] trees;

  public static void solution() {
//    일단 3차원 배열을 만들고 시작한다.
//    dp[현재 나무][흐른 시간(초)][이동 횟수] = 현재까지 받은 자두의 개수

    dp = new int[3][T + 1][W + 1];

//    예를 들어 현재 1번 나무에 있고 1초가 흐른 상태인데 1번 나무에서 자두가 떨어진다면 0번 움직였을 때에
//    자두는 1개를, 자두가 2번 나무에서 떨어진다면 자두는 0개를 받을 것이다.
    dp[1][1][0] = trees[1] == 1 ? 1 : 0;
//    예를 들어 현재 2번 나무에 있고 1초가 흐른 상태인데 2번 나무에서 자두가 떨어진다면 1->2 1번 움직였을 때에
//    자두는 1개를, 자두가 1번 나무에서 떨어진다면 자두는 0개를 받을 것이다.
    dp[2][1][1] = trees[1] == 2 ? 1 : 0;

//    시간이 얼마나 흘렀는지와 상관 없이, 아예 움직이지 않는다면 자두는 1번 나무에서 떨어지는 만큼 받을 수 있다.
    for (int j = 1; j <= T; j++) {
      dp[1][j][0] = trees[j] == 1 ? dp[1][j-1][0] + 1 : dp[1][j-1][0];
    }

//    이후에 현재 1번 나무에 있고 2초가 흐른 상태이며 2번 이동했으면
//    2번 이동하고 1번에 있는 경우 & 1번 이동하고 2번에 있었던 경우
//    각각에서 받은 자두의 개수 중 더 큰 값 + 현재 2초 흐른 곳의 나무가
//    1번이라면 1, 아니면 0을 계산한다.
//    dp[1][2][1] = Math.max(dp[1][1][2], dp[2][1][1]) +
    for (int t = 2; t <= T; t++) {
      for (int w = 1; w <= W; w++) {
        for (int p = 1; p <= 2; p++) {
          dp[p][t][w] = p == 1 ? Math.max(dp[1][t - 1][w], dp[2][t - 1][w - 1])
              : Math.max(dp[1][t - 1][w - 1], dp[2][t - 1][w]);
          dp[p][t][w] = trees[t] == p ? dp[p][t][w] + 1 : dp[p][t][w];
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int[][] timeAndWalk : dp) {
      for (int cnt : timeAndWalk[T]) {
        max = Math.max(max, cnt);
      }
    }
    System.out.println(max);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    T = Integer.valueOf(st.nextToken());
    W = Integer.valueOf(st.nextToken());

    trees = new int[T + 1];
    for (int i = 1; i <= T; i++) {
      trees[i] = Integer.valueOf(br.readLine());
    }

    solution();
  }
}
