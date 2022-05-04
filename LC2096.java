package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC2096 {

  private boolean findValue(TreeNode root, int value, StringBuilder s) {
    if (root.val == value) {
      return true;
    } else if (root.left != null && findValue(root.left, value, s)) {
      s.append("L");
    } else if (root.right != null && findValue(root.right, value, s)) {
      s.append("R");
    }
    return s.length() > 0;
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    StringBuilder s = new StringBuilder();
    StringBuilder d = new StringBuilder();
    findValue(root, startValue, s);
    findValue(root, destValue, d);
    int i = 0, lca = Math.min(s.length(), d.length());
    while (i < lca && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1)) {
      ++i;
    }
    return "U".repeat(s.length() - i) + d.reverse().substring(i);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);
    String directions = new LC2096().getDirections(root, 3, 4);
    System.out.println(directions);
  }
}
