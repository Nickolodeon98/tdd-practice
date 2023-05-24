package algorithms.programmers;

import java.util.*;

public class P67258 {

  public int[] findRange(String[] gems) {
    List<String> stones = new ArrayList<>();
    for (String gem : gems) {
      stones.add(gem);
    }
    int startPtr = 0;
    int endPtr = gems.length - 1;
    int ptr = 0;

    while (startPtr < endPtr) {
      if (stones.subList(startPtr, endPtr).contains(stones.get(endPtr))) {
        endPtr--;
      } else {
        if (stones.subList(startPtr + 1, endPtr + 1).contains(stones.get(startPtr))) {
          startPtr++;
        } else {
          break;
        }
      }
    }

    int[] range = new int[2];
    range[0] = startPtr + 1;
    range[1] = endPtr + 1;
    return range;
  }

  public int[] solution(String[] gems) {
    int[] answer = findRange(gems);
    return answer;
  }
}
