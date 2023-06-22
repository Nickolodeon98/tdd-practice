package algorithms.programmers;

import java.util.*;

public class P178870 {

  // 우선 포인터 두개를 써서 양 끝을 추적하면서
// 두 포인터 모두를 맨 뒤에 먼저 배치한다.
// 1. 만약 K 보다 더 크다면 오른쪽 포인터를 왼쪽으로 한칸 움직인다.
// 2. 만약 오른쪽 포인터가 왼쪽 포인터보다 왼쪽에 위치한다면 왼쪽 포인터도 오른쪽 포인터의 위치로 움직여준다.
// 3. k 보다 작다면 왼쪽 포인터를 왼쪽으로 한칸 움직인다.
// 4. 위 세 스텝을 계속 반복하고, k 와 같다면 그 때의 시작과 끝 인덱스를 기록한 후, 두 포인터를 모두 왼쪽으로 움직인다.
// 5. 네 스텝을 오른쪽 포인터가 0에 도달할 때까지 반복한다.
// 양 끝의 포인터 사이에 있는 모든 숫자들을 더했을 때 k 보다 작은 경우 오른쪽 포인터를 늘리고,
  int[] sequence;

  public int sum(int startIdx, int endIdx) {
    int sum = 0;
    for (int i = startIdx; i <= endIdx; i++) {
      sum += sequence[i];
    }
    return sum;
  }

  public int[] partialSequence(int k) {
    int rightPtr = sequence.length - 1;
    int leftPtr = sequence.length - 1;

    int partition = sum(leftPtr, rightPtr);
    int min = 1000000;
    int[] found = new int[2];
    while (rightPtr >= 0 && leftPtr >= 0) {
      if (k < partition) {
        if (rightPtr == leftPtr) {
          partition = sequence[rightPtr - 1];
        } else {
          partition -= sequence[rightPtr];
        }
        rightPtr--;
        if (leftPtr > rightPtr) {
          leftPtr--;
        }
        continue;
      }
      if (k > partition) {
        leftPtr--;
        if (leftPtr >= 0) {
          partition += sequence[leftPtr];
        }
        continue;
      }
      if (rightPtr - leftPtr <= min) {
        min = rightPtr - leftPtr;
        found = new int[]{leftPtr, rightPtr};
      }
      partition -= sequence[rightPtr];
      rightPtr--;
      leftPtr--;
      if (leftPtr >= 0) {
        partition += sequence[leftPtr];
      }
    }
    return found;
  }


  public int[] solution(int[] sequence, int k) {
    int[] answer = {};
    this.sequence = sequence;
    answer = partialSequence(k);
    return answer;
  }
}
