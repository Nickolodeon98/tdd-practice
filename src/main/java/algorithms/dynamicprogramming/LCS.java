package algorithms.dynamicprogramming;

public class LCS {
    public String longestSubSequence() {
        String str1 = "ABCDCBA";
        String str2 = "DCABDC";

        /* 먼저 둘 중에 어떤 문자열을 기준으로 비교를 진행할지 선택한다.
         * 기준이 되는 문자열이 배열 안에 중첩되어서 들어가야 한다. 다른 문자열은 바깥에 들어가야 한다.
         * str1 을 기준으로 배열을 생성해보자. */

        int[][] map = new int[str2.length()][str1.length()];

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                System.out.printf("%s, %s\n", str2.charAt(i), str1.charAt(j));
            }
        }
        return "";
    }

}
