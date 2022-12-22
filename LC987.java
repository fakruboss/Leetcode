package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC987 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
    List<List<Integer>> lists = new LC987().verticalTraversal(root);
    System.out.println(lists);
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, List<int[]>> map = new TreeMap<>();
    dfs(root, map, 0, 0);
    List<List<Integer>> result = new ArrayList<>();
    for (List<int[]> list : map.values()) {
      list.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
      List<Integer> temp = new ArrayList<>();
      for (int[] l : list) {
        temp.add(l[0]);
      }
      result.add(temp);
    }
    return result;
  }

  private void dfs(TreeNode root, Map<Integer, List<int[]>> map,
      int row, int col) {
    if (root == null) {
      return;
    }
    map.computeIfAbsent(col, i -> new ArrayList<>())
        .add(new int[]{root.val, row, col});
    dfs(root.left, map, row + 1, col - 1);
    dfs(root.right, map, row + 1, col + 1);
  }
}
