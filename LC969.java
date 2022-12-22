package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC969 {

  public static void main(String[] args) {
    List<Integer> integers = new LC969().pancakeSort(new int[]{3, 2, 4, 1});
    System.out.println(integers);
  }

  private void reverse(int[] nums, int right) {
    int left = 0;
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      ++left;
      --right;
    }
  }

  private int getIndex(int[] nums, int index) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == index) {
        return i;
      }
    }
    return -1;
  }

  public List<Integer> pancakeSort(int[] arr) {
    List<Integer> result = new ArrayList<>();
    int n = arr.length;
    for (int i = n; i > 0; i--) {
      int idx = getIndex(arr, i);
      if (idx != 0) {
        result.add(idx + 1);
      }
      reverse(arr, idx);
      if (i != 1) {
        result.add(i);
      }
      reverse(arr, i - 1);
    }
    return result;
  }
}