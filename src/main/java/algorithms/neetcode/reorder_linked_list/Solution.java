package algorithms.neetcode.reorder_linked_list;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public void reorderList(ListNode head) {
    int cnt = 1;
    ListNode node = head;
    ListNode newHead = head;
    List<ListNode> nodes = new ArrayList<>();

    while (node.next != null) {
      nodes.add(node);
      cnt++;
      node = node.next;
    }
    nodes.add(node);

    ListNode nextNode = new ListNode();
    ListNode curHead = head;

    for (int i = 0; i < cnt; i++) {
      if (nodes.get(i) == null) break;
      if (i % 2 == 1) {
        int toSub = (i / 2) + 1;
        nextNode = findAt(newHead, cnt - toSub);
      } else {
        nextNode = findAt(newHead, i / 2);
      }

      head = new ListNode(head.val, nextNode); // 현재 head 의 값과 새로운 next node

      System.out.println(head.next.val);
    }


    while (head.next != null) {
      head = head.next;
    }
  }

  public ListNode findAt(ListNode node, int idx) {
    ListNode newNode = node;
    for (int i = 0; i < idx; i++) {
      newNode = newNode.next;
    }

    return newNode;
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

