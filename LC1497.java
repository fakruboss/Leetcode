package fakru.leetcode;

public class LC1497 {

  public static void main(String[] args) {
    boolean b = new LC1497().canArrange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
  }

  public boolean canArrange(int[] arr, int k) {
    int[] freq = new int[k];
    for (int num : arr) {
      num %= k;
      if (num < 0) {
        num += k;
      }
      ++freq[num];
    }
    if (freq[0] % 2 != 0) {
      return false;
    }
    for (int i = 1; i <= k / 2; ++i) {
      if (freq[i] != freq[k - i]) {
        return false;
      }
    }
    return true;
  }
}
