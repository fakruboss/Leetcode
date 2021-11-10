package fakru.leetcode;

import fakru.leetcode.node.IndexNode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * check Tech Dose channel for references
 */
public class LC239 {

  // SOLUTION 1 : using Priority Queue
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length, ri = 0;
    int[] result = new int[n - k + 1];
    PriorityQueue<IndexNode> pq = new PriorityQueue<>(k, (o1, o2) -> o2.value - o1.value);
    for (int i = 0; i < k; ++i) {
      pq.offer(new IndexNode(i, nums[i]));
    }
    result[ri++] = pq.peek().value;
    for (int i = k; i < n; ++i) {
      pq.offer(new IndexNode(i, nums[i]));
      while (pq.peek().index <= i - k) {
        pq.poll();
      }
      result[ri++] = pq.peek().value;
    }
    return result;
  }

  /**
   * SOLUTION 2 : using Doubly Linked List
   * <p>
   * 1. pop front elements from the queue if it is out of range
   * <p>
   * 2. maintain queue in descending order i.e. if the elements at front are less than the current
   * element, remove them
   * <p>
   * 3. push the current index at the end to maintain chronological order
   * <p>
   * 4. add the max element of the current window i.e. head of the queue to the resultant array
   */
  public int[] maxSlidingWindow2(int[] nums, int k) {
    int n = nums.length, ri = 0;
    int[] result = new int[n - k + 1];
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!q.isEmpty() && q.peek() <= i - k) {
        q.poll();
      }
      while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
        q.pollLast();
      }
      q.offer(i);
      if (i >= k - 1) {
        result[ri++] = nums[q.peek()];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {9, 11};
    LC239 lc239 = new LC239();
    System.out.println(Arrays.toString(lc239.maxSlidingWindow2(nums, 2)));
  }
}
