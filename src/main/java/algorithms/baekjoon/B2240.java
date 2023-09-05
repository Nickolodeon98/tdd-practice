package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//    dp[n] = n개 받기 위해 필요한 움직임의 최소 수
//    dp는 언제 갱신하는가?
//    dp[1]은 처음에는 1이더라도 두 번째 나무를 만나면 다시 0이 된다.
//
public class B2240 {
  static int[] trees;
  static int[] dp;
  static int T;
  static int W;
  public static void solution() {

    dp = new int[T+1];
    dp[1] = trees[1] == 2 ? 1 : 0;

    for (int i = 2; i <= T; i++) {
      dp[i] = trees[i] == trees[i-1] ? dp[i-1] : dp[i-1] + 1;
    }
    int ans = 0;
    for (int d = 1; d < dp.length; d++) {
      if (dp[d] == W) {
        ans = d;
      }
    }

    System.out.println(ans);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    T = Integer.valueOf(st.nextToken());
    W = Integer.valueOf(st.nextToken());

    trees = new int[T+1];
    for (int i = 1; i <= T; i++) {
      trees[i] = Integer.valueOf(br.readLine());
    }

    solution();
  }

}
