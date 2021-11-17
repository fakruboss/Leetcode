package fakru.leetcode;

public class LC494 {

  private int findTargetSumWays(int[] nums, int target, int index, int currSum) {
    if (index == nums.length) {
      return currSum == target ? 1 : 0;
    }
    return findTargetSumWays(nums, target, index + 1, currSum + nums[index])
        + findTargetSumWays(nums, target, index + 1, currSum - nums[index]);
  }

  public int findTargetSumWays(int[] nums, int target) {
    return findTargetSumWays(nums, target, 0, 0);
  }

  public static void main(String[] args) {
    System.out.println(new LC494().findTargetSumWays(new int[]{2, 1}, 2));
  }
}
