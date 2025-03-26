package algorithms.neetcode.valid_binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    List<Integer> rightValues = new ArrayList<>();
    List<Integer> leftValues = new ArrayList<>();
    leftValues.add(root.val);
    rightValues.add(root.val);
    return searchEveryNode(root, leftValues, rightValues) && searchEveryNode(root, leftValues, rightValues);
  }

  public boolean searchEveryNode(TreeNode node, List<Integer> leftValues, List<Integer> rightValues) {
    if (node == null) {
      return true;
    }

    if (node.left != null) {
      List<Integer> newValues1 = leftValues.stream().filter(v ->  v > node.left.val).collect(
          Collectors.toList());

      System.out.println(newValues1);
      System.out.println(leftValues);

      if (newValues1.size() != leftValues.size()) {
        return false;
      }

      leftValues.add(node.left.val);

      if (node.left.val >= node.val) {
        return false;
      }
    }

    if (node.right != null) {
      List<Integer> newValues2 = rightValues.stream().filter(v -> v < node.right.val).collect(Collectors.toList());

      System.out.println(newValues2);
      System.out.println(rightValues);

      if (newValues2.size() != rightValues.size()) {
        return false;
      }

      rightValues.add(node.right.val);

//      if (isRight) {
//        if (node.right.val <= node.val) {
//          return false;
//        }
//      }

    }

    return searchEveryNode(node.left, leftValues, leftValues) && searchEveryNode(node.right, rightValues, rightValues);
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

