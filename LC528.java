package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.Arrays;
import java.util.Random;

public class LC528 {

  private final int maxBound;
  private final Random random = new Random();
  private final int[] arr;

  public LC528(int[] w) {
    for (int i = 1; i < w.length; ++i) {
      w[i] += w[i - 1];
    }
    arr = w;
    maxBound = w[w.length - 1];
  }

  public int pickIndex() {
    int r = random.nextInt(maxBound);
    int result = Arrays.binarySearch(arr, r);
    return result;
  }

  public static void main(String[] args) {
    LC528 lc528 = new LC528(new int[]{1, 3});
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
    print(lc528.pickIndex());
  }
}