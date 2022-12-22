package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0, n = nums.length; i < n; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1, right = n - 1;
      while (left < right) {
        int threeSum = nums[i] + nums[left] + nums[right];
        if (threeSum < 0) {
          ++left;
        } else if (threeSum > 0) {
          --right;
        } else {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          ++left;
          while (nums[left] == nums[left - 1] && left < right) {
            ++left;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> res = new LC15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println(res);
  }
}
