package fakru.leetcode;

import fakru.leetcode.node.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC148 {

  public ListNode sortList(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    int[] nums = new int[list.size()];
    for (int i = 0, n = nums.length; i < n; ++i) {
      nums[i] = list.get(i);
    }
    Arrays.sort(nums);
    ListNode resultHead = new ListNode(-1);
    ListNode result = resultHead;
    for (int num : nums) {
      result.next = new ListNode(num);
      result = result.next;
    }
    return resultHead.next;
  }
}
