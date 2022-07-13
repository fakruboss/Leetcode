package fakru.leetcode;

import fakru.leetcode.node.ListNode;
import java.util.ArrayList;
import java.util.List;

public class LC234 {

  private ListNode getMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    System.out.println(slow.val);
    return slow;
  }

  private ListNode reverseNode(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return head;
  }

  private boolean compareNodes(ListNode head, ListNode midNode) {
    while (midNode != null) {
      System.out.println(head.val + " " + midNode.val);
      if (head.val != midNode.val) {
        return false;
      }
      head = head.next;
      midNode = midNode.next;
    }
    return true;
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode midNode = getMiddleNode(head);
    ListNode secondHalf = reverseNode(midNode);
    return compareNodes(head, secondHalf);
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    LC234 solution = new LC234();
    solution.isPalindrome(root);
  }
}
