package algorithms.neetcode.invert_binary_tree;

public class Solution {
  public TreeNode invertTree(TreeNode root) {
    doInvert(root);
    return root;
  }

  public void doInvert(TreeNode node) {
    if (node == null) {
      return;
    }
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
    doInvert(node.left);
    doInvert(node.right);
  }

  static class TreeNode {
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
