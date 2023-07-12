package algorithms.baekjoon;

import java.util.Scanner;

public class B11726 {
//  2 x n 이므로 타일들을 모두 모아서 채울 시 가로와 세로를 모두 채워야 한다.
//  n 에 따라 위에 올 수 있는 타일의 수가 달라진다.
//  n 이 5이면 1 1 1 1 1
//  옆에는 2가 올 수 있기 때문에 무조건 1이랑 2만 사용해서 n 을 채워야 한다.
//  1 1 2 1, 1 1 1 1 1, 2 2 1, 1 2 1 1, 1 1 1 2, 2 1 1 1, 2 1 2, ...
//  결국 순서가 중요한 특정 숫자를 1과 2를 사용해서 만들 수 있는 방법을 모두 세면 된다. (permutation)
//  모든 경우의 수를 다 세면 너무 많기 때문에 DP 를 사용한다.
//  원래 문제와 부분 문제들로 나누어 보자.
//  n을 만들 수 있는 방법의 수 = n - 1 을 만들 수 있는 방법의 수 + 1이 올 수 있는 위치의 수 + ... + n / 2
//  1 1 2 1 1, 1 1 1 2 1, 1 2 1 1 1, 1 1 1 2 1, 2 1 1 1 1
//  5를 만들 수 있는 방법의 수 = 4를 만들 수 있는 방법의 수 + 1이 올 수 있는 위치의 수 1 1 2 1, 1 2 1 1, 1 1 1 2, 2 1 1 1, 1 1 1 1 1, 2 2 1, 1 2 2, 2 1 2

//  n 이 2의 배수라면 하나를 더 추가.
//  4를 만들 수 있는 방법의 수 = 3을 만들 수 있는 방법의 수 + 1이 올 수 있는 위치의 수 1 2 1, 1 1 2, 2 1 1, 1 1 1 1, 2 2
//  3을 만들 수 있는 방법의 수 = 2를 만들 수 있는 방법의 수 + 1이 올 수 있는 위치의 수  1 2, 2 1, 1 1 1
//  2를 만들 수 있는 방법의 수 = 2

  final static int DIVIDER = 10007;
  public void tiles(int N) {
    int answer = 0;

    int a = 1;
    int b = 2;

    if (N == 1) answer = 1;
    else if (N == 2) answer = 2;
    else for (int i = 3; i <= N; i++) {
      answer = (a+b) % DIVIDER;
      a = b;
      b = answer;
    }

    System.out.println(answer);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();
    B11726 test = new B11726();

    test.tiles(Integer.valueOf(input));
  }
}
