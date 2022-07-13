package fakru.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1817 {

  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    int[] result = new int[k];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] log : logs) {
      map.computeIfAbsent(log[0], l -> new HashSet<>());
      map.get(log[0]).add(log[1]);
    }
    for (Set<Integer> set : map.values()) {
      ++result[set.size() - 1];
    }
    return result;
  }

  public static void main(String[] args) {
//    int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
    int[][] logs = {{1, 1}, {2, 2}, {2, 3}};
    int[] ints = new LC1817().findingUsersActiveMinutes(logs, 4);
    System.out.println(Arrays.toString(ints));
  }
}
