package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LC432 {

}

class AllOne {

  Map<String, Integer> wordCount;
  TreeMap<Integer, List<String>> countWords;

  public AllOne() {
    wordCount = new HashMap<>();
    countWords = new TreeMap<>();
  }

  public void inc(String key) {
    int currentCount = wordCount.getOrDefault(key, 0);
    wordCount.put(key, currentCount + 1);

    List<String> list = countWords.get(currentCount);
    if (list != null && list.contains(key)) {
      list.remove(key);
      if (list.isEmpty()) {
        countWords.remove(currentCount);
      }
    }
    countWords.computeIfAbsent(currentCount + 1, x -> new ArrayList<>()).add(key);
  }

  public void dec(String key) {
    int currentCount = wordCount.getOrDefault(key, 0);
    if (currentCount != 0) {
      wordCount.put(key, currentCount - 1);
    }

    List<String> list = countWords.get(currentCount);
    if (list != null && list.contains(key)) {
      list.remove(key);
      if (list.isEmpty()) {
        countWords.remove(currentCount);
      }
    }
    if (currentCount > 1) {
      countWords.computeIfAbsent(currentCount - 1, x -> new ArrayList<>()).add(key);
    }
  }

  public String getMaxKey() {
    Set<Integer> set = countWords.descendingKeySet();
    if (set == null || set.isEmpty()) {
      return "";
    }
    int maxKey = set.iterator().next();
    return countWords.get(maxKey).get(0);
  }

  public String getMinKey() {
    Set<Integer> set = countWords.keySet();
    if (set.isEmpty()) {
      return "";
    }
    int minKey = set.iterator().next();
    return countWords.get(minKey).get(0);
  }
}
