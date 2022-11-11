package algorithms.programmers;

import java.util.Arrays;




public class P17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int INITIAL_INDEX = 0;
        String[] answer = new String[n];

        return recursiveGridBuilder(n, arr1, arr2, INITIAL_INDEX, answer);
    }

    public String[] recursiveGridBuilder(int n, int[] arr1, int[] arr2, int current, String[] answer) {
        /* 배열에 넣을 문자열 구성 */
        String secretCode = "";
        if (current == n) return answer;

        for (int k = 0; k < n; k++) {
            /* 현재 가리키고 있는 인덱스의 원소를 2진수로 변환 */
            if (toBinaryNumberString(arr1[current], n).charAt(k) == '1' || toBinaryNumberString(arr2[current], n).charAt(k) == '1')
                secretCode = String.join("", secretCode, "#");
            else secretCode = String.join("", secretCode, " ");
        }
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
        int[] testArr1 = {46, 33, 33 ,22, 31, 50};
        int[] testArr2 = {27 ,56, 19, 14, 14, 10};
        String[] ans = p17681.solution(6, testArr1, testArr2);

        System.out.println(Arrays.toString(ans));
    }
}
