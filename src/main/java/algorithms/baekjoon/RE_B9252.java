package algorithms.baekjoon;

import java.util.Scanner;

public class RE_B9252 {

  public void solution(String A, String B) {
    int[][] memo = new int[A.length() + 1][B.length() + 1];
    String sb = "";

    for (int i = 0; i < A.length(); i++) {
      for (int j = 0; j < B.length(); j++) {
        if (A.charAt(i) == B.charAt(j)) {
          memo[i + 1][j + 1] = 1 + memo[i][j];
        } else {
          memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
        }
      }
    }

    System.out.println(memo[A.length()][B.length()]);
    int cur = memo[A.length()][B.length()];

    for (int[] ints : memo) {
      for (int m : ints) {
        System.out.print(m + " ");
      }
      System.out.println();
    }
    int i = memo.length-1;
    int j = memo[0].length-1;

    while (i >= 1 && j >= 1) {
      if (memo[i - 1][j] == cur - 1 && memo[i][j - 1] == cur - 1) {
        cur = memo[i - 1][j - 1];
        sb = A.charAt(i - 1) + sb;
        i--;
        j--;
        continue;
      }

      if (memo[i-1][j] == cur) i--;
      else if (memo[i][j-1] == cur) j--;

    }
    System.out.println(sb);
  }

  public static void main(String[] args) {
    RE_B9252 test = new RE_B9252();

    Scanner sc = new Scanner(System.in);

    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    test.solution(s1, s2);
  }
}
