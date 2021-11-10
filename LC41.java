package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC41 {

  /**
   * SOLUTION 1 : O(N) -> time & O(N) -> space
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, 1);
    }
    for (int i = 1; i <= n; ++i) {
      if (!map.containsKey(1)) {
        return i;
      }
    }
    return n + 1;
  }

  public int firstMissingPositive2(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
      int index = nums[i] - 1;
      while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[index]) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
        index = nums[i] - 1;
      }
    }
    for (int i = 0; i < n; ++i) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n;
  }

  public static void main(String[] args) {
    LC41 lc41 = new LC41();
    System.out.println(lc41.firstMissingPositive2(new int[]{3, 4, 7, 1}));
  }
}