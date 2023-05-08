package algorithms.book.divideAndConquer;

public class FastSum {

  public int recursiveSum(int num) {
    if (num == 1) return 1;

    if (num % 2 == 1) return recursiveSum(num - 1) + num;

    return 2 * recursiveSum(num/2) + (num * num) / 4;
  }

  public static void main(String[] args) {
    FastSum test = new FastSum();

    System.out.println(test.recursiveSum(10));
  }
}
