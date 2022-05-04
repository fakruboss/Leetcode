package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {

  int index;
  Map<Integer, Integer> map;
  TreeMap<Integer, Integer> countMap;

  public StockPrice() {
    map = new HashMap<>();
    countMap = new TreeMap<>();
  }

  public void update(int timestamp, int price) {
    index = Math.max(index, timestamp);
    if (map.containsKey(timestamp)) {
      int oldPrice = map.get(timestamp);
      if (countMap.get(oldPrice) == 1) {
        countMap.remove(oldPrice);
      } else {
        countMap.put(oldPrice, countMap.get(oldPrice) - 1);
      }
    }
    countMap.put(price, countMap.getOrDefault(price, 0) + 1);
    map.put(timestamp, price);
  }

  public int current() {
    return map.get(index);
  }

  public int maximum() {
    return countMap.lastKey();
  }

  public int minimum() {
    return countMap.firstKey();
  }
}

public class LC2034 {

  public static void main(String[] args) {
    StockPrice sp = new StockPrice();
    sp.update(1, 10);
    sp.update(2, 5);
    print(sp.current());
    print(sp.maximum());
    sp.update(1, 3);
    print(sp.maximum());
    sp.update(4, 2);
    print(sp.minimum());
  }
}

/**
 * Your StockPrice object will be instantiated and called as such: StockPrice obj = new
 * StockPrice(); obj.update(timestamp,price); int param_2 = obj.current(); int param_3 =
 * obj.maximum(); int param_4 = obj.minimum();
 */