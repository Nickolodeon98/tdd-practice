package algorithms.programmers;

import java.util.Arrays;

/* 테스트 1 〉	통과 (1.69ms, 72.3MB)
 * 테스트 2 〉	통과 (2.32ms, 80MB)
 * 테스트 3 〉	통과 (0.31ms, 76.3MB)
 * 테스트 4 〉	통과 (2.56ms, 77.2MB)
 * 테스트 5 〉	통과 (1.03ms, 73.1MB)
 * 테스트 6 〉	통과 (2.42ms, 82.2MB)
 * 테스트 7 〉	통과 (1.03ms, 74.7MB)
 * 테스트 8 〉	통과 (0.61ms, 75.9MB)
 * */
public class P17681WithNestedForLoop {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        /* 1. 각 원소를 이진수로 변환 */
        String[] binaryArr1 = new String[n];
        String[] binaryArr2 = new String[n];
        for (int i = 0; i < n; i++) {
            binaryArr1[i] = toBinaryNumberString(arr1[i], n);
            binaryArr2[i] = toBinaryNumberString(arr2[i], n);
        }

        /* 2. 배열에 넣을 문자열 구성 */
        String secretCode = "";
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (binaryArr1[j].charAt(k) == '1' || binaryArr2[j].charAt(k) == '1')
                    secretCode = String.join("", secretCode, "#");
                else secretCode = String.join("", secretCode, " ");
            }
            answer[j] = secretCode;
            secretCode = "";
        }
        System.out.println(Arrays.toString(answer));
        return answer;
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
        P17681WithNestedForLoop p17681WithNestedForLoop = new P17681WithNestedForLoop();
        int[] testArr1 = {46, 33, 33 ,22, 31, 50};
        int[] testArr2 = {27 ,56, 19, 14, 14, 10};
        String[] ans = p17681WithNestedForLoop.solution(6, testArr1, testArr2);
    }
}
