package fakru.leetcode;

import fakru.leetcode.node.ListNode;

public class LC19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode resultHead = new ListNode(-1);
    ListNode left = resultHead;
    ListNode right = head;

    while (n > 0 && right != null) {
      right = right.next;
      --n;
    }

    while (right != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;
    return resultHead.next;
  }
}