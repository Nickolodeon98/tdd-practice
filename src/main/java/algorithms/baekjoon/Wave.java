package algorithms.baekjoon;

import java.util.*;
public class Wave {
  int[] memo;

  void setMemo(int[] memo) {
    this.memo = memo;
  }

  public void printMemo() {
    for (int i : memo) {
      System.out.println(i);
    }
  }

  public int wave(int x) {
    if (x < 0) {
      return 0;
    }
    if (x <= 2) {
      if (memo[x] == 0)
        memo[x] = 1;
      return memo[x];
    }
    int a = 0;
    int b = 0;
    if (memo[x-2] != 0) {
      a = memo[x-2];
    }
    else {
      memo[x-2] = wave(x-2);
      a = memo[x-2];
    }
    if (memo[x-3] != 0) {
      b = memo[x-3];
    }
    else {
      memo[x-3] = wave(x-3);
      b = memo[x-3];
    }

    return a + b;
  }

  public static void main(String[] args) {
    Wave test = new Wave();

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] answer = new int[T];
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      test.setMemo(new int[N]);
      answer[i] = test.wave(N-1);
      test.printMemo();
    }
    for (int a : answer) {
      System.out.println(a);
    }
  }
}
