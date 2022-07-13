package fakru.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC630 {

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int time = 0;
    for (int[] course : courses) {
      time += course[0];
      pq.offer(course[0]);
      if (time > course[1]) {
        time -= pq.poll();
      }
    }
    return pq.size();
  }

  public static void main(String[] args) {
    int[][] courses = {{4, 6}, {2, 5}, {3, 7}};
    new LC630().scheduleCourse(courses);
  }
}

// 3, 5
// 4, 5
// 2, 5
// 4, 6