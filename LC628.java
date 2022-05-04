package fakru.leetcode;

import java.util.Arrays;

public class LC628 {

  public int maximumProduct(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int result = nums[n - 1] * nums[n - 2] * nums[n - 3], currProduct = result;
    for (int i = 0; i <= nums.length - 3; ++i) {
      currProduct = (currProduct / nums[n - 3 + i]) * nums[i];
      result = Math.max(result, currProduct);
    }
    return result;
  }

  public static void main(String[] args) {
    int i = new LC628().maximumProduct(new int[]{-100, -2, -3, 1});
    System.out.println(i);
  }
}
