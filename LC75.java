package fakru.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/submissions/
 *
 * <p>nums = [2,0,2,1,1,0]</p>
 * <p>[0,0,1,1,2,2]</p>
 */
public class LC75 {

  public void sortColors(int[] nums) {
    int n = nums.length, low = 0, high = n - 1;
    for (int i = low; i <= high; ) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i++] = nums[low];
        nums[low++] = temp;
      } else if (nums[i] == 2) {
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high--] = temp;
      } else {
        ++i;
      }
    }
  }

  public void sortColors2(int[] nums) {
    int n = nums.length, left = 0, right = n - 1;
    for (int i = left; i <= right; ) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left++] = temp;
      } else if (nums[i] == 2) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right--] = temp;
      } else {
        ++i;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {0, 0, 0, 0, 0};
    LC75 lc75 = new LC75();
    lc75.sortColors2(nums);
    System.out.println(Arrays.toString(nums));
  }
}