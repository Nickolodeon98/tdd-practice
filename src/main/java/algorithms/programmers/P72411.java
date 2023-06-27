package algorithms.programmers;

import java.util.*;

public class P72411 {

  // 문자열을 돌면서 연속해서 중복되는 경우가 얼마나 있는지 확인하고,
// 이를 각 문자열 별로 반복하여 수행한다.
// 단품메뉴 조합을 확인한다.
// 메뉴 구성에 따라 다른 조합을 만들어낸다.
// 우선 모든 사용된 문자들을 HashSet 에 넣어서 무슨 문자들이 있는지 확인한다.
// 이후 course 에 적힌 숫자에 따라 여러 개 조합의 경우의 수를 생각해본다.
// 만든 조합이 실제로 몇몇 orders 에 속하는지 파악한다.
// 만약 orders 내에 있다면 확인 가능한 방법은 orders 내에서 문자들을 매칭해보는 방법이 있다.
// 예) 모든 문자열들을 돌면서 바꿀 수 있도록 한다.
// 만약 "AC" 가 "ABCFG" 에 포함됨을 확인하려면 "A" && "C" 포함 여부를 확인하면 된다.
  public void nominees(String[] orders, int[] course) {
    List<Character> letters = new ArrayList<>();
    for (String order : orders) {
      for (char letter : order.toCharArray()) {
        if (letters.contains(letter)) {
          continue;
        }
        letters.add(letter);
      }
    }
    visited = new boolean[letters.size()];

    for (int len : course) {
      DFS(' ', "", letters, len);
    }

  }

  boolean[] visited;
  List<String> comb;

  public void DFS(char start, String current, List<Character> letters, int goal) {

    if (current.length() == goal) {

      comb.add(current);
      return;
    }

    for (int i = 0; i < letters.size(); i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      DFS((char) letters.get(i), current + letters.get(i), letters, goal);
      visited[i] = false;
    }
  }

  public boolean isSame(String a, String b) {
    char[] aLs = a.toCharArray();
    char[] bLs = b.toCharArray();

    Arrays.sort(aLs);
    Arrays.sort(bLs);

    for (int m = 0; m < aLs.length; m++) {
      if (aLs[m] != bLs[m]) {
        return false;
      }
    }
    return true;
  }

  public List<String> solution(String[] orders, int[] course) {
    comb = new ArrayList<>();
    nominees(orders, course);

    Map<String, Integer> cousine = new HashMap<>();
    List<String> temp = new ArrayList<>();

    StringBuilder tmp = new StringBuilder();

    for (String o : orders) {
      for (String single : comb) {
        if (single.length() >= 2) {
          for (int i = 0; i < single.length(); i++) {
            if (!o.contains(String.valueOf(single.charAt(i)))) {
              tmp.setLength(0);
              break;
            }
            tmp.append(single.charAt(i));
          }
          if (tmp.length() != 0) {
            temp.add(tmp.toString());
            tmp.setLength(0);
          }
          for (String t : temp) {
            cousine.put(t, cousine.getOrDefault(t, 0) + 1);
          }
          temp.clear();
        }
      }
    }
    int[] info = new int[course[course.length - 1] + 1];
    List<String> extra = new ArrayList<>();

    for (Map.Entry<String, Integer> co : cousine.entrySet()) {
      if (co.getValue() > 1) {
        for (int num : course) {
          if (co.getKey().length() == num) {
            if (co.getValue() > info[num]) {
              info[num] = co.getValue();
            }
          }
        }
      }
    }

    for (Map.Entry<String, Integer> co : cousine.entrySet()) {
      if (co.getValue() > 1) {
        for (int num : course) {
          if (co.getKey().length() == num) {
            if (co.getValue() == info[num]) {
              extra.add(co.getKey());
            }
          }
        }
      }
    }

    Collections.sort(extra);

    List<String> result = new ArrayList<>();
    for (int k = 0; k < extra.size(); k++) {
      for (int l = k + 1; l < extra.size(); l++) {
        if (extra.get(k).length() == extra.get(l).length()) {
          if (isSame(extra.get(k), extra.get(l))) {
            // result.add(extra.get(k));
            extra.set(l, "");
          }
        }
      }
    }
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < extra.size(); i++) {
      if (!extra.get(i).equals("")) {
        answer.add(extra.get(i));
      }
    }
    return answer;
  }


}
