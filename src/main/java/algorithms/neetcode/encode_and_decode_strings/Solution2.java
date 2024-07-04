package algorithms.neetcode.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    strs.stream().forEach(s -> {
          sb.append(s.length());
          sb.append("#");
          sb.append(s);
        }
    );

    System.out.println(sb);

    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int count = 0;
    String s = "";
    int wordLen = 0;
    while (count < str.length()) {
      if (str.charAt(count) == '#') {
        wordLen = Integer.parseInt(s);
        result.add(str.substring(++count, count + wordLen));
        count+=wordLen;
        s = "";
        wordLen = 0;
        continue;
      }
      s += str.charAt(count);
      count++;
    }
    return result;
  }
}

