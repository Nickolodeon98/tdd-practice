package algorithms.neetcode.construct_binary_tree_from_preorder_and_inorder_traversal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // preorder 의 첫 번째 값은 root node 의 val 을 나타낸다.
    // inorder 배열을 돌며 첫 번째 값이 나오기 전까지가 left, 나온 이후가 right 이다.
    // left 는 inorder 의 순서대로와, preorder 의 순서가 다르다.

    List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
    List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
    List<Integer> result = new ArrayList<>();

    split(result, preorderList, inorderList);

    System.out.println(result);
    return new TreeNode(1);
  }

  public boolean isEqual(List<Integer> a, List<Integer> b) {
    if (a.size() != b.size()) {
      return false;
    }
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) != b.get(i)) {
        return false;
      }
    }
    return true;
  }

  public void split(List<Integer> result, List<Integer> curPreorder, List<Integer> curInorder) {
    if (isEqual(curPreorder, curInorder)) {
      result.addAll(curPreorder);
      return;
    }

    // curInorder 에서 curPreorder 와 일치하는 만큼만 리스트에 넣기
    List<Integer> leftNodes = new ArrayList<>();
    List<Integer> rightNodes = new ArrayList<>();

    for (int i = 0; i< curInorder.size(); i++) {
      if (curPreorder.get(0) == curInorder.get(i)) {
        break;
      }
      leftNodes.add(curInorder.get(i));
    }


    for (int j = 1; j < leftNodes.size() + 1; j++) {
      rightNodes.add(curPreorder.get(j));
    }

    split(result, rightNodes, leftNodes);
  }

  public static class TreeNode {
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

