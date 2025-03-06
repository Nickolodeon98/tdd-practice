package algorithms.neetcode.same_tree;

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }

    if (q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
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

