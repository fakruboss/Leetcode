package fakru.leetcode;

public class LC33 {

  public static void main(String[] args) {
    int x = new LC33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
  }

  public int search(int[] nums, int target) {
    return pivotedSearch(nums, target);
  }

  private int pivotedSearch(int[] nums, int target) {
    int n = nums.length - 1;
    int pivot = findPivot(nums, 0, n);
    if (pivot == -1) {
      return binarySearch(nums, target, 0, n);
    }
    if (nums[pivot] == target) {
      return pivot;
    }
    if (nums[0] <= target) {
      return binarySearch(nums, target, 0, pivot - 1);
    } else {
      return binarySearch(nums, target, pivot + 1, n);
    }
  }

  private int findPivot(int[] nums, int left, int right) {
    if (left > right) {
      return -1;
    }
    int mid = left + (right - left) / 2;
    if (mid < right && nums[mid] > nums[mid + 1]) {
      return mid;
    } else if (mid > left && nums[mid - 1] > nums[mid]) {
      return mid - 1;
    }
    if (nums[left] >= nums[mid]) {
      return findPivot(nums, left, mid - 1);
    } else {
      return findPivot(nums, mid + 1, right);
    }
  }

  private int binarySearch(int[] nums, int target, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
