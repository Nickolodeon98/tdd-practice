package algorithms.baekjoon;

import java.util.Scanner;

public class RE_B11726 {

  final static int DIVIDER = 10007;
  public int solution(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int a = 1;
    int b = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = (a + b) % DIVIDER;
      a = b;
      b = result % DIVIDER;
    }

    return result;
  }

  public static void main(String[] args) {
    RE_B11726 test = new RE_B11726();

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    System.out.println(test.solution(num));
  }
}
