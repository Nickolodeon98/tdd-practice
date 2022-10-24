package algorithms.stack;

import java.util.Stack;


/*다른 방식으로 풀 때는 순회를 한 번만 하는 것이 아니라 replace 를 하거나
* split 을 하기 위해 모든 괄호를 찾는 동안 한 번,
* 찾아서 남은 문자열에 대해 또 각 순회당 한 번씩 돌기 때문에 N^2 만큼의 연산을 한다.
* 스택을 사용하면 조건에 따라 push 와 pop 만 해주면 되기 때문에 N 만큼의 연산을 한다.*/
public class BracketTest {
    public Boolean correctBrackets(String s) {
        Stack<Character> bracketSet = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
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
