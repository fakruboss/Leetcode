package fakru.leetcode;

public class LC287 {

  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (fast != slow);
    slow = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }

  public static void main(String[] args) {
    new LC287().findDuplicate(new int[]{1, 3, 4, 2, 2});
  }
}
