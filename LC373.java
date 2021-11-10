package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC373 {

  public static void main(String[] args) {
    LC373Solution solution = new LC373Solution();
    int[] nums1 = {1, 7, 11};
    int[] nums2 = {2, 4, 6};
    List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, 3);
    result.forEach(System.out::println);
  }
}

class LC373Solution {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Comparator<List<Integer>> comp = Comparator.comparingInt(a -> (a.get(0) + a.get(1)));
    PriorityQueue<List<Integer>> queue = new PriorityQueue<>(comp);
    for (int i = 0; i < Math.min(nums1.length, k); ++i) {
      queue.offer(Arrays.asList(nums1[i], nums2[0], 0));
    }
    for (int i = 0; i < Math.min(nums1.length * nums2.length, k); ++i) {
      List<Integer> curr = queue.poll();
      result.add(Arrays.asList(curr.get(0), curr.get(1)));
      if (curr.get(2) < nums2.length - 1) {
        queue.offer(Arrays.asList(curr.get(0), nums2[curr.get(2) + 1], curr.get(2) + 1));
      }
    }
    return result;
  }
}
