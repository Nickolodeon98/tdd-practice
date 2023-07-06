package algorithms.programmers;

public class P161989 {

  public int solution(int n, int m, int[] section) {
    int answer = 0;
    int current = 0;
    int cnt = 0;
    for (int i = 0; i < section.length; i++) {
      if (current >= section[i]) {
        continue;
      }
      current = section[i] + m - 1;
      cnt++;
    }
    answer = cnt;
    return answer;
  }

}
