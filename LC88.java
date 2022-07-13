package fakru.leetcode;

import java.util.Arrays;

public class LC88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0, k = m + n - 1;
    while (i < m && j < n) {
      System.out.println(nums1[i] + " " + nums2[j]);
      if (nums1[i] < nums2[j]) {
        nums1[k--] = nums1[i++];
      } else {
        nums1[k--] = nums2[j++];
      }
      System.out.println(Arrays.toString(nums1));
    }
    while (i < m) {
      nums1[k--] = nums1[i++];
    }
    while (j < n) {
      nums1[k--] = nums2[j++];
    }
    int len = m + n;
    for (int idx = 0; idx < len / 2; ++idx) {
      int temp = nums1[idx];
      nums1[idx] = nums1[len - idx - 1];
      nums1[len - idx - 1] = temp;
    }
  }

  public static void main(String[] args) {
    new LC88().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
  }
}
