package algorithms.neetcode.anagram_groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<String> candidates = new ArrayList<>();
    int i = 0;
    for (String s : strs) {
      String[] word = s.split("");
      StringBuilder sb = new StringBuilder();
      sb.append(i++);
      sb.append("= ");
      Arrays.sort(word);
      Arrays.stream(word).forEach(l -> sb.append(l));
      candidates.add(sb.toString());
    }

    return findAnagrams(strs, candidates);
  }

  public List<List<String>> findAnagrams(String[] strs, List<String> words) {
    Set<List<String>> temp = new HashSet<>();
    for (String word : words) {
      temp.add
          (words.stream()
              .filter(e -> e.split("=")[1].equals(word.split("=")[1]))
              .collect(Collectors.toList())
          );
    }

    System.out.println(temp);

    List<List<String>> anagrams = new ArrayList<>();

    for (List<String> collection : temp) {
      List<String> subAnagrams = new ArrayList<>();
      for (String elem : collection) {
        subAnagrams.add(strs[Integer.parseInt(elem.split("=")[0])]);
      }
      anagrams.add(subAnagrams);
    }

    return anagrams;
  }

}
