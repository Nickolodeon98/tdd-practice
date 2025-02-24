package algorithms.neetcode.remove_node_from_end_of_linked_list;

class Solution2 {
  public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
    // head 탐색을 위해 다른 ListNode2 에 저장
    ListNode2 end = head;

    // 시작 노드는 이미 세었으므로 1
    int count = 1;

    // 총 노드의 개수 세기
    while (end.next != null) {
      end = end.next;
      count++;
    }

    // 개수 확인
    System.out.println("총계: " + count);

    // A - B - C - D - E
    // 지워야 할 노드의 순번 찾기 (전체 노드 수 count - 뒤에서 몇 번째까지 지울지 n + 1)
    int nodeToRemove = count - n + 1;

    // next 를 지워야 할 노드의 순번 찾기
    int nodeToChangeNext = nodeToRemove - 1;

    // next 가 지워져야 할 노드의 순번
    System.out.println("next 가 지워져야 할 순번: " + nodeToChangeNext);

    // next 를 지워야 할 노드를 찾아 found 에 저장
    ListNode2 found = repeat(head, 1, nodeToChangeNext);
    if (found != null) {
      System.out.println("next 가 없어져야 할 노드 값: " + found.val);
    }

    // 만약 반환된 노드가 null 이면 그대로 반환
    if (found == null) {
      return found;
    }


    if (nodeToChangeNext == 0) {
      return found;
    }

    return head;
  }

  public ListNode2 repeat(ListNode2 node, int current, int n) {
    // 순번이 0 이라는 뜻은 맨 처음 노드가 지워져야 한다는 뜻이므로 단순 한 칸 옮기고 끝
    if (n == 0) {
      node = node.next;
      return node;
    }

    // 1부터 시작했던 current 가 n 과 같아졌다는 뜻은 지금 node 는 이미 우리가 찾는 node
    // 그러므로 다음을 다다음을 가리키도록 만듬
    if (current == n) {
      System.out.println("reached: " + node.val);
      if (node.next.next != null) {
        node.next = node.next.next;
      } else {
        node.next = null;
      }
      return node;
    }

    return repeat(node.next, current+1, n);
  }

  public static class ListNode2 {
    int val;
    Solution2.ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, Solution2.ListNode2 next) { this.val = val; this.next = next; }
  }
}
