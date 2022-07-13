package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC968 {

  private int camera = 0;

  public int minCameraCover(TreeNode root) {
    return dfs(root) == 0 ? 1 + camera : camera;
  }

  /**
   * 0 -> not covered 1 -> covered by other camera 2 -> has camera (at that node)
   */
  private int dfs(TreeNode root) {
    if (root == null) {
      return 1;
    }

    int left = dfs(root.left);
    int right = dfs(root.right);

    // execution order mukkiyam bigil-u
    if (left == 0 || right == 0) {
      ++camera;
      return 2;
    } else if (left == 2 || right == 2) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);

    int i = new LC968().minCameraCover(root);
    System.out.println(i);
  }
}
