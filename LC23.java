package fakru.leetcode;

import fakru.leetcode.node.ListNode;
import java.util.ArrayList;
import java.util.List;

public class LC23 {

  private ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode resultHead = new ListNode(-1);
    ListNode curr = resultHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    if (l1 == null) {
      curr.next = l2;
    } else {
      curr.next = l1;
    }
    return resultHead.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    while (lists.length > 1) {
      List<ListNode> mergedLists = new ArrayList<>();
      for (int i = 0; i < lists.length; i += 2) {
        ListNode l1 = lists[i];
        ListNode l2 = i + 1 == lists.length ? null : lists[i + 1];
        mergedLists.add(mergeTwoList(l1, l2));
      }
      lists = mergedLists.toArray(new ListNode[0]);
    }
    return lists[0];
  }

  public static void main(String[] args) {
    ListNode[] lists = {new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4)};
    new LC23().mergeKLists(lists);
  }
}
