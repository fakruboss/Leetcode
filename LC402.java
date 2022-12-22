package fakru.leetcode;

public class LC402 {

  private StringBuilder buildLowestNumber(String num, int k, StringBuilder result) {
    if (k == 0) {
      return result.append(num);
    }
    if (num.length() == k) {
      return result;
    }
    int minIdx = 0;
    for (int i = 1; i <= k; ++i) {
      if (num.charAt(i) < num.charAt(minIdx)) {
        minIdx = i;
      }
    }
    result.append(num.charAt(minIdx));
    return buildLowestNumber(num.substring(minIdx + 1), k - minIdx, result);
  }

  public String removeKdigits(String num, int k) {
    String lowestNum = buildLowestNumber(num, k, new StringBuilder()).toString();
    for (int i = 0; i < lowestNum.length(); ++i) {
      if (lowestNum.charAt(i) != '0') {
        return lowestNum.substring(i);
      }
    }
    return "0";
  }

  public static void main(String[] args) {
    System.out.println(new LC402().removeKdigits("10056", 3));
  }
}