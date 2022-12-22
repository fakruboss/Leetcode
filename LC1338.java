package fakru.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1338 {

  public int minSetSize(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list);
    int count = 0, currSize = arr.length;
    for (int i = list.size() - 1; i >= 0; --i) {
      if (currSize <= n / 2) {
        break;
      }
      currSize -= list.get(i);
      ++count;
    }
    return count;
  }
}
