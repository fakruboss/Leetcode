package fakru.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC416 {

  // SOLUTION 1 : BACKTRACKING
  private boolean canPartition(int[] nums, int total, int index, int currSum) {
    if (currSum == total / 2) {
      return true;
    }
    if (index == nums.length) {
      return false;
    }
    return canPartition(nums, total, index + 1, currSum + nums[index])
        || canPartition(nums, total, index + 1, currSum);
  }

  public boolean canPartition2(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    if (total % 2 == 1) {
      return false;
    }
    return canPartition(nums, total, 0, 0);
  }

  // SOLUTION 2 : KIND OF MEMOIZATION
  public boolean canPartition(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    if (total % 2 == 1) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    set.add(0);
    for (int num : nums) {
      Set<Integer> tempSet = new HashSet<>();
      for (int s : set) {
        if (s + num == total / 2) {
          return true;
        }
        tempSet.add(s);
        tempSet.add(s + num);
      }
      set = tempSet;
    }
    return set.contains(total / 2);
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(new LC416().canPartition(
        new int[]{1, 5, 11, 5}));
    System.out.println(System.currentTimeMillis() - startTime);
  }
}