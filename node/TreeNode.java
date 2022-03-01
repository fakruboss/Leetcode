package fakru.leetcode.node;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public static void preOrderPrint(TreeNode root) {
    if (root != null) {
      System.out.println(root.val);
      preOrderPrint(root.left);
      preOrderPrint(root.right);
    }
  }
}