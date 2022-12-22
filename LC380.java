package fakru.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class LC380 {

  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();
    System.out.println(set.insert(1));
    System.out.println(set.insert(2));
    System.out.println(set.insert(3));
    System.out.println(set.insert(4));
    System.out.println(set.insert(5));
    System.out.println(set.remove(3));
    System.out.println(set.insert(6));
    System.out.println(set.remove(4));
    System.out.println(set.getRandom());
  }
}

class RandomizedSet {

  Random rand;
  List<Integer> nums;
  Map<Integer, Integer> locs;

  public RandomizedSet() {
    nums = new ArrayList<>();
    rand = new java.util.Random();
    locs = new HashMap<>();
  }

  public boolean insert(int val) {
    if (locs.containsKey(val)) {
      return false;
    }
    locs.put(val, nums.size());
    return nums.add(val);
  }

  public boolean remove(int val) {
    int ind = locs.getOrDefault(val, -1);
    if (ind == -1) {
      return false;
    }
    Collections.swap(nums, ind, nums.size() - 1);
    int swappedWith = nums.get(ind);
    locs.put(swappedWith, ind);
    nums.remove(nums.size() - 1);
    locs.remove(val);
    return true;
  }

  public int getRandom() {
    return nums.get(rand.nextInt(nums.size()));
  }
}