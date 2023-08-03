package algorithms.programmers;

public class RE_P60057 {
    public int solution(String s) {
      int answer = 0;
      int max = 0;
      String repeated = "";
      String cur = "";
      int cnt = 0;
      StringBuilder sb = new StringBuilder();
      int length = 0;
      String prev = "";

      for (int i = 0; i < s.length(); ) {
        for (int j = 1; i+j <= s.length(); j++) {
          int start = i;
          int dest = i + j;
          cur = s.substring(start, dest);
          while (dest + j <= s.length() && cur.equals(s.substring(start + j, dest + j))) {
            start += j;
            dest += j;
            if (cur.length() > max) {
              repeated = cur;
              max = cur.length();
              cnt = 1;
            }
            cnt++;
          }
        }
        if (repeated.length() == 0 || cnt == 0) {
          sb.append(s.charAt(i));
          i++;
        }
        else {
          if (sb.length() > 0 && prev.length() != repeated.length())
            for (int a = 0; a < cnt; a++) {
              prev = repeated;
              sb.append(repeated);
            }
          else {
            sb.append(cnt);
            sb.append(repeated);
            prev = repeated;
          }
          i += repeated.length() * cnt;
        }
        cnt = 0;
        max = 0;
        repeated = "";
      }


      answer= sb.length();
      return answer;
    }

}
