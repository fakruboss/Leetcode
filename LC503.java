package fakru.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC503 {

  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    for (int i = 0; i < 2 * n; ++i) {
      int iMod = i % n;
      while (!stack.isEmpty() && nums[iMod] > nums[stack.peek()]) {
        result[stack.pop()] = nums[iMod];
      }
      stack.push(iMod);
    }
    return result;
  }

  public static void main(String[] args) {
    LC503 lc503 = new LC503();
    System.out.println(Arrays.toString(lc503.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
  }
}
