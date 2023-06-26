package algorithms.programmers;

import java.util.*;

public class P42839_2 {

  // 종이 조각이 흩어져 있음
// 소수를 몇 개를 만들수 있을까?
// 문자열 numbers 가 주어졌을 때,
// 만들 수 있는 소수의 개수를 구하여라
// 우선 숫자들을 모두 만들고, 그 중 소수를 찾는다.
// 숫자의 조합은 여러개인데, 여러 조합 중 소수인 것을 찾을 방법은 여러개이다.
// 여러 숫자의 조합 모두 찾을 수 있다.
  boolean[] visited;
  char[] loopThru;
  Set<Integer> allNums = new HashSet<>();

  public void generate(char start, String current) {
    if (start != ' ') {
      allNums.add(Integer.parseInt(current));
    }

    if (current.length() == loopThru.length) {
      return;
    }

    for (int i = 0; i < loopThru.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      generate(loopThru[i], current + loopThru[i]);
      visited[i] = false;
    }
  }

  public boolean isPrime(int num) {
    if (num == 0 || num == 1) {
      return false;
    }
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public int check(Set<Integer> nums) {
    int cnt = 0;
    for (int n : nums) {
      if (isPrime(n)) {
        cnt++;
      }
    }
    return cnt;
  }

  public int solution(String numbers) {
    loopThru = numbers.toCharArray();
    visited = new boolean[numbers.length()];
    generate(' ', "");
    return check(allNums);
  }

}
