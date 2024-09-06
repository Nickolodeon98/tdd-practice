package algorithms.bruteforce.permutation;

import java.util.Arrays;

public class Permutation {

  public static void findNextPermutation(int[] givenArr) {
    int i = 1, j = 0;

    for (int index = 1; index < givenArr.length; index++) {
      if (givenArr[index - 1] <= givenArr[index]) {
        i = index;
      }
    }

    j = i;

    for (int index = j; index < givenArr.length; index++) {
      if (givenArr[index] > givenArr[i-1]) {
        j = index;
      }
    }

    swap(givenArr, i-1, j);

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
    findNextPermutation(new int[]{7,2,3,6,5,4,1});
  }

}
