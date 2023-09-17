package algorithms.utils;

public class Utils {

  public static int[] swapValue(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return arr;
  }

  public static char[] swapValue(char[] arr, int a, int b) {
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return arr;
  }

}
