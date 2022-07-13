package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(n, k, result, new ArrayList<>(), 1);
    return result;
  }

  private void backtrack(int n, int k, List<List<Integer>> result,
      List<Integer> curr, int start) {
    if (curr.size() == k) {
      result.add(new ArrayList<>(curr));
      return;
    }

    for (int i = start; i <= n; ++i) {
      curr.add(i);
      backtrack(n, k, result, curr, i + 1);
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = new LC77().combine(4, 2);
    System.out.println(combine);
  }
}
