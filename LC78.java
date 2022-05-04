package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solving this using the backtracking method. Start from the first element and traverse down to all
 * the combinations like a DFS tree. Like for each element, start a new traversal from that element
 * and at the end of that traversal, remove that element and proceed again with the next element
 */
public class LC78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> subsets = new LC78().subsets(new int[]{1, 2, 3, 3});
    System.out.println(subsets);
  }
}