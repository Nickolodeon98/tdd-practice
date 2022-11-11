package algorithms.programmers;

import java.util.Arrays;

public class P17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        /* 1. 각 원소를 이진수로 변환 */
        String[] binaryArr1 = new String[n];
        String[] binaryArr2 = new String[n];
        for (int i = 0; i < n; i++) {
            binaryArr1[i] = toBinaryNumberString(arr1[i]);
            binaryArr2[i] = toBinaryNumberString(arr2[i]);
        }

        /* 2. 배열에 넣을 문자열 구성 */
        String secretCode = "";
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < binaryArr1[j].length(); k++) {
                if (binaryArr1[j].charAt(k) == '1')
                    secretCode = String.join("", secretCode, "#");
                else secretCode = String.join("", secretCode, " ");
            }
            for (int l = 0; l < binaryArr2[j].length(); l++) {
                if (binaryArr2[j].charAt(l) == '1')
                    secretCode = String.join("", secretCode, "#");
                else secretCode = String.join("", secretCode, " ");
            }
            answer[j] = secretCode;
            secretCode = "";
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public String toBinaryNumberString(int decimalNum) {
        String binary = "";
        while (decimalNum > 1) {
            binary = String.join("", Integer.toString(decimalNum % 2), binary);
            decimalNum /= 2;
        }
        binary = String.join("", String.valueOf(decimalNum % 2), binary);
        return binary;
    }

    public static void main(String[] args) {
        P17681 p17681 = new P17681();
        System.out.println(p17681.toBinaryNumberString(28));
        int[] testArr1 = {9, 20, 28, 18, 11};
        int[] testArr2 = {30, 1, 21, 17, 28};

        p17681.solution(5, testArr1, testArr2);
    }
}
