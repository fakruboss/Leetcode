package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.Arrays;
import java.util.List;

class HourMinute {

  Integer hour;
  Integer minute;

  public HourMinute(String timePoint) {
    this.hour = Integer.parseInt(timePoint.substring(0, 2));
    this.minute = Integer.parseInt(timePoint.substring(3));
  }
}

public class LC539 {

  private int getMinsDiff(int h1, int m1, int h2, int m2) {
    if (h1 == h2) {
      return m2 - m1;
    }
    int diff = m2 + (60 - m1);
    if (h2 - h1 != 1) {
      diff += (h2 - h1 - 1) * 60;
    }
    return diff;
  }

  public int findMinDifference(List<String> timePoints) {
    int minDiff = Integer.MAX_VALUE;
    timePoints.sort((t1, t2) -> {
      HourMinute hm1 = new HourMinute(t1);
      HourMinute hm2 = new HourMinute(t2);

      int hourCompare = hm1.hour.compareTo(hm2.hour);
      int minsCompare = hm1.minute.compareTo(hm2.minute);
      return hourCompare != 0 ? hourCompare : minsCompare;
    });
    print(timePoints);
    int n = timePoints.size();
    for (int i = 1; i < n; ++i) {
      HourMinute hm1 = new HourMinute(timePoints.get(i - 1));
      HourMinute hm2 = new HourMinute(timePoints.get(i));
      minDiff = Math.min(minDiff, getMinsDiff(hm1.hour, hm1.minute, hm2.hour, hm2.minute));
    }
    HourMinute last = new HourMinute(timePoints.get(n - 1));
    HourMinute first = new HourMinute(timePoints.get(0));
    minDiff = Math.min(minDiff, getMinsDiff(last.hour, last.minute, first.hour + 24, first.minute));
    return minDiff;
  }

  public static void main(String[] args) {
    int minDifference = new LC539().findMinDifference(
        Arrays.asList("00:01", "00:43", "01:23", "03:23", "02:21", "00:59", "02:58"));
    print(minDifference);
  }
}
