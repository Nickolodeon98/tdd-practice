package algorithms.programmers;

public class P17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        /* 1. 각 원소를 이진수로 변환 */
        String binary1 = "";
        String binary2 = "";
        for (int i = 0; i < n; i++) {
            binary1 = Integer.toBinaryString(arr1[i]);
            binary2 = Integer.toBinaryString(arr2[i]);
        }

        /* 2. 2차원 배열에 넣을 문자열을 구성 */

        return answer;
    }
}
