package algorithms.neetcode.merge_two_sorted_linked_lists;

public class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    ListNode first = new ListNode(list1.val, list1.next);
    ListNode second = new ListNode(list2.val, list2.next);
    ListNode merged;

    if (first.val <= second.val) {
      merged = new ListNode(first.val);
      first = first.next;
    } else {
      merged = new ListNode(second.val);
      second = second.next;
    }

    while (first != null && second != null) {
      // 만약 첫 번째 리스트 노드의 값이 더 작거나 같으면 그 값을 먼저 마지막 노드로 삼는다.
      ListNode next = new ListNode();
      int value = merged.val;
      if (first.val <= second.val) {
        value = first.val;
        next = new ListNode(first.val);
        first = first.next;
      } else {
        value = second.val;
        next = new ListNode(second.val);
        second = second.next;
      }
      merged = new ListNode(value, merged);
    }

    while (second != null) {
      merged = new ListNode(second.val, merged);
      second = second.next;
    }

    while (first != null) {
      merged = new ListNode(first.val, merged);
      first = first.next;
    }

    ListNode lastNode = new ListNode(merged.val);

    if (merged == null) {
      System.out.println("this is null");
    }
    ListNode curNode = merged.next;

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
