package algorithms.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P42862 {

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    Arrays.sort(lost);
    Arrays.sort(reserve);

    List<Integer> lostOnes = Arrays.stream(lost).mapToObj(i -> i).collect(Collectors.toList());
    List<Integer> extraOnes = Arrays.stream(reserve).mapToObj(i -> i).collect(Collectors.toList());

    lostOnes.retainAll(extraOnes);

    int subtracted = lostOnes.size(); // 겹치는 원소의 개수
    answer += subtracted;

    /* reserve 배열에 있는 학생들의 번호에서 1을 빼고 더한 값들을 배열로 만든다. */
    int i = 0;
    int j = 0;
    while (i < reserve.length && j < lost.length) {
      if (lostOnes.contains(lost[j])) {
        j++;
        continue;
      }
      if (lostOnes.contains(reserve[i])) {
        i++;
        continue;
      }
      if (Math.abs(reserve[i] - lost[j]) == 1) {
        i++;
        j++;
        answer++;
        continue;
      }
      if (lost[j] >= reserve[i]) {
        i++;
        continue;
      }
      j++;
    }

    return answer;
  }
//     int hint(Map<Integer, Boolean> map) {
//         int count = 0;

//         for (Integer key: map.keySet()) {
//             if (map.get(key) == true) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public int solution(int n, int[] lost, int[] reserve) {
//         int answer = 0;

//         Arrays.sort(lost);
//         Arrays.sort(reserve);

//         ArrayList<Integer> arr = new ArrayList<Integer>();
//         List<Integer> lostArr = new ArrayList<Integer>();

//         for (int i = 0; i < lost.length; ++i) {
//             lostArr.add(lost[i]);
//         }

//         Map<Integer, Boolean> reserveMap = new HashMap<Integer, Boolean>();

//         for (int rent : reserve) {
//             reserveMap.put(rent, true);
//         }

//         for (int j = 0; j < reserve.length; j++) {
//             if (lostArr.contains(reserve[j])) {
//                 lostArr.remove(lostArr.indexOf(reserve[j]));
//                 reserveMap.put(reserve[j], false);
//             }
//         }

//         for (int idx = 0; idx < lostArr.size(); idx++) {
//             if (!arr.contains(lostArr.get(idx)-1)) {
//                 arr.add(lostArr.get(idx)-1);
//             }
//             if (!arr.contains(lostArr.get(idx)+1)) {
//                 arr.add(lostArr.get(idx)+1);
//             }
//         }

//         System.out.println(arr);

//         for (int elem = 0; elem < reserve.length; elem++) {
//             if (lostArr.isEmpty()) {
//                 break;
//             }
//             if (arr.contains(reserve[elem])) {
//                 if (reserveMap.get(reserve[elem]) == false) { // if already rented
//                     continue;
//                 }
//                 if (lostArr.contains(reserve[elem] - 1)) {
//                     lostArr.remove(lostArr.indexOf(reserve[elem] - 1));
//                 } else if (lostArr.contains(reserve[elem] + 1)) {
//                     lostArr.remove(lostArr.indexOf(reserve[elem] + 1));
//                 }
//                 reserveMap.put(reserve[elem], false);
//                 arr.remove(arr.indexOf(reserve[elem]));
//             }
//         }

//         System.out.println(hint(reserveMap));

//         // mistake: the count for the number of students who have extra uniform but lost
//         // one was not considered.

//         answer = n - lostArr.size();

//         return answer;
//     }

}
