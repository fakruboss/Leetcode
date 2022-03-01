package fakru.leetcode;

import static fakru.leetcode.node.TreeNode.preOrderPrint;

import fakru.leetcode.node.TreeNode;

public class LC1038 {

  int sum = 0;

  public void bstToGstHelper(TreeNode root) {
    if (root == null) {
      return;
    }
    bstToGstHelper(root.right);
    root.val += sum;
    sum = root.val;
    bstToGstHelper(root.left);
  }

  public TreeNode bstToGst(TreeNode root) {
    bstToGstHelper(root);
    return root;
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(4);
//    root.left = new TreeNode(1);
//    root.left.left = new TreeNode(0);
//    root.left.right = new TreeNode(2);
//    root.left.right.right = new TreeNode(3);
//    root.right = new TreeNode(6);
//    root.right.left = new TreeNode(5);
//    root.right.right = new TreeNode(7);
//    root.right.right.right = new TreeNode(8);

    TreeNode root = new TreeNode(0);
    root.right = new TreeNode(1);

    TreeNode treeNode = new LC1038().bstToGst(root);
    preOrderPrint(treeNode);
  }
}