package fakru.leetcode;

public class LC926 {

  /**
   * The problem can be solved in the angle of string construction. The resultant string should
   * contain 0's only in the front. By that logic, the result can be a string with all 0's or 0's at
   * the front and 1's at last. Therefore, while traversing each character in the string, let's say
   * we are just constructing the string from scratch and if the new character is '1'. It can be
   * simply appended to the string. If it's 0, the case can either be just flipping it and appending
   * or appending all the 1's present in the string, whichever is minimal
   *
   * @param s input string
   * @return minimum flips required to make the string monotonous
   */
  public int minFlipsMonoIncr(String s) {
    int flips = 0, onesCount = 0;
    for (char c : s.toCharArray()) {
      if (c == '1') {
        ++onesCount;
      } else {
        flips = Math.min(flips + 1, onesCount);
      }
    }
    return flips;
  }

  public static void main(String[] args) {
    System.out.println(new LC926().minFlipsMonoIncr("001110000"));
  }
}
