package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC606 {

  /**
   * Order of the traversal is root, root.left..., root.right,.... So, first we can add the root.val
   * into the result. Post that the left node has to be considered in a recursive mannder and then
   * right. If both the child nodes are null, we can cut that path. After the above condition, it's
   * obvious that if left child is null, right child has to be present & vice versa. So, no matter
   * whether the left child is null or not, we have to add the paranthesis whereas it's not the case
   * of right child. since, it has to be added only on the presence of it. Hence, without any
   * precheck, we are adding the paranthesis with left child's value inside it. and for the right
   * child, we are checking for the nullability and then wrapping it around the paranthesis
   *
   * @param root
   * @return
   */
  public String tree2str(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder result = new StringBuilder(root.val + "");
    if (root.left == null && root.right == null) {
      return result.toString();
    }

    result.append("(").append(tree2str(root.left)).append(")");

    if (root.right != null) {
      result.append("(").append(tree2str(root.right)).append(")");
    }

    return result.toString();
  }
}
