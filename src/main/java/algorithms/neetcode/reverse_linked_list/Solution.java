package algorithms.neetcode.reverse_linked_list;

public class Solution {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode lastNode = new ListNode(head.val);
    ListNode curNode = head.next;
    while (curNode != null) {
      lastNode = new ListNode(curNode.val, lastNode);
      curNode = curNode.next;
    }
    return lastNode;
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}

