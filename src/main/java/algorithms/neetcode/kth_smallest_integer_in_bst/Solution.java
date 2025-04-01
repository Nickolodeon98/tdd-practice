package algorithms.neetcode.kth_smallest_integer_in_bst;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

  public int kthSmallest(TreeNode root, int k) {
    TreeSet<Integer> nodes = new TreeSet<>();
    traverse(root, nodes);

    List<Integer> ordered = new ArrayList<>(nodes);

    System.out.println(ordered);

    return ordered.get(k - 1);
  }

  public void traverse(TreeNode node, TreeSet<Integer> nodes) {
    if (node == null) {
      return;
    }

    nodes.add(node.val);

    traverse(node.left, nodes);
    traverse(node.right, nodes);
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
