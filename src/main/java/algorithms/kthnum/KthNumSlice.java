package algorithms.kthnum;

import java.util.Arrays;

public class KthNumSlice {
    public int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] newArr = Arrays.copyOfRange(arr, commands[i][0]-1, commands[i][1]);
            Arrays.sort(newArr);
            answer[i] = newArr[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        KthNumSlice kthNumSlice = new KthNumSlice();
        int[] testArr = {1, 5, 2, 6, 3, 7, 4};
        int[][] testCommands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(kthNumSlice.solution(testArr, testCommands)));
    }
}
