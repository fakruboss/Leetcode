package fakru.leetcode;

public class LC1567 {

  public int getMaxLen(int[] nums) {
    // sum is used to count the number of negative numbers from zeroPosition to current index
    int firstNegative = -1, zeroPosition = -1, cntNegative = 0, max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        cntNegative++;
        if (firstNegative == -1) {
          firstNegative = i;
        }
      }
      if (nums[i] == 0) {
        cntNegative = 0;
        firstNegative = -1;
        zeroPosition = i;
      } else {
        if (cntNegative % 2 == 0) {
          max = Math.max(i - zeroPosition, max);
        } else {
          max = Math.max(i - firstNegative, max);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    LC1567 lc1567 = new LC1567();
    lc1567.getMaxLen(new int[]{1, -2, -3, 4});
  }
}
