package algorithms.primenumber;

import java.util.Arrays;

public class EratosthenesLessSpace {
    public int findPrime(int[] mixedNumArr) {
        /* 배열 내의 모든 숫자들이 만약 처음부터 배열 길이의 절반까지의 범위 내에 있는 숫자들과 같은 숫자가 아닌데 나누어진다면
         * (즉 이 숫자들의 배수라면) 숫자들의 위치를 0으로 채운다. */

        /* count 변수로 몇 개의 소수가 존재하는지 센다. 처음에는 배열 내의 원소 개수 - 2 만큼(탐색할 범위의 크기)을 할당한 후에
         * 이후 반복문 내에서 0이 할당되는 개수만큼 뺀다. (모든 합성수의 개수를 빼는 것) */
        int count = mixedNumArr.length - 2;

        for (int i = 2; i <= mixedNumArr.length/2; i++) {
            for (int j = 2; j < mixedNumArr.length; j++) {
                if (mixedNumArr[j] == 0) continue;
                if (i != j && j % i == 0) {
                    mixedNumArr[j] = 0;
                    count--;
                }
            }
        }
        return count;
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

        System.out.println(eratosthenesLessSpace.findPrime(testArr));
    }
}
