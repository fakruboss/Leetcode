package fakru.leetcode;

public class LC307 {

}

class NumArray {

  class SegmentTreeNode {

    int start, end, sum;
    SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = null;
      this.right = null;
      this.sum = 0;
    }
  }

  SegmentTreeNode root = null;

  public NumArray(int[] nums) {
    root = buildTree(nums, 0, nums.length - 1);
  }

  private SegmentTreeNode buildTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    SegmentTreeNode st = new SegmentTreeNode(start, end);
    if (start == end) {
      st.sum = nums[start];
    } else {
      int mid = start + (end - start) / 2;
      st.left = buildTree(nums, start, mid);
      st.right = buildTree(nums, mid + 1, end);
      int leftSum = st.left == null ? 0 : st.left.sum;
      int rightSum = st.right == null ? 0 : st.right.sum;
      st.sum = leftSum + rightSum;
    }
    return st;
  }

  public void update(int index, int val) {
    update(root, index, val);
  }

  private void update(SegmentTreeNode root, int index, int val) {
    if (root.start == root.end) {
      root.sum = val;
    } else {
      int mid = root.start + (root.end - root.start) / 2;
      if (index <= mid) {
        update(root.left, index, val);
      } else {
        update(root.right, index, val);
      }
      root.sum = root.left.sum + root.right.sum;
    }
  }

  public int sumRange(int start, int end) {
    return sumRange(root, start, end);
  }

  private int sumRange(SegmentTreeNode root, int start, int end) {
    if (root.start == start && root.end == end) {
      return root.sum;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if (end <= mid) {
      return sumRange(root.left, start, end);
    }
    if (start >= mid + 1) {
      return sumRange(root.right, start, end);
    }
    return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
  }
}