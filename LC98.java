package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC98 {

  private boolean isValidBST(TreeNode root, Integer left, Integer right) {
    if (root == null) {
      return true;
    }
    if ((left != null && root.val <= left) || (right != null && root.val >= right)) {
      return false;
    }
    return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2147483647);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    System.out.println(new LC98().isValidBST(root));
  }
}