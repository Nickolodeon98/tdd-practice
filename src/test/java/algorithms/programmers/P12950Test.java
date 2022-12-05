package algorithms.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P12950Test {

    P12950 p12950;

    int[][] matrix1;
    int[][] matrix2;
    int[][] matrix;

    @BeforeEach
    void setUp() {
        p12950 = new P12950();
        matrix1 = new int[][]{{1,2},{2,3}};
        matrix2 = new int[][]{{3,4},{5,6}};
        matrix = new int[matrix1.length][matrix1[0].length];

    }

    @Test
    @DisplayName("행렬의 덧셈을 정확하게 한다.")
    void addTwoMatrix() {
        int[][] expectedResult = new int[][]{{4,6},{7,9}};
        int[][] actualResult = p12950.solution(matrix1, matrix2, 0, matrix);
        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult[i].length; j++) {
                assertEquals(expectedResult[i][j], actualResult[i][j]);
            }
        }
    }
}