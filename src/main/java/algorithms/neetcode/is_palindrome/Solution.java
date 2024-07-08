package algorithms.neetcode.is_palindrome;

class Solution {
  public boolean isPalindrome(String s) {
    String lowered = s.toLowerCase();
    lowered = lowered.replaceAll(" ", "");
    lowered = lowered.replaceAll("[^a-zA-Z0-9]", "");

    StringBuilder r = new StringBuilder();
    String[] reversed = lowered.split("");

    for (int i = reversed.length-1; i >= 0; i--) {
      r.append(reversed[i]);
    }
    return lowered.equals(r.toString());
  }
}

