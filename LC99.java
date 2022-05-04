package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC99 {

  TreeNode first = null, second = null;
  TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  /**
   *
   * @param root
   */
  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    if (prev.val > root.val) {
      if (first == null) {
        first = prev;
      }
      second = root;
    }
    inOrder(root.right);
  }

  public void recoverTree(TreeNode root) {
    inOrder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(2);
    new LC99().recoverTree(root);
  }
}
