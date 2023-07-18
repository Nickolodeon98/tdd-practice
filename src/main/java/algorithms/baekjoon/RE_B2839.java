package algorithms.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class RE_B2839 {

  public void solution(int goal) {
    int[] containers = {3, 5};

    int[] dp = new int[goal + 1];
    dp[1] = dp[2] = 99999;
    for (int i = 3; i <= goal; i++) {
      dp[i] = 99999;
      dp[i] = Math.min(dp[i], dp[i-3] + 1);

      if (i >= 5) dp[i] = Math.min(dp[i], dp[i-5] + 1);
    }
    if (dp[goal] == 99999) {
      System.out.println(-1);
    } else System.out.println(dp[goal]);
}

public static void main(String[]args){
    RE_B2839 test=new RE_B2839();
    Scanner sc=new Scanner(System.in);

    int num=sc.nextInt();
    test.solution(num);
    }
    }
