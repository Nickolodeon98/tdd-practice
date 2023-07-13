package algorithms.baekjoon;

import java.util.Scanner;

public class B11722 {

  int[] dp;
  public void solution(int[] sequence) {
    dp = new int[sequence.length];

    int answer = 0;
    for (int i = 0; i < sequence.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (sequence[j] > sequence[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }

    for (int d : dp) {
      System.out.print(d + " ");
    }
    System.out.println(answer);
  }

  public static void main(String[] args) {
    B11722 test = new B11722();
    Scanner sc = new Scanner(System.in);

    int size = Integer.valueOf(sc.nextLine());

    int[] s = new int[size];

    String[] line = sc.nextLine().split(" ");

    for (int i = 0; i < s.length; i++) {
      s[i] = Integer.valueOf(line[i]);
    }
    test.solution(s);
  }
}
