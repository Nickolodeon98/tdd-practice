package algorithms.neetcode.remove_node_from_end_of_linked_list;

/**
 * Definition for singly-linked list.
 */

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode end = head;
    int count = 1;
    while (end.next != null) {
      end = end.next;
      count++;
    }

    int nodeToRemove = count - n + 1;

    int nodeToChangeNext = nodeToRemove - 1;

    ListNode found = repeat(head, 1, nodeToChangeNext);

    if (found == null) {
      return found;
    }

    if (found.next == null) {
      return found;
    }

    // found.next = found.next.next;

    return found;
  }

  public ListNode repeat(ListNode node, int current, int n) {
    if (n == 0) {
      node = node.next;
      return node;
    }

    if (current == n) {
      node.next = node.next.next;
      return node;
    }

    node = node.next;

    return repeat(node, current+1, n);
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

