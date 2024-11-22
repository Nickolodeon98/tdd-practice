package algorithms.neetcode.longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int characterReplacement(String s, int k) {
    // Map 에 key 는 알파벳으로, value 는 개수로 넣은 후 value 로 내림차순
    Map<String, Integer> count = new HashMap<>();
    int start = 0;
    int end = s.length() - 1;

    // 문자열의 시작 부분이 끝 부분과 다르다면, end -= 1 을 한다.
    while (s.charAt(start) != s.charAt(end) && end > 0) {
      end--;
    }

    // 현재 두 문자의 값을 하나의 변수 letter 에 저장한다.
    char letter = s.charAt(end);
    System.out.println("letter: " + letter);

    // 문자열과 시작과 끝 부분이 같아진다면, substring 으로 자른다. end 는 기억해둔다.
    String sub = s.substring(start, end+1);
    System.out.println("sub: " + sub);
    int tempStart = start;
    // start++; 한다.
    while (k > 0 && start < sub.length()) {
      // k > 0 이라면, letter 로 바꿔치기 한다.
      if (sub.charAt(start) != letter) {
        sub.replace(String.valueOf(sub.charAt(start)), String.valueOf(letter));
        k--;
      }
      start++;
    }
    System.out.println("k: " + k);
    System.out.println("start: " + start);
    // System.out.println("result: " + sub.substring(tempStart, start+1));
    // k = 0 이라면, 현재 start++ 후 ~ end 까지 문자열을 저장
    return start == sub.length() ? sub.substring(tempStart, start).length() : sub.substring(tempStart, start+1).length();
  }
}
