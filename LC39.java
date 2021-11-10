package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {

  private void generateLists(List<List<Integer>> result, List<Integer> currList,
      int[] nums, int remain, int start) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      result.add(new ArrayList<>(currList));
    } else {
      for (int i = start; i < nums.length; i++) {
        currList.add(nums[i]);
        generateLists(result, currList, nums, remain - nums[i], i);
        currList.remove(currList.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    generateLists(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  public static void main(String[] args) {
    new LC39().combinationSum(new int[]{2, 3, 6, 7}, 7);
  }
}
