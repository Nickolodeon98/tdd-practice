package algorithms.programmers;

public class RE_RE_P60057 {

  public int solution(String s) {
    int answer = s.length();
    int cnt = 1;
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= s.length() / 2; i++) {
      String target = s.substring(0, i);
      for (int start = i; start <= s.length(); start += i) {
        String cur = "";
        if (start + i > s.length()) {
          cur = s.substring(start, s.length());
        } else {
          cur = s.substring(start, start + i);
        }

        if (cur.equals(target)) {
          cnt++;
        } else {
          if (cnt == 1) {
            sb.append(target);
          } else {
            sb.append(cnt).append(target);
          }
          target = cur;
          cnt = 1;
        }
      }
      sb.append(target);
      System.out.println(sb + " " + target);
      answer = Math.min(answer, sb.length());
      sb.setLength(0);
    }

    return answer;
  }

}
