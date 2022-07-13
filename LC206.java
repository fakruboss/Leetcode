package fakru.leetcode;

import fakru.leetcode.node.ListNode;

public class LC206 {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    LC206 lc206 = new LC206();
    lc206.reverseList(root);
  }
}
