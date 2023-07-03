package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B16637 {
  int max = Integer.MIN_VALUE;
  List<Character> identifiers  = new ArrayList<>();
  List<Character> numbers = new ArrayList<>();
  public void solution(String sentence, int order) {
//    우선 연산자와 숫자를 따로 스택에 넣는다
//    3+8x7-9x2 는
//    2 9 7 8 3
//    x - x +
//    이렇게 두 스택으로 나뉜다.
//    두 스택을 돌아가면서 완전탐색한다.
//    숫자를 하나씩 증가시키면서
//    숫자만큼 반복 후 pop 을 하는 식으로
//    무언가를 넣고 그 후에 계산하기 위해 스택에 저장한다.

    for (int i = 0; i < sentence.length(); i += 2) {
      numbers.add(sentence.charAt(i));
    }

    for (int j = 1; j < sentence.length()-1; j += 2) {
      identifiers.add(sentence.charAt(j));
    }

    int start = numbers.get(0);
    DFS(0, start);

  }

  public void DFS(int identifierIdx, int start) {
    if (identifierIdx == )
    for ()
    int one = cal(identifierIdx, start, numbers.get(identifierIdx + 1));
    sum = DFS(identifierIdx + 1, one);
    if (identifierIdx + 1 < identifiers.size()) {
      int two = cal(identifierIdx, numbers.get(identifierIdx + 1), numbers.get(identifierIdx + 2));
      DFS(identifierIdx + 2, two);
    }
  }

  public int cal(int idx, int a, int b) {
    if (identifiers.get(idx) == '+') return a + b;

    if (identifiers.get(idx) == '*') return a * b;

    if (identifiers.get(idx) == '-') return a - b;
  }
}
