package algorithms;

import java.util.Stack;

public class BracketTest {
    public Boolean correctBrackets(String s) {
        Stack<Character> bracketSet = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ')') {
                if (bracketSet.empty()) return false;
                bracketSet.pop();
                i++;
                continue;
            }
            bracketSet.add(s.charAt(i++));
        }

        return bracketSet.empty();
    }
}
