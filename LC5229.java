package fakru.leetcode;

public class LC5229 {

  public int maximumsSplicedArray(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int[] prefixNums1 = new int[n];
    int[] prefixNums2 = new int[n];
    prefixNums1[0] = nums1[0];
    prefixNums2[0] = nums2[0];
    for (int i = 1; i < n; ++i) {
      prefixNums1[i] = nums1[i] + prefixNums1[i - 1];
    }
    for (int i = 1; i < n; ++i) {
      prefixNums2[i] = nums2[i] + prefixNums2[i - 1];
    }
    int nums1Max = getMaxSum(nums1, nums2, n, prefixNums1, prefixNums2);
    int nums2Max = getMaxSum(nums2, nums1, n, prefixNums2, prefixNums1);
    return Math.max(nums1Max, nums2Max);
  }

  private int getMaxSum(int[] nums1, int[] nums2, int n, int[] prefixNums1, int[] prefixNums2) {

    // base is nums1
    int maxSum = prefixNums1[n - 1];
    int left = 0, right = 0;
    boolean isFirst = true;
    for (int i = 0; i < n; ++i) {
      if (nums2[i] > nums1[i]) {
        if (isFirst) {
          isFirst = false;
          left = i;
          right = i;
        } else {
          ++right;
        }
      } else {
        isFirst = true;
        int swapSum = prefixNums2[right] - (left <= 0 ? 0 : prefixNums2[left - 1]);
        int leftSum = left <= 0 ? 0 : prefixNums1[left - 1];
        // midSum = swapSum
        int rightSum = prefixNums1[n - 1] - prefixNums1[right];
        int currTotalSum = leftSum + swapSum + rightSum;
        maxSum = Math.max(maxSum, currTotalSum);
      }
    }
    if (right == n - 1) {
      int swapSum = prefixNums2[right] - (left <= 0 ? 0 : prefixNums2[left - 1]);
      int leftSum = left <= 0 ? 0 : prefixNums1[left - 1];
      // midSum = swapSum
      int rightSum = prefixNums1[n - 1] - prefixNums1[right];
      int currTotalSum = leftSum + swapSum + rightSum;
      maxSum = Math.max(maxSum, currTotalSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    LC5229 lc5229 = new LC5229();
    int i = lc5229.maximumsSplicedArray(new int[]{20, 40, 20, 70, 30},
        new int[]{50, 20, 50, 40, 20});
    System.out.println(i);
  }
}