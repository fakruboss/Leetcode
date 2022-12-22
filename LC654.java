package fakru.leetcode;

import fakru.leetcode.node.TreeNode;

public class LC654 {

  public int max(int[] nums, int l, int r) {
    int maxIdx = l;
    for (int i = l + 1; i <= r; i++) {
      if (nums[i] > nums[maxIdx]) {
        maxIdx = i;
      }
    }
    return maxIdx;
  }

  public TreeNode constructMaxBTHelper(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }
    int maxIdx = max(nums, l, r);
    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = constructMaxBTHelper(nums, l, maxIdx - 1);
    root.right = constructMaxBTHelper(nums, maxIdx + 1, r);
    return root;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaxBTHelper(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    LC654 lc654 = new LC654();
    TreeNode treeNode = lc654.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
  }
}
