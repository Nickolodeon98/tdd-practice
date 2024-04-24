package algorithms.programmers;

import java.util.*;

public class P42862_2 {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    Set<Integer> everyone = new HashSet<>();
    Set<Integer> availables = new HashSet<>();
    Set<Integer> reserved = new HashSet<>();

    Arrays.stream(lost).forEach(i -> {
      availables.add(i);
      everyone.add(i);
    }); // 먼저 잃어버린 체육복의 목록을 저장한다.
    Arrays.stream(reserve).forEach(i -> {
      reserved.add(i);
      everyone.add(i);
    }); // 여벌 옷이 있는 학생들을 저장한다.

    Set<Integer> reserved2 = new HashSet<>(reserved);
    System.out.println(reserved);
    reserved.retainAll(availables);
    reserved2.retainAll(reserved);
    System.out.println(reserved2);

    System.out.println(availables);
    availables.retainAll(reserved2);
    System.out.println(availables);

    int counts = lost.length;

    int remains = reserve.length;

    // 여벌 옷이 있는 학생들이 체육복을 잃어버린 학생들에게 빌려준다면, 여벌 옷이 더이상 없으므로 여벌 옷에서 삭제한다.
    // 잃어버린 옷도 해결되어서 사라진다.
    Arrays.stream(reserve).forEach(i -> {
          if (availables.remove(i - 1) == true) {
            reserved.remove(i);
          }
        }
    );

    // 다시 한 번, 잃어버린 체육복에서 현재 여벌 옷으로부터 빌릴 수 있는지 확인해본다.
    // 빌렸으면, availables 에는 잃어버린 옷들이 매우 적어지게 된다.
    reserved.stream().forEach(i -> availables.remove(i + 1));
    // 가장 처음에 잃어버린 옷들의 개수에서 얼마나 빠졌는지 확인한다
    int diff = (int) Math.abs(counts - availables.size());

    // 빠진 만큼은 체육복이 생긴 것이므로 체육복이 생긴 사람 + 원래 있던 사람 의 수를 합치면 결과값이다.
    answer = remains + diff + (n - everyone.size());
    return answer;
  }
}