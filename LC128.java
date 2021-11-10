package fakru.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LC128 {

  public int longestConsecutive(int[] nums) {
    int maxLength = 0, currLength = 0;
    SortedSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
      set.add(num);
    }
    Integer prev = null;
    for (int num : set) {
      if (prev == null || num == prev + 1) {
        ++currLength;
      } else {
        maxLength = Math.max(currLength, maxLength);
        currLength = 1;
      }
      prev = num;
    }
    return Math.max(currLength, maxLength);
  }

  public int longestConsecutive2(int[] nums) {
    int maxLength = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int currLength = 0;
        while (set.contains(num + currLength)) {
          ++currLength;
        }
        maxLength = Math.max(maxLength, currLength);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(
        new LC128().longestConsecutive2(new int[]{-8, -4, 9, 9, 4, 6, 1, -4, -1, 6, 8}));
  }
}
