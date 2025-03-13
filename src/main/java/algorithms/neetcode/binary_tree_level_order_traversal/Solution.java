package algorithms.neetcode.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    int height = findHeight(root, 0);

    List<List<Integer>> ordered = new ArrayList<>();

    Stack<List<Integer>> temp = new Stack<>();

    for (int i = 1; i <= height; i++) {
      List<Integer> nodes = new ArrayList<>();
      levelDown(root, nodes, height, i);
      if (nodes.isEmpty()) {
        temp.push(List.of(root.val));
      } else {
        temp.push(nodes);
      }
    }

    while (!temp.isEmpty()) {
      ordered.add(temp.pop());
    }

    System.out.println(temp);

    return ordered;
  }

  public TreeNode levelDown(TreeNode node, List<Integer> nodes, int level, int limit) {
    if (level == limit) {
      return node;
    }

    if (node == null) {
      return null;
    }

    TreeNode left = levelDown(node.left, nodes, level-1, limit);
    TreeNode right = levelDown(node.right, nodes, level-1, limit);

    if (left != null) {
      nodes.add(left.val);
    }

    if (right != null) {
      nodes.add(right.val);
    };

    return null;
  }

  public int findHeight(TreeNode node, int height) {
    if (node == null) {
      return height;
    }

    height++;
    return (int) Math.max(findHeight(node.left, height), findHeight(node.right, height));
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

