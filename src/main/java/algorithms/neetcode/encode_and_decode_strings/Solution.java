package algorithms.neetcode.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public String encode(List<String> strs) {

    if (strs.isEmpty()) {
      return "empty";
    }

    StringBuilder sb = new StringBuilder();

    strs.stream().forEach(s -> sb.append(s + "\'"));

    System.out.println(sb);

    return sb.toString();
  }

  public List<String> decode(String str) {
    if (str.equals("empty")) {
      return new ArrayList<>();
    }

    String[] original = str.split("\'");
    List<String> originals = new ArrayList<>(Arrays.asList(original));
    if (originals.isEmpty()) {
      originals.add("");
    }
    return originals;
  }
}
