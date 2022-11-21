package algorithms.programmers;

public class P12950 {
    /* 행렬은 2차원 배열로 표현한다.
     * 행은 2차원 배열 내에서 두 괄호 중 첫번째 값으로 참조한다.
     * 열은 괄호 중 두번째 값으로 참조한다. */
    public int[][] solution(int[][] matrix1, int[][] matrix2, int current, int[][] matrix) {
        int rowSize = matrix1.length;
        if (current == rowSize) return matrix;

        int columnSize = matrix1[0].length;

        for (int j = 0; j < columnSize; j++) {
            matrix[current][j] = matrix1[current][j] + matrix2[current][j];
        }
        return solution(matrix1, matrix2, current+1, matrix);
    }

    /* 리팩토링 할 수 있을까? */

}
