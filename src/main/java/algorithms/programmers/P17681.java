package algorithms.programmers;

import java.util.Arrays;
import java.util.function.Predicate;

/* 2진수 변환 메서드 직접 구현했을 때
 * 테스트 1 〉	통과 (1.32ms, 73MB)
 * 테스트 2 〉	통과 (3.87ms, 77.8MB)
 * 테스트 3 〉	통과 (0.30ms, 76.1MB)
 * 테스트 4 〉	통과 (1.59ms, 84.9MB)
 * 테스트 5 〉	통과 (1.09ms, 74.6MB)
 * 테스트 6 〉	통과 (2.32ms, 72.5MB)
 * 테스트 7 〉	통과 (0.89ms, 81.5MB)
 * 테스트 8 〉	통과 (0.83ms, 76.4MB)
 * */

/* Integer.toBinaryString() 사용했을 때
 * 테스트 1 〉	통과 (0.81ms, 76.6MB)
 * 테스트 2 〉	통과 (1.99ms, 73.6MB)
 * 테스트 3 〉	통과 (0.23ms, 77.6MB)
 * 테스트 4 〉	통과 (1.09ms, 76.8MB)
 * 테스트 5 〉	통과 (0.72ms, 77.1MB)
 * 테스트 6 〉	통과 (1.22ms, 71.1MB)
 * 테스트 7 〉	통과 (0.47ms, 82.7MB)
 * 테스트 8 〉	통과 (0.42ms, 77.6MB)*/
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
        /* 현재 가리키고 있는 인덱스의 원소를 2진수로 변환 */
        String binaryNum = Integer.toBinaryString(arr1[current] | arr2[current]);
        secretCode = binaryNum.replaceAll("1", "#");
        secretCode = secretCode.replaceAll("0", " ");
        secretCode = String.join("", " ".repeat(n-secretCode.length()), secretCode);
        answer[current] = secretCode;

        /* 재귀 호출 */
        return recursiveGridBuilder(n, arr1, arr2, ++current, answer);
    }

//    public String toBinaryNumberString(int decimalNum) {
//        String binary = "";
//        while (decimalNum > 1) {
//            binary = String.join("", Integer.toString(decimalNum % 2), binary);
//            decimalNum /= 2;
//        }
//        binary = String.join("", String.valueOf(decimalNum % 2), binary);
//
//        return binary;
//    }

    public static void main(String[] args) {
        P17681 p17681 = new P17681();
        int[] testArr1 = {46, 33, 33, 22, 31, 50};
        int[] testArr2 = {27, 56, 19, 14, 14, 10};
        String[] ans = p17681.solution(6, testArr1, testArr2);

        System.out.println(Arrays.toString(ans));
    }
}
