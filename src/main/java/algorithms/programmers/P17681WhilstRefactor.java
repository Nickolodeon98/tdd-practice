package algorithms.programmers;

import java.util.Arrays;

/* 테스트 1 〉	통과 (3.88ms, 77.1MB)
 * 테스트 2 〉	통과 (9.12ms, 79.6MB)
 * 테스트 3 〉	통과 (0.42ms, 72.8MB)
 * 테스트 4 〉	통과 (3.63ms, 76.4MB)
 * 테스트 5 〉	통과 (2.61ms, 72.8MB)
 * 테스트 6 〉	통과 (5.22ms, 67MB)
 * 테스트 7 〉	통과 (1.86ms, 78.1MB)
 * 테스트 8 〉	통과 (3.00ms, 72.3MB)
 * */
public class P17681WhilstRefactor {
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
                if (toBinaryNumberString(arr1[current], n).charAt(k) == '1' || toBinaryNumberString(arr2[current], n).charAt(k) == '1')
                    secretCode = String.join("", secretCode, "#");
                else secretCode = String.join("", secretCode, " ");
            }
            answer[current] = secretCode;

//        System.out.println(Arrays.toString(answer));
            return recursiveGridBuilder(n, arr1, arr2, current+1, answer);
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
            P17681WhilstRefactor p17681WhilstRefactor = new P17681WhilstRefactor();
            int[] testArr1 = {46, 33, 33 ,22, 31, 50};
            int[] testArr2 = {27 ,56, 19, 14, 14, 10};
            String[] ans = p17681WhilstRefactor.solution(6, testArr1, testArr2);

            System.out.println(Arrays.toString(ans));
        }
}
