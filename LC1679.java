package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1679 {

  public int maxOperations(int[] nums, int k) {
    int result = 0;
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      int target = k - num;
      if (freq.getOrDefault(target, 0) != 0) {
        ++result;
        freq.put(target, freq.get(target) - 1);
      } else {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 2, 3, 4, 5, 3, 3, 4, 5, 6, 5, 4, 3, 5, 6, 4, 3, 5, 7, 5, 4, 7};
    int i = new LC1679().maxOperations(nums, 6);
    System.out.println(i);
  }
}
