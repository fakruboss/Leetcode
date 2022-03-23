package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class LC18 {

  List<Integer> curr = new ArrayList<>();
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSumHelper(nums, target, 0, 4);
  }

  private List<List<Integer>> kSumHelper(int[] nums, int target, int index, int k) {
    if (k != 2) {
      for (int i = index; i < nums.length - k + 1; ++i) {
        if (i > index && nums[i] == nums[i - 1]) {
          continue;
        }
        curr.add(nums[i]);
        kSumHelper(nums, target - nums[i], i + 1, k - 1);
        curr.remove(curr.size() - 1);
      }
    } else {
      int left = index, right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum < target) {
          ++left;
        } else if (sum > target) {
          --right;
        } else {
          List<Integer> temp = new ArrayList<>(curr);
          temp.add(nums[left]);
          temp.add(nums[right]);
          result.add(temp);
          ++left;
          while (left < right && nums[left] == nums[left - 1]) {
            ++left;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }
}