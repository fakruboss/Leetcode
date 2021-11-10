package fakru.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 {

  private int capacity;
  Map<Integer, Integer> cache;

  public LC146(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>();
  }

  public int get(int key) {
    Integer value = cache.get(key);
    if (value == null) {
      return -1;
    }
    cache.remove(key);
    cache.put(key, value);
    return cache.get(key);
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      cache.remove(key);
    } else if (cache.size() == capacity) {
      cache.remove(cache.keySet().iterator().next());
    }
    cache.put(key, value);
  }
}
