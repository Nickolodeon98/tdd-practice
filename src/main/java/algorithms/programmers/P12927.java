package algorithms.programmers;

public class P12927 {
  // Demi 의 야근
// 야근 피로도 존재
// 야근 시작 시점 + 남은 일의 제곱량
// Demi 가 N시간 일할 때 피로도를 최소화하기 위한 방법을 찾아야 함.
// 1시간에 처리할 수 있는 일의 양 = 1
// n 과 works 가 주어졌을 때, 야근 피로도를 최소화한 값은?
// n 만큼을 뺄 수 있으므로, n을 두고 n 에서 계속 줄여나가야 함.

  public int computeVolume(int[] works) {
    int volume = 0;
    for (int work : works) {
      volume += Math.pow(work, 2);
    }
    return volume;
  }

  // 가장 많이 남은 작업에서 1 줄이는 함수
  public void work(int[] works) {
    int max = 0;

    for (int i = 0; i < works.length; i++) {
      if (works[i] > works[max]) {
        max = i;
      }
    }

    works[max]--;
  }

  public void pro(int n, int[] works) {
    while (n > 0) {
      work(works);
      n--;
    }
  }


  public long solution(int n, int[] works) {
    long answer = 0;

    pro(n, works);
    for (int w : works) {
      answer += Math.pow(w, 2);
    }
    return answer;
  }

}
