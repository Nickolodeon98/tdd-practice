package algorithms.binarytree;

import java.util.Scanner;

public class LowestCommonAncestor {
    public int distBtwNodes(int a, int b, int dist) {
        if (a > b) {
            int nodeALca = a / 2;
            dist++;
            return distBtwNodes(nodeALca, b, dist);
        }
        if (b > a) {
            int nodeBLca = b / 2;
            dist++;
            return distBtwNodes(a, nodeBLca, dist);
        }
        return dist;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(lowestCommonAncestor.distBtwNodes(a, b, 0));
    }
}
