package algorithms.book.divideAndConquer;

import java.util.List;

public class MergeSortWithArray {
  public static int[] target;
  public static void merge(int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    int[] L = new int[n1];
    int[] M = new int[n2];

    for (int i = 0; i < n1; i++) {
     L[i] = target[p + i];
    }
    for (int j = 0; j < n2; j++) {
      M[j] = target[q + 1 + j];
    }

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        target[k] = L[i];
        i++;
      } else {
        target[k] = M[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      target[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      target[k] = M[j];
      j++;
      k++;
    }
  }

  public static void divide(int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      divide(left, mid);
      divide(mid + 1, right);

      merge(left, mid, right);
    }
  }

  public static void main(String[] args) {
    target = new int[]{6,5,12,10,9,1};
    divide(0, target.length-1);

    for (int t : target) {
      System.out.println(t);
    }
  }


}
