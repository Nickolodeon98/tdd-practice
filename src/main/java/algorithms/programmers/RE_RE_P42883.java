package algorithms.programmers;

public class RE_RE_P42883 {

  int len;
  String num;
  StringBuilder sb = new StringBuilder();

  public String solution(String number, int k) {
    String answer = "";
    len = number.length() - k;
    num = number;

    repeated(0, 0);

    answer = sb.toString();
    return answer;
  }

  public void repeated(int idx, int n) {
    if (sb.length() >= len) {
      return;
    }

    int max = Integer.MIN_VALUE;
    for (int i = idx + 1; i < num.length(); i++) {
      if (max < num.charAt(i) - '0') {
        if (num.length() - i < len - n) {
          continue;
        }
        max = num.charAt(i) - '0';
        idx = i;
      }
    }

    sb.append(max);
    repeated(idx, n + 1);
  }
}
