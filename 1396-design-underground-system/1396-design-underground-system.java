import java.util.*;

class UndergroundSystem {

    // id -> check-in info
    private Map<Integer, CheckIn> checkInMap;

    // route -> total time, count
    private Map<String, int[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn info = checkInMap.get(id);
        checkInMap.remove(id);

        String key = info.station + "-" + stationName;
        int travelTime = t - info.time;

        routeMap.putIfAbsent(key, new int[2]);

        int[] data = routeMap.get(key);
        data[0] += travelTime; // total time
        data[1] += 1;          // count
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] data = routeMap.get(key);

        return (double) data[0] / data[1];
    }

    // Helper class
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}