package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.Collections;

public class LC226 {

  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode tempRight = root.right;
      root.right = invertTree(root.left);
      root.left = invertTree(tempRight);
    }
    return root;
  }

  public static void main(String[] args) {
    LC226 lc226 = new LC226();

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    lc226.invertTree(root);
  }
}