package fakru.leetcode;

import java.util.Arrays;

public class LC179 {

  public String largestNumber(int[] nums) {
    String[] numbers = new String[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      numbers[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(numbers, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
    if (numbers[0].equals("0")) {
      return "0";
    }
    StringBuilder result = new StringBuilder();
    for (String num : numbers) {
      result.append(num);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String s = new LC179().largestNumber(new int[]{0, 0, 0});
    System.out.println(s);
  }
}
