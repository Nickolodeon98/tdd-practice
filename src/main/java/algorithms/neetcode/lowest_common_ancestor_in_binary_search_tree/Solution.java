package algorithms.neetcode.lowest_common_ancestor_in_binary_search_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<Integer, List<TreeNode>> parentNodeInfos = new HashMap<>();
    parentNodeInfos.put(root.val, Arrays.asList(root));
    TreeNode temp = root;

    searchReverse(parentNodeInfos, root);

    List<TreeNode> pNodeAncestors = parentNodeInfos.get(p.val);
    List<TreeNode> qNodeAncestors = parentNodeInfos.get(q.val);

    if (pNodeAncestors == null || pNodeAncestors.isEmpty()) {
      return qNodeAncestors.get(0);
    }

    if (qNodeAncestors == null || qNodeAncestors.isEmpty()) {
      return pNodeAncestors.get(0);
    }

    pNodeAncestors.forEach(v -> System.out.println(v.val));
    qNodeAncestors.forEach(v -> System.out.println(v.val));

    for (TreeNode v : pNodeAncestors) {
      if (qNodeAncestors.contains(v)) {
        return v;
      }
    }

    return new TreeNode();
  }

  public void searchReverse(Map<Integer, List<TreeNode>> nodeInfos, TreeNode node) {
    if (node == null) {
      return;
    }

    if (node.left != null) {
      List<TreeNode> listToAdd = new ArrayList<>();
      listToAdd.add(node.left);
      listToAdd.add(node);
      List<TreeNode> ancestors = nodeInfos.get(node.val);
      if (ancestors != null) {
        ancestors.stream().forEach(v -> listToAdd.add(v));
      }
      nodeInfos.put(node.left.val, listToAdd);
    }

    if (node.right != null) {
      List<TreeNode> listToAdd = new ArrayList<>();
      listToAdd.add(node.right);
      listToAdd.add(node);
      List<TreeNode> ancestors = nodeInfos.get(node.val);
      if (ancestors != null) {
        ancestors.stream().forEach(v -> listToAdd.add(v));
      }
      nodeInfos.put(node.right.val, listToAdd);
    }

    searchReverse(nodeInfos, node.left);
    searchReverse(nodeInfos, node.right);

    return;
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

