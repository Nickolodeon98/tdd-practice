package algorithms.primenumber;

import java.util.Arrays;

public class EratosthenesLessSpace {
    public int[] findPrime(int[] mixedNumArr) {
        for (int i = 2; i <= mixedNumArr.length/2; i++) {
            for (int j = 2; j < mixedNumArr.length; j++) {
                if (i != j && j % i == 0) mixedNumArr[j] = 0;
            }
        }
        return mixedNumArr;
    }

    public static void main(String[] args) {
        /* 2부터 소수를 찾고 싶은 숫자 범위 안의 숫자들을 배열에 넣는다. 0과 1은 소수가 아니므로 처음부터 제외시킨다.
         * 여기서는 2 ~ 50 내에서 소수를 찾고 싶다고 가정한다. */
        EratosthenesLessSpace eratosthenesLessSpace = new EratosthenesLessSpace();
        int SEARCH_RANGE = 50;
        int[] testArr = new int[SEARCH_RANGE+1];

        for (int i = 2; i < testArr.length; i++) {
            testArr[i] = i;
        }
        System.out.println(Arrays.toString(eratosthenesLessSpace.findPrime(testArr)));
    }
}
