package algorithms.bruteforce.permutation;

import java.util.Arrays;

public class Permutation {

  public static void findNextPermutation(int[] givenArr) {
    int j = 0, i = givenArr.length - 1;

    while (i >= 1 && givenArr[i] < givenArr[i - 1]) {
      i--;
    }

    j = i - 1;
    while (j + 1 < givenArr.length - 1 && givenArr[i - 1] < givenArr[j + 1]) {
      j++;
    }

    swap(givenArr, i - 1, j);

    int end = givenArr.length - 1;
    while (i < end) {
      swap(givenArr, i, end);
      i++;
      end--;
    }

    System.out.println(Arrays.toString(givenArr));
  }

  public static void swap(int[] arrToSwap, int idxToSwap, int idxSwapped) {
    int tmp = arrToSwap[idxSwapped];
    arrToSwap[idxSwapped] = arrToSwap[idxToSwap];
    arrToSwap[idxToSwap] = tmp;
  }

  public static void main(String[] args) {
    findNextPermutation(new int[]{7, 2, 3, 6, 5, 4, 1});
  }

}
