package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC2265 {

  int result = 0;

  public int averageOfSubtree(TreeNode root) {
    dfs(root);
    return result;
  }

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    int currSum = left[0] + right[0] + root.val;
    int currCount = left[1] + right[1] + 1;

    if (currSum / currCount == root.val) {
      ++result;
    }

    return new int[]{currSum, currCount};
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(8);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.right = new TreeNode(6);

    new LC2265().averageOfSubtree(root);
  }
}
