package algorithms.baekjoon;

public class SugarSolution {

  public int allocateSugar(int grams) {
    int ans = -1;

    for (int i = 0; i * 5 < grams; i++) {
      if ((grams - i * 5) % 3 == 0) {
        ans = i + (grams - i * 5) / 3;
        break;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    SugarSolution test = new SugarSolution();

    System.out.println(test.allocateSugar(11));
  }
}
