package fakru.leetcode;

public class LC213 {

  public static void main(String[] args) {
    int[] nums = {0};
    LC213Demo demo = new LC213Demo();
    demo.rob(nums);
  }
}

class LC213Demo {

  private int rob(int[] nums, int start, int end) {
    int prev1 = nums[start], prev2 = 0;
    for (int i = start + 1; i < end; ++i) {
      int currMax = Math.max(prev1, nums[i] + prev2);
      prev2 = prev1;
      prev1 = currMax;
    }
    return Math.max(prev1, prev2);
  }

  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
  }
}