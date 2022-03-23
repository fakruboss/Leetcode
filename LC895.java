package fakru.leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */

class FreqStack {

  int maxCount;
  Map<Integer, List<Integer>> map;
  Map<Integer, Integer> freq;

  public FreqStack() {
    maxCount = 0;
    map = new HashMap<>();
    freq = new HashMap<>();
  }

  public void push(int val) {
    freq.put(val, freq.getOrDefault(val, 0) + 1);
    if (freq.getOrDefault(val, 0) > maxCount) {
      ++maxCount;
      map.put(maxCount, new ArrayList<>());
    }
    map.get(freq.get(val)).add(val);
  }

  public int pop() {
    List<Integer> integers = map.get(maxCount);
    if (integers.size() == 1) {
      --maxCount;
    }
    int result = integers.remove(integers.size() - 1);
    freq.put(result, freq.get(result) - 1);
    return result;
  }
}

public class LC895 {

  public static void main(String[] args) {
    FreqStack fs = new FreqStack();
    fs.push(5);
    fs.push(7);
    fs.push(5);
    fs.push(7);
    fs.push(4);
    fs.push(5);
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
  }
}