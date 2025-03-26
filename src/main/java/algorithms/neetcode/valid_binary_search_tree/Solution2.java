package algorithms.neetcode.valid_binary_search_tree;

public class Solution2 {
  private boolean isValidBST(TreeNode root) {
    return valid(root, -1001, 1001);
  }

  private boolean valid(TreeNode node, int left, int right) {
    if (node == null) {
      return true;
    }

    if (node.val <= left || node.val >= right) {
      return false;
    }

    return (valid(node.left, left, node.val) && valid(node.right, node.val, right));
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
