package fakru.leetcode;

import java.util.Arrays;

/**
 * 1. find the index with current value greater than the previous value traversing from the end of
 * the array. If no such value is found, reverse the array
 * <p>
 * 2. after finding the value, find the next greatest element of that value from the index till the
 * end traversing from the end
 * <p>
 * 3. swap both indexes
 * <p>
 * 4. reverse all the elements post the index found in step 1
 */
public class LC31 {

  public void nextPermutation(int[] nums) {
    int startIdx = -1, swapIdx = -1, n = nums.length;
    for (int i = n - 1; i > 0; --i) {
      if (nums[i] > nums[i - 1]) {
        startIdx = i - 1;
        break;
      }
    }
    for (int i = n - 1; startIdx != -1 && i > startIdx; --i) {
      if (nums[i] > nums[startIdx]) {
        swapIdx = i;
        break;
      }
    }
    if (startIdx != -1 && swapIdx != -1) {
      swap(nums, startIdx, swapIdx);
    }
    for (int left = startIdx + 1, right = n - 1; left < right; ) {
      swap(nums, left, right);
      ++left;
      --right;
    }
  }

  private void swap(int[] nums, int x, int y) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 2};
    new LC31().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}