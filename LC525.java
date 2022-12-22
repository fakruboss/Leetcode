package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC525 {

  public static void main(String[] args) {
    int maxLength = new LC525().findMaxLength(new int[]{1, 0, 1, 1, 1, 0, 0});
    System.out.println(maxLength);
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLen = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += (nums[i] == 1) ? 1 : -1;
      // Array from index 0 to i contains equal number of 0's and 1's
      if (count == 0) {
        maxLen = Math.max(maxLen, i + 1);
      }
      if (map.containsKey(count)) {
        maxLen = Math.max(maxLen, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }
    return maxLen;
  }
}
