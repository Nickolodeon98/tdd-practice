package algorithms.binarytree;

import java.util.Scanner;

public class LowestCommonAncestor {
    public int distBtwNodes(int a, int b) {
        if (a > b) {
            int nodeALca = a / 2;
            return distBtwNodes(nodeALca, b) + 1;
        }
        if (b > a) {
            int nodeBLca = b / 2;
            return distBtwNodes(a, nodeBLca) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(lowestCommonAncestor.distBtwNodes(a, b));
    }
}
