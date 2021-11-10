package fakru.leetcode;

public class LC918 {

  public static void main(String[] args) {
    int[] nums = {1, -2, 3, -2};
    LC918Solution solution = new LC918Solution();
    int x = solution.maxSubarraySumCircular(nums);
    System.out.println(x);
  }
}

class LC918Solution {

  public int maxSubarraySumCircular(int[] nums) {
    int total = 0;
    int maxSum = Integer.MIN_VALUE, currMax = 0;
    int minSum = Integer.MAX_VALUE, currMin = 0;
    for (int num : nums) {
      currMax = Math.max(currMax + num, num);
      maxSum = Math.max(currMax, maxSum);
      currMin = Math.min(currMin + num, num);
      minSum = Math.min(currMin, minSum);
      total += num;
    }
    return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
  }
}