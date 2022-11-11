package algorithms.programmers;

import java.util.Arrays;

public class P17681 {
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
        P17681 p17681 = new P17681();
        int[] testArr1 = {46, 33, 33 ,22, 31, 50};
        int[] testArr2 = {27 ,56, 19, 14, 14, 10};
        p17681.solution(6, testArr1, testArr2);
    }
}
