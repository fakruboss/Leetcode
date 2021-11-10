package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * <p>Input: numRows = 5</p>
 * <p>Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]</p>
 */
public class LC118 {

  public static void main(String[] args) {
    PascalTriangle pascalTriangle = new PascalTriangle();
    List<List<Integer>> result = pascalTriangle.generate(5);
    result.forEach(row -> row.forEach(System.out::print));
  }
}

class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < numRows; ++i) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < i + 1; ++j) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
        }
      }
      result.add(row);
    }
    return result;
  }
}