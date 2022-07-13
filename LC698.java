package fakru.leetcode;

import java.util.Arrays;

public class LC698 {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    if (total % k != 0) {
      return false;
    }
    int sideLength = total / k;
    Arrays.sort(nums);
    reverse(nums);
    int[] sides = new int[k];
    return backtrack(0, nums, k, sides, sideLength);
  }

  private void reverse(int[] nums) {
    for (int i = 0; i < nums.length / 2; ++i) {
      int temp = nums[i];
      nums[i] = nums[nums.length - 1 - i];
      nums[nums.length - 1 - i] = temp;
    }
  }

  private boolean backtrack(
      int pos, int[] nums, int k, int[] sides, int sideLength) {
    if (pos == nums.length) {
      return true;
    }

    for (int i = 0; i < k; ++i) {
      if (sides[i] + nums[pos] <= sideLength) {
        sides[i] += nums[pos];
        if (backtrack(pos + 1, nums, k, sides, sideLength)) {
          return true;
        }
        sides[i] -= nums[pos];
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LC698 lc698 = new LC698();
    boolean b = lc698.canPartitionKSubsets(new int[]{2, 1, 1, 1, 1, 3, 1, 2}, 3);
    System.out.println(b);
  }
}
