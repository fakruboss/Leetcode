package fakru.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LC692 {

  public List<String> topKFrequent(String[] words, int k) {

    List<String> result = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey())
            : a.getValue() - b.getValue()
    );

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(entry);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    while (!pq.isEmpty()) {
      result.add(0, pq.poll().getKey());
    }

    return result;
  }

  public static void main(String[] args) {
    List<String> strings = new LC692().topKFrequent(
        new String[]{"aa", "day", "bb", "sunny", "aa", "aa", "the", "sunny", "bb", "bb", "cc",
            "cc", "cc"}, 3);
    System.out.println(strings);
  }
}
