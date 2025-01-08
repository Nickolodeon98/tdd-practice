package algorithms.neetcode.linked_list_cycle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public boolean hasCycle(ListNode head) {
    List<Integer> visited = new ArrayList<>();

    if (head.next == null) {
      return false;
    }

    while (head.next != null) {
      if (visited.contains(head.val)) {
        return true;
      }
      visited.add(head.val);
      head = head.next;
    }

    return false;
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

