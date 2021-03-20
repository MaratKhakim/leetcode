package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 20.03.2021.
 *
 * 1396. Design Underground System
 *
 * Implement the UndergroundSystem class:
 *  # void checkIn(int id, string stationName, int t)
 *      - A customer with a card id equal to id, gets in the station stationName at time t.
 *      - A customer can only be checked into one place at a time.
 *  # void checkOut(int id, string stationName, int t)
 *      - A customer with a card id equal to id, gets out from the station stationName at time t.
 *  # double getAverageTime(string startStation, string endStation)
 *      - Returns the average time to travel between the startStation and the endStation.
 *      - The average time is computed from all the previous traveling from startStation to endStation that happened directly.
 *      - Call to getAverageTime is always valid.
 *
 * You can assume all calls to checkIn and checkOut methods are consistent.
 * If a customer gets in at time t1 at some station, they get out at time t2 with t2 > t1.
 * All events happen in chronological order.
 *
 * https://leetcode.com/problems/design-underground-system/
 */

public class DesignUndergroundSystem {
    private Map<Integer, Pair> pairs;
    private Map<String, List<Integer>> map;

    public DesignUndergroundSystem() {
        pairs = new HashMap<>();
        map = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Pair pair = new Pair(stationName, t);
        pairs.put(id, pair);
    }

    public void checkOut(int id, String stationName, int t) {
        Pair pair = pairs.remove(id);
        String direction = pair.station+"-"+stationName;
        int diff = t - pair.t;

        map.putIfAbsent(direction, new ArrayList<>());
        map.get(direction).add(diff);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> list = map.get(startStation+"-"+endStation);
        int sum = 0;

        for (int num : list)
            sum += num;

        return (double) sum/list.size();
    }

    class Pair {
        String station;
        int t;

        public Pair(String station, int t) {
            this.station = station;
            this.t = t;
        }
    }
}
