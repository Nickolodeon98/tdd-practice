package algorithms.leetcode.regex;

class RegexMatching {
  public boolean isMatch(String s, String p) {
    int ptrS = 0;
    int ptrP = 0;
    boolean anything = false;
    char allowed = ' ';
    boolean exceeded = false;

    while (ptrS < s.length()) {
      if (!anything) {
        if (s.charAt(ptrS) == p.charAt(ptrP) && !exceeded) {
          ptrS++;
          ptrP++;
          if (ptrP < p.length() && p.charAt(ptrP) == '*') {
            anything = true;
            allowed = p.charAt(ptrP-1);
          }
          if (ptrP >= p.length() && ptrS < s.length()) {
            ptrP--;
            exceeded = true;
          }
        } else if (p.charAt(ptrP) == '.') {
          ptrP++;
          ptrS++;
          if (ptrP < p.length() && p.charAt(ptrP) == '*') {
            System.out.println("here3");
            if (ptrP < p.length()-1) ptrP++;
            else if (ptrP == p.length()-1) return true;
          }
          if (ptrP >= p.length() && ptrS < s.length()) {
            System.out.println("arrived2");
            return false;
            // ptrP--;
          }
        } else if (s.charAt(ptrS) != p.charAt(ptrP) && ptrP + 1 < p.length()
            && p.charAt(ptrP + 1) == '*') {
          System.out.println("here5");
          ptrP += 2;
          if (ptrP >= p.length()) return false;
        } else {
          System.out.println("here2");
          return false;
        }
      } else {
        while (ptrS < s.length() && s.charAt(ptrS) == allowed) {
          if (ptrP >= p.length() && s.charAt(ptrS) != allowed) {
            System.out.println("here1");
            return false;
          }
          ptrS++;
          ptrP++;
        }
        anything = false;
      }
    }
    if (ptrP < p.length()) return false;
    System.out.println("here4");
    return true;
  }
}
