package algorithms.programmers;

public class P12950 {
    /* 행렬은 2차원 배열로 표현한다.
     * 행은 2차원 배열 내에서 두 괄호 중 첫번째 값으로 참조한다.
     * 열은 괄호 중 두번째 값으로 참조한다. */
    public int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix;
    }

    /* 리팩토링 할 수 있을까? */

}
