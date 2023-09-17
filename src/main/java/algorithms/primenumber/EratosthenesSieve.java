package algorithms.primenumber;

public class EratosthenesSieve {

  static int[] nums;
  static int M = 0;
  static int N = 50;
  public static void solution() {

    nums = new int[N-M+1];

    nums[0] = -1;
    nums[1] = -1;

    for (int n = 2; n < nums.length; n++) {
      nums[n] = n;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 2; i * j <= N; j++) {
        nums[i*j] = -1;
      }
    }

    for (int k = M; k <= N; k++) {
      if (nums[k] == -1) continue;
      System.out.println(nums[k]);
    }
  }

  public static void main(String[] args) {
    solution();
  }
}
