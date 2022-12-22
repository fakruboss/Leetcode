package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC543 {

  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return max;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    max = Math.max(max, left + right);
    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    LC543 lc543 = new LC543();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(7);

    int i = lc543.diameterOfBinaryTree(root);
    System.out.println(i);
  }
}