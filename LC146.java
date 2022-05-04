package fakru.leetcode;

import fakru.leetcode.node.DLLNode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache1 {

  private final int capacity;
  Map<Integer, Integer> cache;

  public LRUCache1(int capacity) {
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

/**
 * The idea is to have a map which stores the current active key, values and maintain two pointers
 * out of which one maintains the least used element (left) and another one maintains recently used
 * element (right).
 */
class LRUCache {

  private final Map<Integer, DLLNode> cache;
  private final int capacity;
  // maintain Least Recently Used (LRU) element
  DLLNode left;
  // maintain Most Recently Used (MRU) element
  DLLNode right;

  /**
   * a map to store the key value pairs. value will be the DLL node of that particular element.
   * right pointer and a left pointer both of which are connected and static. So, all the insertions
   * & removals will be between them.
   */
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    left = new DLLNode(-1, -1);
    right = new DLLNode(-1, -1);
    left.next = right;
    right.prev = left;
  }

  /**
   * This is an util function needed to maintain the mostly recently used element in the DLL. For
   * insert, it has to be inserted in the right most side. Since, the right most pointer is static,
   * insertion happens between that element and its previous element. After that insertion, the
   * newly inserted node also has to be connected between the static right and its previous node
   */
  private void insert(DLLNode node) {
    DLLNode prev = right.prev;
    DLLNode next = right;
    prev.next = node;
    next.prev = node;
    node.next = next;
    node.prev = prev;
  }

  /**
   * This is an util function to maintain the least frequently used element in the DLL. For remove,
   * it has to be removed in the left most side. Since, the left most pointer is static, removal
   * happens between that element and its next element. After removal, the existing left static node
   * has to be mapped to the removed node's next node
   */
  private void remove(DLLNode node) {
    DLLNode prev = node.prev;
    DLLNode next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  /**
   * During get, if the key is present in the map return the value else -1. the value will be
   * present only if it's one among the recently used element adhering to the capacity.
   * <p>
   * the get element should be the most recently element now. So, remove it from the DLL
   * (irrespective of its current position) and add it to the right most end
   */
  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    remove(cache.get(key));
    insert(cache.get(key));
    return cache.get(key).val;
  }

  /**
   * During put, the element can be just added directly to the map. Post addition if the capacity of
   * the map is greater than the allocated capacity, remove the least recently used element (can be
   * got from the left pointer in DLL) and remove the corresponding key from the map
   * <p>
   * w.r.t DLL, we have to add the new node to the right most point no matter what. Hence, in that
   * case, if the key is already present in the DLL, remove it since it will be added back
   * irrespective of the current state. For capacity overflow condition, get the least recently used
   * node from the left pointer and remove it from both DLL and map.
   */
  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    cache.put(key, new DLLNode(key, value));
    insert(cache.get(key));

    if (cache.size() > capacity) {
      DLLNode lru = left.next;
      remove(lru);
      cache.remove(lru.key);
    }
  }
}

public class LC146 {

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(5);
    lruCache.put(2, 2);
    lruCache.get(1);
  }
}