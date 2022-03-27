package fakru.leetcode.utils;

import java.util.Arrays;

public class PrintUtils {

  private PrintUtils() {
  }

  public static void print(String s) {
    System.out.println(s);
  }

  public static void print(boolean b) {
    System.out.println(b);
  }

  public static void print(Integer x) {
    System.out.println(x);
  }

  public static void print(Long x) {
    System.out.println(x);
  }

  public static void print(long[] x) {
    System.out.println(Arrays.toString(x));
  }

}