package fakru.leetcode;

public class LC42 {

  public int trap(int[] height) {
    int result = 0, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
    for (int left = 0, right = height.length - 1; left <= right; ) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      result += leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--];
    }
    return result;
  }

  public static void main(String[] args) {
    LC42 lc42 = new LC42();
    System.out.println(lc42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
