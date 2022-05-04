package fakru.leetcode;

public class EqualSum {

  String equilibrium(int[] nums, int n) {
    if (n == 1) {
      return "YES";
    }
    if (n == 2) {
      return "NO";
    }
    int total = 0, currSum = 0;
    for (int num : nums) {
      total += num;
    }
    for (int num : nums) {
      if (total - num - currSum == currSum) {
        return "YES";
      }
      currSum += num;

    }
    return "NO";
  }

  public static void main(String[] args) {
    int[] nums = {10, 1, 5, 10, 10, 5, 6, 4, 7, 7, 10, 1, 7, 6, 5, 1, 7, 9, 4, 2, 7, 2, 8};
    String result = new EqualSum().equilibrium(nums, nums.length);
    System.out.println(result);
  }
}
