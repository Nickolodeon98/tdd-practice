package algorithms.neetcode.valid_parentheses;

import java.util.Stack;

public class Solution {

  public boolean isValid(String s) {
    if (s.length() % 2 == 1) {
      return false;
    }
    // '(', ')', '}'
    Stack<Character> brackets = new Stack<>();
    Stack<Character> bracketsDiff = new Stack<>();

    for (int i = 0; i < s.length() / 2; i++) {
      brackets.push(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder();

    while (!brackets.isEmpty()) {
      Character bracket = brackets.pop();
      switch (bracket) {
        case '{':
          sb = sb.append('}');
          break;
        case '[':
          sb = sb.append(']');
          break;
        case '(':
          sb = sb.append(')');
          break;
        default:
          break;
      }
    }

    String sub = s.substring(s.length() / 2, s.length());

    if (sb.toString().equals(sub)) {
      return true;
    }

    for (int i = 0; i < s.length(); i++) {
      bracketsDiff.push(s.charAt(i));
    }

    while (!bracketsDiff.isEmpty()) {
      Character bracket = bracketsDiff.pop();
      System.out.println(bracket);
      switch (bracket) {
        case '}':
          if (bracketsDiff.isEmpty()) {
            return false;
          }
          if (bracketsDiff.peek() == '{') {
            bracketsDiff.pop();
          } else {
            return false;
          }
          break;
        case ']':
          if (bracketsDiff.isEmpty()) {
            return false;
          }
          if (bracketsDiff.peek() == '[') {
            bracketsDiff.pop();
          } else {
            return false;
          }
          break;
        case ')':
          if (bracketsDiff.isEmpty()) {
            return false;
          }
          if (bracketsDiff.peek() == '(') {
            bracketsDiff.pop();
          } else {
            return false;
          }
          break;
        default:
          return false;
      }
    }

    return true;
  }
}

