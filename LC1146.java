package fakru.leetcode;

import java.util.TreeMap;

public class LC1146 {

  public static void main(String[] args) {
    SnapshotArray array = new SnapshotArray(3);
    array.set(0, 5);
    int snap = array.snap();
    array.set(0, 6);
    System.out.println(array.get(0, snap));
  }
}

class SnapshotArray {

  TreeMap<Integer, Integer>[] map;
  int snapId;

  public SnapshotArray(int length) {
    map = new TreeMap[length];
    for (int i = 0; i < length; ++i) {
      map[i] = new TreeMap<>();
      map[i].put(0, 0);
    }
    snapId = 0;
  }

  public void set(int index, int val) {
    map[index].put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snap_id) {
    return map[index].floorEntry(snap_id).getValue();
  }
}