package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC207 {

  Set<Integer> visited = new HashSet<>();
  List<Integer> list = new ArrayList<>();

  private boolean dfs(int course, Map<Integer, List<Integer>> preMap) {
    if (visited.contains(course)) {
      return false;
    }
    if (preMap.get(course).isEmpty()) {
      if (!list.contains(course)) {
        list.add(course);
      }
      return true;
    }
    visited.add(course);
    for (int childCourse : preMap.get(course)) {
      if (!dfs(childCourse, preMap)) {
        return false;
      }
    }
    visited.remove(course);
    preMap.put(course, new ArrayList<>());
    list.add(course);
    return true;
  }

  public int[] canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    for (int i = 0; i < numCourses; ++i) {
      preMap.put(i, new ArrayList<>());
    }
    for (int[] pre : prerequisites) {
      preMap.get(pre[0]).add(pre[1]);
    }
    System.out.println(preMap);

    for (int i = 0; i < numCourses; ++i) {
      if (!dfs(i, preMap)) {
        return new int[]{};
      }
    }

    System.out.println(list);
    int[] result = new int[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      result[i] = list.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    LC207 lc207 = new LC207();
//    int[][] pre = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}, {2, 1}};
    int[][] pre = {{1, 0}};
    int[] ints = lc207.canFinish(2, pre);
    System.out.println(Arrays.toString(ints));
  }
}