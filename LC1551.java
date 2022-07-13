package fakru.leetcode;

public class LC1551 {

  public int minOperations(int n) {
    int[] nums = new int[(n / 2) + 1];
    for (int i = 0; i <= n / 2; ++i) {
      nums[i] = (2 * i) + 1;
    }
    int count = 0;
    int mid = (n & 1) == 1
        ? nums[n / 2]
        : (nums[n / 2] + nums[(n / 2) - 1]) / 2;
    for (int i = 0; i < n / 2; ++i) {
      count += mid - nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    int i = new LC1551().minOperations(6);
    System.out.println(i);
  }
}
