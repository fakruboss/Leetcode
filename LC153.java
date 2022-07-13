package fakru.leetcode;

public class LC153 {

  /**
   * find the pivot in the sorted array. Find the middle index of the array. We can compare the
   * middle index element with either the previous element and next element and see if the pivot is
   * present there. If mid is greater than next, mid is the pivot. If the prev is greater than mid,
   * prev is the pivot.
   * <p>
   * If both cases are failed, the pivot will either be in the left half or the right half. Compare
   * the leftmost element in the partition with the mid-element. If mid is greater, the first half
   * is in ascending order and the pivot will be in the latter half. So, ignore the first and
   * consider just the latter half. Else, vice versa
   */
  public int findMin(int[] nums) {
    int pivot = findPivot(nums, 0, nums.length - 1);
    return pivot == -1 ? nums[0] : nums[pivot + 1];
  }

  private int findPivot(int[] nums, int left, int right) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (mid < right && nums[mid] > nums[mid + 1]) {
      return mid;
    } else if (mid > left && nums[mid - 1] > nums[mid]) {
      return mid - 1;
    }

    if (nums[left] > nums[mid]) {
      return findPivot(nums, left, mid - 1);
    } else {
      return findPivot(nums, mid + 1, right);
    }
  }

  public static void main(String[] args) {
    int min = new LC153().findMin(new int[]{19, 11, 13, 15, 17});
    System.out.println(min);
  }
}