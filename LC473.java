package fakru.leetcode;

import java.util.Arrays;

public class LC473 {

  public boolean makesquare(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    if (total % 4 != 0) {
      return false;
    }
    int sideLength = total / 4;
    Arrays.sort(nums);
    reverse(nums);
    int[] sides = new int[4];
    return backtrack(0, nums, sides, sideLength);
  }

  private void reverse(int[] nums) {
    for (int i = 0; i < nums.length / 2; ++i) {
      int temp = nums[i];
      nums[i] = nums[nums.length - 1 - i];
      nums[nums.length - 1 - i] = temp;
    }
  }

  private boolean backtrack(int pos, int[] nums, int[] sides, int sideLength) {
    if (pos == nums.length) {
      return true;
    }

    for (int i = 0; i < 4; ++i) {
      if (sides[i] + nums[pos] <= sideLength) {
        sides[i] += nums[pos];
        if (backtrack(pos + 1, nums, sides, sideLength)) {
          return true;
        }
        sides[i] -= nums[pos];
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LC473 lc473 = new LC473();
    boolean makesquare = lc473.makesquare(new int[]{2, 2, 3, 3, 2});
    System.out.println(makesquare);
  }
}
