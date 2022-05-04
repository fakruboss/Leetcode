package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform DFS. At the end of each step, if it's null, add 1 to the existing value, since, that
 * marks the end of the path
 */
public class LC366 {

  private int findLevel(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return -1;
    }
    int level = Math.max(findLevel(root.left, result), findLevel(root.right, result)) + 1;
    if (result.size() <= level) {
      result.add(new ArrayList<>());
    }
    result.get(level).add(root.val);
    return level;
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    findLevel(root, result);
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    List<List<Integer>> leaves = new LC366().findLeaves(root);
    System.out.println(leaves);
  }
}
