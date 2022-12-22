package fakru.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class LC740 {

  public int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + num);
    }
    System.out.println(map);
    int prev1 = 0, prev2 = 0, curr = 0;
    for (int key : map.keySet()) {
      if (!map.containsKey(key - 1)) {
        curr += map.get(key);
      } else {
        curr = Math.max(map.get(key) + prev2, prev1);
      }
      prev2 = prev1;
      prev1 = curr;
    }
    return Math.max(prev1, prev2);
  }

  public static void main(String[] args) {
    new LC740().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
  }
}
