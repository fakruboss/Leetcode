package fakru.leetcode;

import java.util.Arrays;

public class LC1471 {

  /**
   * find the median using the given formula. Irrespective of odd or even length, take the element
   * in (n - 1) / 2 th index element in the array after sorting. Since, we have the sorted array
   * now, the max strongest element will either be in the left or right extreme since that is the
   * farthest from the median. Using two pointer, compare both extremes for the strongest element
   * and move the pointer accordingly till k elements are found
   */
  public int[] getStrongest(int[] arr, int k) {
    int[] result = new int[k];
    Arrays.sort(arr);
    int n = arr.length;
    int median = arr[(n - 1) / 2];
    int left = 0, right = n - 1;
    while (k-- > 0) {
      int x = Math.abs(arr[left] - median);
      int y = Math.abs(arr[right] - median);
      result[k] = x > y ? arr[left++] : arr[right--];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int[] strongest = new LC1471().getStrongest(nums, 2);
    System.out.println(Arrays.toString(strongest));
  }

}
