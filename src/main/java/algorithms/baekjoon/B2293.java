package algorithms.baekjoon;

import java.util.Scanner;

public class B2293 {
//  동전의 순서는 영향이 없다.
//  동전의 종류가 주어졌을 때, 가치를 만들 수 있는 경우의 수를 모두 센다
//  1 2 5 가 주어지고 10을 만드려고 하면
//  1 10개, 1 두개 2 네개, 1 세개 2 한개 5 한개, 1 네개 2 세개, 1 5개 5 한개, 1 6개 2 두개, 1 8개 2 한개, 2 두개 1 한개 5 한개, 2 5개, 5 2개 로 만들 수 있다.
//  DFS 로 짜보면,
  int[] values;
  int N;
  int cnt = 0;
  public void solution() {
    Scanner sc = new Scanner(System.in);

    String[] size = sc.nextLine().split(" ");

    int num = Integer.valueOf(size[0]);

    N = num;
    values = new int[N];
    for (int i = 0; i < N; i++) {
      values[i] = Integer.valueOf(sc.nextLine());
    }

    DFS(0, 0, Integer.valueOf(size[1]));

    System.out.println(cnt);
  }
// 이미 메모이제이션에 배낭 문제에서와 같이
//  1 2 3 이 있는 경우를
//  1과 3만 있는 경우 + 2도 있는 경우
//
  public void DFS(int idx, int start, int goal) {
    if (start >= goal) {
      if (start == goal) cnt++;
      return;
    }

    for (int i = idx; i < N; i++) {
      DFS(i, start + values[i], goal);
    }
  }

  public static void main(String[] args) {
    B2293 test = new B2293();

    test.solution();
  }
}
