package algorithms.neetcode.subtree_of_another_tree;

class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }

    if (root == null) {
      return false;
    }

    if (subRoot == null) {
      return true;
    }

    if (isSameTree(root, subRoot)) {
      return true;
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSameTree(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }

    if (a != null && b != null && a.val == b.val) {
      return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    return false;
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

