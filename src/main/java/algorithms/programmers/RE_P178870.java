package algorithms.programmers;

public class RE_P178870 {
  public int[] solution(int[] sequence, int k) {
    int size = sequence.length;
    int sum = sequence[0];
    int left = 0;
    int right = 0;
    int len = Integer.MAX_VALUE;
    int leftAns = 0;
    int rightAns = 0;

    while (right < size && left <= right) {
      if (sum == k) {
        if (len > right - left) {
          len = right - left;
          leftAns = left;
          rightAns = right;
        }
        right++;
        if (right < size) {
          sum += sequence[right];
        }
      } else if (sum < k) {
        right++;
        if (right < size) {
          sum += sequence[right];
        }
      } else if (sum > k) {
        sum -= sequence[left];
        left++;
      }
    }

    return new int[]{leftAns, rightAns};
  }

}
