package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.HashMap;
import java.util.Map;

class CheckInStationTime {

  public String name;
  public int t;

  public CheckInStationTime(String name, int t) {
    this.name = name;
    this.t = t;
  }
}

class StationStats {

  public long totalTime;
  public int count;

  public StationStats(long totalTime, int count) {
    this.totalTime = totalTime;
    this.count = count;
  }
}

class UndergroundSystem {

  private final Map<Integer, CheckInStationTime> checkInMap;
  private final Map<String, Map<String, StationStats>> connect;

  public UndergroundSystem() {
    checkInMap = new HashMap<>();
    connect = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    checkInMap.put(id, new CheckInStationTime(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    String from = checkInMap.get(id).name;
    connect.computeIfAbsent(from, k -> new HashMap<>());
    StationStats stationStats = connect.get(from).get(stationName);
    if (stationStats == null) {
      stationStats = new StationStats((t - checkInMap.get(id).t), 1);
    } else {
      stationStats.totalTime += (t - checkInMap.get(id).t);
      ++stationStats.count;
    }
    connect.get(from).put(stationName, stationStats);
  }

  public double getAverageTime(String startStation, String endStation) {
    StationStats stationStats = connect.get(startStation).get(endStation);
    return stationStats.totalTime / (double) stationStats.count;
  }
}

public class LC1396 {

  public static void main(String[] args) {
    UndergroundSystem system = new UndergroundSystem();
    system.checkIn(45, "Leyton", 3);
    system.checkIn(32, "Paradise", 8);
    system.checkIn(27, "Leyton", 10);
    system.checkOut(45, "Waterloo", 15);
    system.checkOut(27, "Waterloo", 20);
    system.checkOut(32, "Cambridge", 22);
    print(system.getAverageTime("Paradise", "Cambridge"));
    print(system.getAverageTime("Leyton", "Waterloo"));
    system.checkIn(10, "Leyton", 24);
    print(system.getAverageTime("Leyton", "Waterloo"));
    system.checkOut(10, "Waterloo", 38);
    print(system.getAverageTime("Leyton", "Waterloo"));
  }
}