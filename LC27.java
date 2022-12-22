package fakru.leetcode;

public class LC27 {

  public int removeElement(int[] nums, int val) {
    int count = 0;
    for (int i = 0, j = 0; j < nums.length; ++j) {
      if (nums[i] == nums[j]) {
        ++count;
      } else {
        nums[i++] = nums[j];
      }
    }
    return nums.length - count;
  }

  public static void main(String[] args) {
    int i = new LC27().removeElement(new int[]{3, 2, 2, 3}, 2);
    System.out.println(i);
  }
}
