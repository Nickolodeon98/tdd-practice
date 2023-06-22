package algorithms.programmers;

public class P64062_2 {

  public int binSearch(int[] stones, int k) {
    int min = 0;
    int max = Integer.MAX_VALUE;
    int result = 0;
    while (min <= max) {
      int mid = (min + max) / 2;
      if (canCross(stones, mid, k)) {
        min = mid + 1;
        result = mid;
      } else {
        max = mid - 1;
      }
    }
    return result;
  }

  public boolean canCross(int[] stones, int mid, int k) {
    int cnt = 0;
    for (int s : stones) {
      if (s < mid) {
        cnt++;
        if (cnt >= k) {
          return false;
        }
      } else {
        cnt = 0;
      }
    }
    return true;
  }

  public int solution(int[] stones, int k) {
    int answer = 0;
    answer = binSearch(stones, k);
    return answer;
  }

}
