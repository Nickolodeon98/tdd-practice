package algorithms.programmers;

import java.util.*;

public class P176963 {
// 7분 가량 소요

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    Map<String, Integer> info = new HashMap<>();

    for (int i = 0; i < name.length; i++) {
      info.put(name[i], yearning[i]);
    }
    int sum = 0;
    int[] answer = new int[photo.length];
    for (int j = 0; j < photo.length; j++) {
      for (String n : photo[j]) {
        sum += info.getOrDefault(n, 0);
      }
      answer[j] = sum;
      sum = 0;
    }
    return answer;
  }
}
