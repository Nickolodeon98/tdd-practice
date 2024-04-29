package algorithms.programmers;

import java.util.*;

public class P42862_2 {

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    int[] record = new int[n + 1]; // 여벌이 있는데 잃어버린 학생들 저장 배열
    Set<Integer> everyone = new TreeSet<>();
    Set<Integer> availables = new TreeSet<>();
    Set<Integer> reserved = new TreeSet<>();

    Arrays.stream(lost).forEach(i -> {
      availables.add(i);
      everyone.add(i);
    }); // 먼저 잃어버린 체육복의 목록을 저장한다.

    System.out.println("잃어버린 체육복 목록: " + availables);

    Arrays.stream(reserve).forEach(i -> {
      reserved.add(i);
      everyone.add(i);
    }); // 여벌 옷이 있는 학생들을 저장한다.

    System.out.println("여벌 옷이 있는 학생들 목록: " + reserved);
    System.out.println("여벌옷 + 잃어버린: " + everyone);

    Set<Integer> remained = new TreeSet<>(reserved);

    /* 여벌 옷이 있더라도 본인이 하나를 도난당하면 하나밖에 없어서 못빌려준다.*/

    reserved.retainAll(availables); // 겹치는 것이 있는가? 있으면 reserved 에 넣는다.

    for (int r : reserved) {
      record[r] = 1;
    }
    System.out.println("여벌 옷이 있으나 하나 도난당한 학생들 목록: " + reserved);

    int counts = lost.length; // 현재 잃어버린 체육복 개수
    System.out.println("잃어버린 개수: " + counts);
    int remains = reserve.length - reserved.size(); // 여벌 체육복의 개수
    System.out.println("(진짜) 여벌 체육복 개수: " + remains);

    int count = 0;
    for (int i = 1; i < record.length; i++) {
      if (record[i] == 1) {
        remained.remove(i);
        availables.remove(i);
        count++;
      }
    }

    // 여벌 옷이 있는 학생들이 체육복을 잃어버린 학생들에게 빌려준다면, 여벌 옷이 더이상 없으므로 여벌 옷에서 삭제한다.
    // 잃어버린 옷도 해결되어서 사라진다.
    remained.forEach(i -> {
          // 여벌이 있으나 도난당한 인원이 아니면, 빌려준다.
          if (record[i] != 1 && availables.remove(i - 1) == true) {
            System.out.println("지웁니다: " + i);
            record[i] = 1;
          }
        }
    );

    System.out.println("count : " + count);

    System.out.println("뒷 사람들한테 빌려주니까 남은 옷들 목록: " + remained);

    // 다시 한 번, 잃어버린 체육복에서 현재 여벌 옷으로부터 빌릴 수 있는지 확인해본다.
    // 빌렸으면, availables 에는 잃어버린 옷들이 매우 적어지게 된다.

    remained.stream().forEach(i -> {
      if (record[i] != 1) {
        availables.remove(i + 1);
      }
    });
    // 가장 처음에 잃어버린 옷들의 개수에서 얼마나 빠졌는지 확인한다
    int diff = (int) Math.abs(counts - (availables.size() + count));

    System.out.println(
        "옷을 빌린 학생 수 = " + counts + " - " + (availables.size() + count) + " = " + diff);

    // 빠진 만큼은 체육복이 생긴 것이므로
    // (현재) 여벌 체육복 개수 + 체육복이 생긴 사람 수 + 원래 있던 사람의 수를 합치면 결과값이다.
    answer = remained.size() + diff + (n - everyone.size()) + count;

    System.out.println("찐으로 남은 여벌 옷이 있는 학생들 수 (" + remained.size() + ") + 옷을 빌린 학생 수 (" + diff
        + ") + 여벌 옷이 있지도 않고 옷을 빌리지도 않은 평범한 학생들 수 (" + (n - everyone.size())
        + ") + 여벌 옷이 있었으나 빌려줄 여력이 없었던 학생 수 (" + reserved.size() + ") = " + answer);
    return answer;
  }
}
