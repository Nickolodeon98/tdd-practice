package algorithms.binarytree;

import java.util.Scanner;

public class LowestCommonAncestor {
    public int distBtwNodes(int a, int b) {
        // 전지적 시점이다. 어디에서 시작해서 어디서 끝날지 정확히 알고 있기 때문에 조건문만 걸어서 카운트해주면 된다.
        // 처음에 시작한 부분에서 끝 부분까지 어떤 경로로 이루어져 있는지 정확히 알고 있어서 이렇게 코딩이 가능하다.
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
