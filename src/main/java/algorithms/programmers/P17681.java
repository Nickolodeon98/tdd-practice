package algorithms.programmers;

public class P17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        /* 1. 각 원소를 이진수로 변환 */
        String binary1 = "";
        String binary2 = "";
        String[] binaryArr1 = new String[n];
        String[] binaryArr2 = new String[n];
        for (int i = 0; i < n; i++) {
            binaryArr1[i] = Integer.toBinaryString(arr1[i]);
            binaryArr2[i] = Integer.toBinaryString(arr2[i]);
        }

        /* 2. 배열에 넣을 문자열 구성 */
        String secretCode = "";
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < binaryArr1[j].length(); k++) {
                if (binaryArr1[j].charAt(k) == '1' || binaryArr2[j].charAt(k) == '1')
                    secretCode = String.join("", secretCode, "#");
            }
        }

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
        System.out.println(p17681.toBinaryNumberString(39));
    }
}
