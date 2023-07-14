package algorithms.baekjoon;

import java.util.Scanner;

public class RE_RE_B9252 {
  public void solution(String A, String B) {
    int[][] dp = new int[A.length() + 1][B.length() + 1];

    for (int i = 0; i < A.length(); i++) {
      for (int j = 0; j < B.length(); j++) {
        if (A.charAt(i) == B.charAt(j))
          dp[i+1][j+1] = 1 + dp[i][j];
        else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
      }
    }

    for (int[] d : dp) {
      for (int num : d) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
    int i = A.length();
    int j = B.length();
    String answer = "";
    while (i >= 1 && j >= 1) {
      if (dp[i][j] - 1 == dp[i-1][j] && dp[i][j] - 1 == dp[i][j-1]) {
        answer = B.charAt(j-1) + answer;
        i--;
        j--;
        continue;
      }

      if (dp[i][j] == dp[i-1][j]) {
        i--;
        continue;
      }
      if (dp[i][j] == dp[i][j-1]) {
        j--;
        continue;
      }
    }
    System.out.println(answer.length());
    System.out.println(answer);
  }

  public static void main(String[] args) {
    RE_RE_B9252 test = new RE_RE_B9252();

    Scanner sc = new Scanner(System.in);

    String A = sc.nextLine();
    String B = sc.nextLine();

    test.solution(A, B);
  }
}
