package algorithms.neetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution3 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
    List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());

    return createTree(preorderList, inorderList);
  }

  public TreeNode createTree(List<Integer> preorder, List<Integer> inorder) {
    if (preorder.isEmpty() || inorder.isEmpty()) {
      return null;
    }

    TreeNode root = new TreeNode(preorder.get(0));
    int mid = findIdx(inorder, root.val);

    root.left = createTree(preorder.subList(1, mid + 1), inorder.subList(0, mid));
    root.right = createTree(preorder.subList(mid + 1, preorder.size()),
        inorder.subList(mid + 1, preorder.size()));

    return root;
  }

  public int findIdx(List<Integer> inorder, int toFind) {
    for (int i = 0; i < inorder.size(); i++) {
      if (inorder.get(i) == toFind) {
        return i;
      }
    }
    return -1;
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

