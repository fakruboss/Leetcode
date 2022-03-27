package fakru.leetcode.wc286;

import java.util.*;

public class LC2215 {

  private Set<Integer> getIntersectionSet(int[] thisNums, int[] thatNums) {
    Set<Integer> tempSet = new HashSet<>();
    Set<Integer> resultSet = new HashSet<>();
    for (int num : thatNums) {
      tempSet.add(num);
    }
    for (int num : thisNums) {
      if (!tempSet.contains(num)) {
        resultSet.add(num);
      }
    }
    return resultSet;
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>(getIntersectionSet(nums1, nums2)));
    result.add(new ArrayList<>(getIntersectionSet(nums2, nums1)));
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> difference = new LC2215().findDifference(
        new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
    System.out.println(difference);
  }
}
