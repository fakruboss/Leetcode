package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1282 {

  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> store = new HashMap<>();
    for (int i = 0; i < groupSizes.length; ++i) {
      store.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
      List<Integer> currGroup = store.get(groupSizes[i]);
      if (currGroup == null) {
        currGroup = new ArrayList<>();
      }
      currGroup.add(i);
      store.put(groupSizes[i], currGroup);
    }
    for (Map.Entry<Integer, List<Integer>> entry : store.entrySet()) {
      int key = entry.getKey();
      List<Integer> group = entry.getValue();
      int groupSize = group.size();
      for (int i = key; i <= groupSize; i += key) {
        result.add(group.subList(i - key, i));
      }
    }
    return result;
  }
}
