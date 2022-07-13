package fakru.leetcode;

import fakru.leetcode.utils.PrintUtils;

public class LC1342 {

  /**
   * if num is even, we have to divide by 2 and add 1 to the count. right shift by 1 (>> 1) is equal
   * to divide by 2. If it's odd, we have to subtract 1 (post which it becomes odd) and divide by 2.
   * so, right shift by 1 does the job here too, but we have to count it as 2. At last, while
   * returning, we are returning the count reduced by 1, because when num becomes 1, we just have to
   * subtract by 1. but, by default we are doing both. Hence, the extra step has to be reduced.
   */
  public int numberOfSteps(int num) {
    int count = 0;
    while (num != 0) {
      count += (num & 1) == 1 ? 2 : 1;
      num = num >> 1;
    }
    return count - 1;
  }

  public static void main(String[] args) {
    int i = new LC1342().numberOfSteps(13);
    PrintUtils.print(i);
  }
}
