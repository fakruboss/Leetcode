package fakru.leetcode;

import java.util.Stack;

public class LC456 {

  public boolean find132pattern(int[] nums) {
    int s3 = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < s3) {
        return true;
      } else {
        while (!stack.isEmpty() && nums[i] > stack.peek()) {
          s3 = stack.pop();
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean pattern = new LC456().find132pattern(new int[]{3, 1, 4, 2});
    System.out.println(pattern);
  }
}
