package algorithms.programmers;

import java.util.Arrays;
import java.util.function.Predicate;

public class P17681 {
    interface CharComparison extends Predicate<Character> {

    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int INITIAL_INDEX = 0;
        String[] answer = new String[n];

        return recursiveGridBuilder(n, arr1, arr2, INITIAL_INDEX, answer);
    }

    public String[] recursiveGridBuilder(int n, int[] arr1, int[] arr2, int current, String[] answer) {
        /* 배열에 넣을 문자열 구성 */
        String secretCode = "";
        if (current == n) return answer;
        Predicate<Character> equalsOne = (ch) -> ch == '1';
        /* 현재 가리키고 있는 인덱스의 원소를 2진수로 변환 */
        String binaryNum = toBinaryNumberString(arr1[current] | arr2[current], n);
        secretCode = binaryNum.replaceAll("1", "#");
        secretCode = secretCode.replaceAll("0", " ");
//            if (equalsOne.test(binaryNum.charAt(k)))
//                secretCode = String.join("", secretCode, "#");
//            else secretCode = String.join("", secretCode, " ");
        answer[current] = secretCode;

        /* 재귀 호출 */
        return recursiveGridBuilder(n, arr1, arr2, ++current, answer);
    }

    public String toBinaryNumberString(int decimalNum, int n) {
        String binary = "";
        while (decimalNum > 1) {
            binary = String.join("", Integer.toString(decimalNum % 2), binary);
            decimalNum /= 2;
        }
        binary = String.join("", String.valueOf(decimalNum % 2), binary);

        while (binary.length() < n)
            binary = String.join("", "0", binary);

        return binary;
    }

    public static void main(String[] args) {
        P17681 p17681 = new P17681();
        int[] testArr1 = {46, 33, 33, 22, 31, 50};
        int[] testArr2 = {27, 56, 19, 14, 14, 10};
        String[] ans = p17681.solution(6, testArr1, testArr2);

        System.out.println(Arrays.toString(ans));
    }
}
