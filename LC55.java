package fakru.leetcode;

public class LC55 {

  public static void main(String[] args) {
    LC55Demo demo = new LC55Demo();
    int[] nums = {3, 2, 1, 0, 4};
    boolean result = demo.canJump(nums);
    System.out.println(result);
  }
}

class LC55Demo {

  private boolean canJump(int[] nums, int[] result, int position) {
    if (result[position] != 0) {
      return result[position] == 1;
    }
    int maxPosition = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= maxPosition; ++nextPosition) {
      if (canJump(nums, result, nextPosition)) {
        result[position] = 1;
        return true;
      }
    }
    result[position] = -1;
    return false;
  }

  // -1 -> false, 0 -> unknown, 1 -> true
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    result[n - 1] = 1;
    return canJump(nums, result, 0);
  }

  // SOLUTION 2
  boolean canJump1(int[] nums) {
    int n = nums.length, last = n - 1;
    for (int i = last - 1; i >= 0; --i) {
      if (nums[i] + i >= last) {
        last = i;
      }
    }
    return last <= 0;
  }
}