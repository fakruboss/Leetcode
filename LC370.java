package fakru.leetcode;

import java.util.Arrays;

public class LC370 {

  public int[] getModifiedArray(int length, int[][] updates) {
    int[] result = new int[length];
    if (updates == null || updates.length == 0) {
      return result;
    }

    for (int[] update : updates) {
      result[update[0]] += update[2];
      if (update[1] < length - 1) {
        result[update[1] + 1] -= update[2];
      }
    }

    for (int i = 1; i < length; i++) {
      result[i] += result[i - 1];
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] updates = {{1, 2, 1}, {2, 3, 2}, {0, 3, 3}};
    int[] modifiedArray = new LC370().getModifiedArray(4, updates);
    int[] nums = {1, 3, 5, 7};
    for (int i = 0; i < nums.length; ++i) {
      nums[i] += modifiedArray[i];
    }
    System.out.println(Arrays.toString(nums));
  }
}
