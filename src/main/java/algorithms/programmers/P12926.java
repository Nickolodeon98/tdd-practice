package algorithms.programmers;

public class P12926 {
    /* 우선 하나의 문자가 주어졌을 때 밀 수 있는 알고리즘을 구현한다. */
    public char pullBehind(char c, int n) {
        if (c == ' ') return c;
        int pulled = c + n;
        if (Character.isLowerCase(c)) {
            if (pulled > 122) pulled -= 26;
            return (char) pulled;
        }
        if (pulled > 90) pulled -= 26;
        return (char) pulled;
    }

    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(pullBehind(s.charAt(i), n));
        }
        answer = sb.toString();

        return answer;
    }
}
