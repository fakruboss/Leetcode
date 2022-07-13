package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSmallestIndex {

  Map<Integer, Integer> indexNumber;
  Map<Integer, List<Integer>> numberIndexes;

  GetSmallestIndex() {
    this.indexNumber = new HashMap<>();
    this.numberIndexes = new HashMap<>();
  }

  private void insertOrReplaceNumber(int number, int index) {
    Integer existingNum = indexNumber.get(index);
    if (existingNum != null) {
      List<Integer> indexes = numberIndexes.get(existingNum);
      indexes.remove((Integer) index);
      if (indexes.isEmpty()) {
        numberIndexes.remove(existingNum);
      }
    }

    indexNumber.put(index, number);
    numberIndexes.computeIfAbsent(number, x -> new ArrayList<>()).add(index);
  }

  private int getSmallestIndex(int number) {
    List<Integer> indexes = numberIndexes.get(number);
    if (indexes == null || indexes.isEmpty()) {
      return -1;
    }
    int smallestIndex = Integer.MAX_VALUE;
    for (int index : indexes) {
      smallestIndex = Math.min(smallestIndex, index);
    }
    return smallestIndex;
  }

  public static void main(String[] args) {
    GetSmallestIndex getSmallestIndex = new GetSmallestIndex();
    getSmallestIndex.insertOrReplaceNumber(100, 0);
    getSmallestIndex.insertOrReplaceNumber(101, 1);
    getSmallestIndex.insertOrReplaceNumber(102, 2);
    System.out.println(getSmallestIndex.getSmallestIndex(100));
    System.out.println(getSmallestIndex.getSmallestIndex(101));
    System.out.println(getSmallestIndex.getSmallestIndex(102));
    getSmallestIndex.insertOrReplaceNumber(101, 0);
    System.out.println(getSmallestIndex.getSmallestIndex(100));
    System.out.println(getSmallestIndex.getSmallestIndex(101));
    System.out.println(getSmallestIndex.getSmallestIndex(102));
    getSmallestIndex.insertOrReplaceNumber(102, 1);
    System.out.println(getSmallestIndex.getSmallestIndex(100));
    System.out.println(getSmallestIndex.getSmallestIndex(101));
    System.out.println(getSmallestIndex.getSmallestIndex(102));
  }
}