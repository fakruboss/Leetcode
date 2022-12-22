package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC659 {

  public static void main(String[] args) {
    new LC659().isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
  }

  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> availabilityMap = new HashMap<>(),
        vacancyMap = new HashMap<>();
    for (int num : nums) {
      availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) + 1);
    }
    for (int num : nums) {
      if (availabilityMap.get(num) <= 0) {
        continue;
      }
      if (vacancyMap.getOrDefault(num, 0) > 0) {
        vacancyMap.put(num, vacancyMap.get(num) - 1);
        vacancyMap.put(num + 1, vacancyMap.get(num + 1) + 1);
        availabilityMap.put(num, availabilityMap.get(num) - 1);
      } else if (availabilityMap.get(num) > 0
          && availabilityMap.getOrDefault(num + 1, 0) > 0
          && availabilityMap.getOrDefault(num + 2, 0) > 0) {
        availabilityMap.put(num, availabilityMap.get(num) - 1);
        availabilityMap.put(num + 1, availabilityMap.get(num + 1) - 1);
        availabilityMap.put(num + 2, availabilityMap.get(num + 2) - 1);

        vacancyMap.put(num + 3, vacancyMap.getOrDefault(num + 3, 0) + 1);
      } else {
        return false;
      }
    }
    return true;
  }
}
