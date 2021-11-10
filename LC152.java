package fakru.leetcode;

public class LC152 {

  public static void main(String[] args) {
    LC152Solution solution = new LC152Solution();
    int[] nums = {2, 3, -2, 4, -5};
//    int x = solution.maxProduct(nums);
//    System.out.println(x);
    int y = solution.maxProduct2(nums);
    System.out.println(y);
  }
}

class LC152Solution {

  public int maxProduct(int[] nums) {
    int prod = 1;
    int result = Integer.MIN_VALUE;

    for (int num : nums) {
      prod = prod * num;
      result = Math.max(prod, result);
      if (prod == 0) {
        prod = 1;
      }
    }
    prod = 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      prod = prod * nums[i];
      result = Math.max(prod, result);
      if (prod == 0) {
        prod = 1;
      }
    }
    return result;
  }

  // SOLUTION 2

  /**
   * https://leetcode.com/problems/maximum-product-subarray/discuss/699929/Comparison-with-53.-Maximum-Subarray
   *
   * @param nums
   * @return
   */
  int maxProduct2(int[] nums) {
    int result = nums[0], maxProd = result, minProd = result;
    for (int i = 1, n = nums.length; i < n; ++i) {
      if (nums[i] < 0) {
        int temp = maxProd;
        maxProd = minProd;
        minProd = temp;
      }
      maxProd = Math.max(nums[i], maxProd * nums[i]);
      minProd = Math.min(nums[i], minProd * nums[i]);
      result = Math.max(result, maxProd);
    }
    return result;
  }
}
