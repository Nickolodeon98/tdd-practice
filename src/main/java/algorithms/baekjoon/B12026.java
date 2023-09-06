package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12026 {
//  BOJ - 보도블럭 N개 일렬로 정렬
//  보도블럭 -> 1 ~ N 까지 번호 매겨짐
//  스타트의 집: 1번, 링크의 집: N번
//  start = 1;
//  link = N;
//  각 보도블럭에는 B, O, J 중 하나가 쓰여 있음
//  1번은 반드시 B 임
//  스타트는 링크를 만나기 위해서 점프해야 함.
//  점프는 항상 앞으로만 할 수 있고, k 칸 움직이는 데에 k^2 만큼의 에너지 소모
//  보도블럭은 BOJ 의
//  현재 위치가 B 라면 이전에 J 까지 이동한, J 라면 O 까지, O 라면 B 까지 이동할 때 사용된 에너지 + 현재 위치와
//  이전 위치의 거리^2 를 해주면 된다.
//  dp[현재 위치] = dp[이전 위치] + (dist[현재 위치] - dist[이전 위치])^2
//  dp[블럭정보][현재 위치] = dp[블럭정보][이전 위치]
//  B = 0, O = 1, J = 2
//  한 번도 이동하지 않고 현재 도로의 처음에 위치해 있으면 에너지는 소모되지 않았다.
//  dp[street[1]][0] = 0;
//  현재 이동 횟수보다 1 적은 상태에서 이동했으므로 'J' 이동 횟수
//  dp[street[2]][다음 위치] = street[2] == 'B' ? dp['J'][현재 J 의 위치] + (다음 위치 - 현재 위치)^2

//  dp[street[2]][2] = dp[street[2]-1][pos[street[2]-1]] +
//  예) dp[street[2]][1] = street[2] == 'B' ? dp['J'][0]
//  dp[street[3]][1] = street[3] == 'O' ? dp['B'][0] + 3 -
//  한 번 이동하고 O 에 있으려면 한번도 이동하지 않고 B 에 있을 때 에너지에 현재 위치
  static int[][] dp;
  static int N;
  static int[] street;
  static int[] pos;
  public static void solution() {
    dp = new int[3][N+1];
    pos = new int[3];
    pos[street[1]] = 1;

    for (int n = 2; n <= N; n++) {
      int prevSt = street[n]-1;
      if (prevSt == -1) prevSt = 2;
      dp[street[n]][n] = dp[prevSt][pos[prevSt]] + (int) Math.pow(n - pos[prevSt], 2);
      pos[street[n]] = n;
    }

    for (int[] d : dp) {
      for (int i : d) {
        System.out.print(i + " ");
      }
      System.out.println();
      System.out.println();
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());

    char[] streetInfo = br.readLine().toCharArray();
    street = new int[N+1];

    for (int i = 1; i <= N; i++) {
      if (streetInfo[i-1] == 'B')
        street[i] = 0;
      else if (streetInfo[i-1] == 'O')
        street[i] = 1;
      else street[i] = 2;
    }

    solution();
  }
}
