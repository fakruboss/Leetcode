package fakru.leetcode;

public class LC1423 {

  public int maxScore(int[] cardPoints, int k) {
    int curr = 0, n = cardPoints.length;
    for (int i = n - k; i < n; ++i) {
      curr += cardPoints[i];
    }
    System.out.println(curr);
    int result = curr;
    for (int i = 1; i < n - k; ++i) {
      curr += cardPoints[i - 1] - cardPoints[n - k + i - 1];
      System.out.println(curr);
      result = Math.max(result, curr);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC1423().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
  }
}