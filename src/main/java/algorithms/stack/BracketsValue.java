package algorithms.stack;

import java.util.Stack;

public class BracketsValue {
    public int bracketsCheck(String bracketStr) {
        Stack<String> bracketSet = new Stack<>();
        int i = 0;
        while (i < bracketStr.length()) {
            bracketSet.add(Character.toString(bracketStr.charAt(i)));
            i++;
        }
        int resultValue = 0;
        String top = "";
        top = bracketSet.pop();
        if (top.equals("(") || top.equals("[")) {
            return 0;
        } else {
            while (!bracketSet.empty()) {
                if (top.equals(")")) {
                    resultValue += 2;
                    if ((top = bracketSet.pop()).equals("(")) top = bracketSet.pop();
                }
                else if (top.equals("]")) resultValue += 3;
//                else if (top.equals)
            }
        }

        if (bracketStr.equals("()")) {
            return 2;
        }
        if (bracketStr.equals("[]")) {
            return 3;
        }
        return 0; // if not correct
    }
}
