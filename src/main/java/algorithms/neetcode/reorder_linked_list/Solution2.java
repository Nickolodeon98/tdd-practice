package algorithms.neetcode.reorder_linked_list;

class Solution2 {
  public void reorderList(ListNode head) {
    // find the second half
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse the second half list - slow is the start of the second half
    ListNode second = slow.next;
    ListNode prev = null;
    slow.next = null;

    while (second != null) {
      ListNode tmp = second.next;
      second.next = prev;
      prev = second;
      second = tmp;
    }

    second = prev; // because second is set to null otherwise

    // merge two halves
    while (head != null && second != null) {
      ListNode tmp1 = head.next;
      ListNode tmp2 = second.next;
      second.next = tmp1;
      head.next = second;
      head = tmp1;
      second = tmp2;
    }
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

