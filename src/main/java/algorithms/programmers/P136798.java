package algorithms.programmers;

public class P136798 {

    /* 숫자나라 기사단 : 너는 1번, 너는 2번 ... 너는 number 번
     * 협약기관에서 공격력에 대한 제한 수치를 걸어두었다. */

    public int countDivisors(int num, int idx) {
        if (idx == num) return 1;
        if (num % idx == 0) return countDivisors(num, ++idx) + 1;
        return countDivisors(num, ++idx);
    }

    public int steelWeight(int number, int limit, int power) {
        int divNum = 0;
        for (int i = 1; i <= number; i++) {
            divNum = countDivisors(i, 1);
        }
        return divNum;
    }

    public static void main(String[] args) {
        P136798 p136798 = new P136798();
        System.out.println(p136798.countDivisors(10, 1));
    }
}
