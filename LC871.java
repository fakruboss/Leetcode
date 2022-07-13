package fakru.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC871 {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (startFuel >= target) {
      return 0;
    }
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    int position = 0, n = stations.length, stops = 0, maxDistance = startFuel;
    while (maxDistance < target) {
      while (position < n && stations[position][0] <= maxDistance) {
        queue.offer(stations[position++][1]);
      }
      if (queue.isEmpty()) {
        return -1;
      }
      maxDistance += queue.poll();
      stops++;
    }
    return stops;
  }

  public static void main(String[] args) {
    int[][] stations = {{10, 25}, {20, 12}, {30, 21}, {40, 5}, {50, 3}};
    new LC871().minRefuelStops(100, 50, stations);
  }
}