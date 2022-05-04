package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC526 {

  int count = 0;

  public int countArrangement(int n) {
    int[] nums = new int[n];
    for (int i = 1; i <= n; ++i) {
      nums[i - 1] = i;
    }
    backtrack(nums, new boolean[n], new ArrayList<>());
    return count;
  }

  private void backtrack(int[] nums, boolean[] used, List<Integer> curr) {
    if (curr.size() == nums.length) {
      ++count;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      curr.add(nums[i]);
      int size = curr.size();
      if ((curr.get(size - 1) % size == 0) || (size % curr.get(size - 1) == 0)) {
        backtrack(nums, used, curr);
      }
      used[i] = false;
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    int i = new LC526().countArrangement(25);
    System.out.println(i);
  }
}
