package fakru.leetcode;

import java.util.*;

public class LC347 {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    Map<Integer, List<Integer>> bucket = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      int key = entry.getKey();
      bucket.computeIfAbsent(key, x -> new ArrayList<>());
      bucket.get(key).add(entry.getValue());
    }
    int[] result = new int[k];
    int resultIndex = 0;
    for (int i = nums.length; i > 0 && resultIndex != k; --i) {
      List<Integer> list = bucket.get(i);
      if (list == null) {
        continue;
      }
      for (Integer integer : list) {
        result[resultIndex++] = integer;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4};
    int[] ints = new LC347().topKFrequent(nums, 2);
    System.out.println(Arrays.toString(ints));
  }
}
