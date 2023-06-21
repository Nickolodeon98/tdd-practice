package algorithms.programmers;

public class P87946 {

  //     게임의 피로도 시스템
//     일정 피로도가 소모됨
//     최소 필요 피로도
//     소모 피로도
//     최대한 많이 탐험
//     현재 피로도 k 와 최소 피로도,
//     소모 피로도가 담긴 dungeons
  static class User {

    int blood;
    int counter;

    User(int blood) {
      this.blood = blood;
      this.counter = 0;
    }

    void consume(int consumed) {
      this.blood -= consumed;
      this.counter++;
    }

    void setBlood(int blood) {
      this.blood = blood;
    }

    int getBlood() {
      return this.blood;
    }

    int getCounter() {
      return this.counter;
    }
  }

  int[][] dungeons;
  boolean[] visited;
  int counter = 0;

  public void init(int cnt, User user, int blood) {
    User tempUser = new User(user.getBlood());
    for (int i = 0; i < dungeons.length; i++) {
      if (visited[i] || dungeons[i][0] > blood) {
        continue;
      }
      visited[i] = true;
      init(cnt + 1, tempUser, blood - dungeons[i][1]);
      visited[i] = false;
      tempUser = user;
    }
    counter = Math.max(counter, cnt);
  }

  public int solution(int k, int[][] dungeons) {
    int answer = -1;
    visited = new boolean[dungeons.length];
    this.dungeons = dungeons;
    User user = new User(k);

    init(0, user, k);
    answer = counter;

    return answer;
  }

}
