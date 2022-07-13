package fakru.leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * <p>Input: nums = [2,3,1,1,4]</p>
 *
 * <p>Output: 2</p>
 *
 * <p>Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index
 * 0 to 1, then 3 steps to the last index.</p>
 */


public class LC45 {

  public int jump(int[] nums) {
    int jumps = 0, levelMax = 0, currMax = 0;
    for (int i = 0, n = nums.length; i < n - 1; ++i) {
      currMax = Math.max(currMax, i + nums[i]);
      if (i == levelMax) {
        levelMax = currMax;
        ++jumps;
      }
    }
    return jumps;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    LC45 demo = new LC45();
    demo.jump(nums);
  }
}