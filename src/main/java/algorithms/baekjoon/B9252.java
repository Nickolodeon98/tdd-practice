package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.List;

public class B9252 {

//  최장 공통 수열을 찾기 위해서는 각 문자를 돌면서 1개 길이부터 n 개 길이까지 LCS 를 센다
//  1개 일 때 - A, C, A, K, P
//  2개 일 때 - 한 개인 LCS 들에서 문자를 하나씩 더하여 만든다.
//  AC, CA, AK, CK, CP, AP, AA
//  조건 : 위 문자보다 뒤에 있는 수열들의 LCS 에 문자를 합친 케이스
//  맨 마지막 문자의 인덱스보다 뒤에 있는 수들의 수열의 LCS 를 찾으면 된다.
//  만약 없다면 그만 찾으면 된다.
//  1. 공통된 부분 수열 중 길이가 1인 문자들 찾기


  public void solution(String A, String B) {
//    우선 두 문자의 공통 문자를 구한다.
    List<Character> ones = new ArrayList<>();
    boolean con = false;
    for (char a : A.toCharArray()) {
      boolean[] visited = new boolean[B.length()];
      for (int i = 0; i < B.length(); i++) {
        if (visited[i]) continue;
        if (con) continue;
        if (a == B.charAt(i)) {
          ones.add(a);
          visited[i] = true;
          con = true;
        }
      }
      con = false;
    }
    System.out.println(ones);
  }

  public static void main(String[] args) {
    B9252 test = new B9252();

    test.solution("ACAYKP", "CAPCAK");
  }
}
