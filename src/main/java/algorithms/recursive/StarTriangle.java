package algorithms.recursive;

public class StarTriangle {
    public void printStars(int n) {
        if (n == 0) return;
        System.out.print("*");
        printStars(n-1);
    }

    public void printTriangle(int n) {
        if (n == 0) return;
        printTriangle(n-1);
        printStars(n);
        System.out.println();
    }

    public static void main(String[] args) {
        StarTriangle starTriangle = new StarTriangle();
        starTriangle.printTriangle(5);
    }
}
