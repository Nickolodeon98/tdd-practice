package algorithms.caesar;

public class Caesar {
//    public String solution(String s, int n) {
//        String answer = "";
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        for (int i = 0; i < s.length(); i++) {
//            while (count <= n) {
//                int codedNum = s.charAt(i) + 1;
//                if (codedNum > 122) codedNum -= 25;
//                if (codedNum > 90 && codedNum < 97) codedNum -= 25;
//                char coded = (char) codedNum;
//                sb.append(coded);
//                count++;
//            }
//        }
//        return answer;
//    }

    /* 우선 하나의 문자가 주어졌을 때 밀 수 있는 알고리즘을 구현한다. */
    public char pullBehind(char c, int n) {
        int pulled = c + n;
        if (Character.isLowerCase(c)) {
            if (pulled > 122) pulled -= 26;
            return (char) pulled;
        }
        if (pulled > 90 && pulled < 97) pulled -= 26;
        return (char) pulled;
    }

    public static void main(String[] args) {
        Caesar caesar = new Caesar();

        System.out.println(caesar.pullBehind('z', 3));
    }
}
