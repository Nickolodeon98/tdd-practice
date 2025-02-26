package algorithms.neetcode.maximum_depth_of_binary_tree;

public class Solution {
  public int maxDepth(TreeNode root) {
    return searchTree(root, 0);
  }

  public int searchTree(TreeNode node, int count) {
    if (node == null) {
      return count;
    }

    return Math.max(searchTree(node.right, count + 1), searchTree(node.left, count + 1));
  }

  static class TreeNode {
    int val;
    algorithms.neetcode.maximum_depth_of_binary_tree.Solution.TreeNode left;
    algorithms.neetcode.maximum_depth_of_binary_tree.Solution.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, algorithms.neetcode.maximum_depth_of_binary_tree.Solution.TreeNode left, algorithms.neetcode.maximum_depth_of_binary_tree.Solution.TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}

