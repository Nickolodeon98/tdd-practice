package algorithms.programmers;

import java.util.*;

public class P42884 {
  // 고속도로, 단속용 카메라 설치
// routes -> 차량의 경로
// 모두 단속용 카메라를 만나도록 설치
// 1대 이상 10000대 이하
// routes 에는 이동 경로 포함
// routes[i][0]는 출입 지점, routes[i][1]은 출차 지점
// -5 지점에 카메라 설치 시 -> 2, 4번 차량
// -15 지점에 카메라 설치 시 -> 1, 3번 차량
// 카메라는 두 숫자의 사이 또는 두 숫자와 동일한 수여야 한다.
// 예) -20, -15 면 -20 ~ -15 사이의 모든 수가 가능이다.
// 우선 모든 수를 파악한다.

// 네 개의 범위 중 겹치는 부분을 커버하려면 와야 하는 숫자가 몇개인지 구한다.
// 겹치는 부분이 하나도 없으면 routes 의 길이만큼이므로 초기화를 routes 의 길이로 한다.
// 겹치는 부분이 하나라도 있을 때마다 1을 줄인다.


  public int solution(int[][] routes) {
    int answer = routes.length;

    Map<Integer, Integer> cars = new HashMap<>();

    PriorityQueue<Integer> sorts = new PriorityQueue<>(Collections.reverseOrder());

    for (int[] r : routes) {
      cars.put(r[0], r[1]);
      sorts.add(r[0]);
    }

    while (!sorts.isEmpty()) {
      if (sorts.size() >= 2 && sorts.poll() <= cars.get(sorts.poll())) {
        answer--;
      }
    }
    return answer;
  }

}
