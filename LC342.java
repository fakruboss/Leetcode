package fakru.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC342 {

  public static void main(String[] args) {
//    new LC342().isPowerOfFour(15);
    test();
  }

  public boolean isPowerOfFour(int num) {
    double logNum = Math.log(num);
    double logFour = Math.log(4);
    double v = logNum / logFour;
    double res = v % 1;
    return res == 0;
  }

  private static void test() {
    IntStream intStream = IntStream.rangeClosed(0, 10).filter(x -> x % 2 == 0);
    Stream<Integer> boxed = intStream.boxed();
    List<Integer> collect = boxed.collect(Collectors.toList());
    System.out.println(collect);
  }
}