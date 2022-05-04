package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

  List<int[]>[] lists;
  int bucketSize = 1009;

  public MyHashMap() {
    lists = new ArrayList[bucketSize];
    for (int i = 0; i < bucketSize; ++i) {
      lists[i] = new ArrayList<>();
    }
  }

  public void put(int key, int value) {
    int bucket = key % bucketSize;
    for (int i = 0, n = lists[bucket].size(); i < n; ++i) {
      if (lists[bucket].get(i)[0] == key) {
        lists[bucket].get(i)[1] = value;
        return;
      }
    }
    lists[bucket].add(new int[]{key, value});
  }

  public int get(int key) {
    int bucket = key % bucketSize;
    for (int i = 0, n = lists[bucket].size(); i < n; ++i) {
      if (lists[bucket].get(i)[0] == key) {
        return lists[bucket].get(i)[1];
      }
    }
    return -1;
  }

  public void remove(int key) {
    int bucket = key % bucketSize;
    for (int i = 0, n = lists[bucket].size(); i < n; ++i) {
      if (lists[bucket].get(i)[0] == key) {
        lists[bucket].remove(i);
      }
    }
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */

public class LC706 {

}

