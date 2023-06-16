package algorithms.programmers;

import java.util.*;

public class P154539 {

//     Stack 을 사용한다.
//     Stack 에는 인덱스를 저장한다.
//     Stack 의 인덱스를 확인하면서 현재 peek 인덱스에 위치한 숫자보다 현재 numbers 의 숫자가 더 크다면 현재 peek 에 있는 인덱스를 pop 해서 answer 의 그 인덱스 자리에 numbers 의 숫자를 넣어준다.
//     마지막에 numbers 의 끝에 도달했는데 stack 이 아직 비지 않았다면 stack 에 있는 인덱스들은 모두 -1 로 채워준다.

  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];

    Stack<Integer> candidates = new Stack<>();

    candidates.push(0);
    for (int i = 1; i < numbers.length; i++) {
      while (!candidates.isEmpty() && numbers[candidates.peek()] < numbers[i]) {
        answer[candidates.pop()] = numbers[i];
      }
      candidates.push(i);
    }

    while (!candidates.isEmpty()) {
      answer[candidates.pop()] = -1;
    }

    return answer;
  }

}
