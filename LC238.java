package fakru.leetcode;

import java.util.Arrays;

public class LC238 {

  /**
   * Initially, traverse through the loop and find the product of all the elements like prefix sum
   * with addition (prefix product) leaving the current element and putting it to the result array
   * <p>
   * now, traverse the array again in reverse, leaving the current element and calculating the
   * prefix product and in each step, multiply the current prefix product with result array for that
   * position. on doing this, the product of all the elements will be calculated by to and fro
   * prefix products
   */
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length, temp = 1;
    int[] result = new int[n];
    for (int i = 0; i < n; ++i) {
      result[i] = temp;
      temp *= nums[i];
    }
    temp = 1;
    for (int i = n - 1; i >= 0; --i) {
      result[i] *= temp;
      temp *= nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(Arrays.toString(new LC238().productExceptSelf(nums)));
  }
}
