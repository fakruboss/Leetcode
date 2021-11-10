package fakru.leetcode;

import java.util.Arrays;

public class LC31 {

  public static void main(String[] args) {
    NextPermutation nextPermutation = new NextPermutation();
    int[] nums = {1, 2, 3, 30, 12};
    nextPermutation.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

  }
}

class NextPermutation {

  public void nextPermutation(int[] nums) {
    int n = nums.length;
    boolean isSorted = false;
    for (int i = n - 2; i >= 0; --i) {
      if (nums[i] < nums[n - 1]) {
        int temp = nums[i];
        nums[i] = nums[n - 1];
        nums[n - 1] = temp;
        Arrays.sort(nums, i + 1, n);
        isSorted = true;
        break;
      }
    }
    if (!isSorted) {
      Arrays.sort(nums);
    }
  }
}

// Java program to find next greater
// number with same set of digits.
class nextGreater {

  // Utility function to swap two digit
  static void swap(char ar[], int i, int j) {
    char temp = ar[i];
    ar[i] = ar[j];
    ar[j] = temp;
  }

  // Given a number as a char array number[],
  // this function finds the next greater number.
  // It modifies the same array to store the result
  static void findNext(char ar[], int n) {
    int i;

    // I) Start from the right most digit
    // and find the first digit that is smaller
    // than the digit next to it.
    for (i = n - 1; i > 0; i--) {
      if (ar[i] > ar[i - 1]) {
        break;
      }
    }

    // If no such digit is found, then all
    // digits are in descending order means
    // there cannot be a greater number with
    // same set of digits
    if (i == 0) {
      System.out.println("Not possible");
    } else {
      int x = ar[i - 1], min = i;

      // II) Find the smallest digit on right
      // side of (i-1)'th digit that is greater
      // than number[i-1]
      for (int j = i + 1; j < n; j++) {
        if (ar[j] > x && ar[j] < ar[min]) {
          min = j;
        }
      }

      // III) Swap the above found smallest
      // digit with number[i-1]
      swap(ar, i - 1, min);

      // IV) Sort the digits after (i-1)
      // in ascending order
      Arrays.sort(ar, i, n);
      System.out.print("Next number with same" +
          " set of digits is ");
      for (i = 0; i < n; i++) {
        System.out.print(ar[i]);
      }
    }
  }

  public static void main(String[] args) {
    char digits[] = {'2', '3', '4', '5', '1'};
    int n = digits.length;
    findNext(digits, n);
  }
}

