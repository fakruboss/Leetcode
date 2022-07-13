package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(nums, result, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result, boolean[] used,
      List<Integer> curr) {
    if (curr.size() == nums.length) {
      result.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
        continue;
      }
      used[i] = true;
      curr.add(nums[i]);
      backtrack(nums, result, used, curr);
      used[i] = false;
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = new LC47().permuteUnique(new int[]{1, 1, 1, 2});
    System.out.println(lists);
  }
}