package algorithms;

public class BracketTest {
    public Boolean correctBrackets(String s) {
//        System.out.println(s.length());

//        System.out.println(s.indexOf("()"));

        while (s.indexOf("()") > -1) {
            s = s.replace("()", "");
        }
//        System.out.println(s);
//        System.out.println(s.length());

        return s.length() == 0;
    }
}
