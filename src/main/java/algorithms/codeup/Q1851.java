package algorithms.codeup;

public class Q1851 {
    public void printStar(int n) {
        if (n <= 0) return; // n 이 0이면 별을 출력하거나 n - 1 개의 별을 출력하는 메서드를 호출하면 안된다.
        /* n 개의 별을 출력하는 일은 1개를 출력한 후 n-1 개의 별을 더 출력하는 일로 바꿀 수 있다. */
        System.out.print("*");
        printStar(--n);
    }

    public static void main(String[] args) {
        Q1851 q1851 = new Q1851();
        q1851.printStar(4);
    }
}
