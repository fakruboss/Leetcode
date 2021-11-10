package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class LC105 {

  private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inMap,
      int inStart, int inEnd) {
    if (preStart >= preEnd || inStart >= inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inMid = inMap.get(root.val);
    int numsLeft = inMid - inStart;
    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft + 1, inMap, inStart, inMid);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inMap, inMid + 1, inEnd);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    int n = inorder.length;
    for (int i = 0; i < n; ++i) {
      inMap.put(inorder[i], i);
    }
    return buildTree(preorder, 0, n, inMap, 0, n);
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    TreeNode.preOrderPrint(new LC105().buildTree(preorder, inorder));
  }
}