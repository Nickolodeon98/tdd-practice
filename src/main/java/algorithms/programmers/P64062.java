package algorithms.programmers;

public class P64062 {
// 한 번에 한명씩 징검다리를 건널 때, stones 에 적힌 숫자를 참고해서 최대한 많은 친구들이 징검다리를 건널 수 있게 만들어라.
// 항상 가장 가까운 디딤돌로 뛰되, 앞에 0이 놓여있는 경우 다음 가장 가까운 0이 아닌 돌로 뛴다.
// 이 때, k 를 넘어가면 뛸 수 없다.
// 연속해서 0이 k 개 이상 나오는 순간 종료된다.
// 첫 번째 친구가 건너면 모든 배열의 원소들의 값은 1씩 감소한다.

// 길이 k 인 부분 수열 중 최댓값이 가장 작은 부분 수열을 찾으면 된다.

  // k 개의 숫자의 최소공배수들 중 가장
  public int bridge(int[] stones, int k) {
    int rightPtr = k - 1;
    int leftPtr = 0;
    int min = 200_000_000;
    int max = 0;
    int minLeft = 0;
    int minRight = 0;

    while (rightPtr < stones.length) {
      for (int i = leftPtr; i <= rightPtr; i++) {
        max = Math.max(max, stones[i]);
      }
      if (min > max) {
        min = max;
        minLeft = leftPtr;
        minRight = rightPtr;
      }
      leftPtr++;
      rightPtr++;
      max = 0;
    }
    // System.out.println(min);

    // System.out.println(minLeft + " " + minRight);
    return min;
  }

  public int solution(int[] stones, int k) {
    int answer = 0;

    answer = bridge(stones, k);

    return answer;
  }
}
