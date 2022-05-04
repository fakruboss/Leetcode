package fakru.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
public class LC1405 {

  class Pair {

    int count;
    char key;

    public Pair(int count, char key) {
      this.count = count;
      this.key = key;
    }
  }

  public String longestDiverseString(int a, int b, int c) {
    StringBuilder result = new StringBuilder();
    // MAX Heap with count as key and value as the character
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
    // adding the pairs to the queue & skipping it if the count is 0
    for (Pair pair : Arrays.asList(new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c'))) {
      if (pair.count != 0) {
        pq.add(pair);
      }
    }

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int resLen = result.length();
      // check if the current max key and the previous two keys in result are same. If so, second max key has to be appended to the result
      if (resLen > 1 && result.charAt(resLen - 1) == pair.key && result.charAt(resLen - 2) == pair.key) {
        if (pq.isEmpty()) {
          break;
        }
        Pair pair2 = pq.poll();
        result.append(pair2.key);
        pair2.count -= 1;
        if (pair2.count != 0) {
          pq.add(pair2);
        }
      } else {
        result.append(pair.key);
        pair.count -= 1;
      }
      if (pair.count != 0) {
        pq.add(pair);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String s = new LC1405().longestDiverseString(1, 1, 7);
    System.out.println(s);
  }
}
*/