package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {

  public int minimumTotal(List<List<Integer>> triangle) {
    int rows = triangle.size();
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < rows; ++i) {
      result.add(new ArrayList<>());
    }
    int val = triangle.get(0).get(0);
    result.get(0).add(val);
    int minSum = val;
    for (int i = 1; i < rows; ++i) {
      minSum = Integer.MAX_VALUE;
      List<Integer> currRow = triangle.get(i);
      List<Integer> prevResultRow = result.get(i - 1);
      for (int j = 0, n = currRow.size(); j < n; ++j) {
        if (j == 0) {
          val = prevResultRow.get(0);
        } else if (j == n - 1) {
          val = prevResultRow.get(prevResultRow.size() - 1);
        } else {
          val = Math.min(prevResultRow.get(j - 1), prevResultRow.get(j));
        }
        val += currRow.get(j);
        result.get(i).add(val);
        minSum = Math.min(minSum, val);
      }
    }
    return minSum;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(2));
    list.add(Arrays.asList(3, 4));
    list.add(Arrays.asList(6, 5, 7));
    list.add(Arrays.asList(4, 1, 8, 3));

    int i = new LC120().minimumTotal(list);
    System.out.println(i);
  }
}