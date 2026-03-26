import java.util.*;

class UndergroundSystem {

    // Store check-in data: id -> (station, time)
    Map<Integer, Pair<String, Integer>> checkInMap;

    // Store route data: "start-end" -> (totalTime, count)
    Map<String, Pair<Integer, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkInMap.get(id);

        String startStation = checkInData.getKey();
        int startTime = checkInData.getValue();

        int travelTime = t - startTime;

        String routeKey = startStation + "-" + stationName;

        Pair<Integer, Integer> routeData =
                routeMap.getOrDefault(routeKey, new Pair<>(0, 0));

        int totalTime = routeData.getKey() + travelTime;
        int count = routeData.getValue() + 1;

        routeMap.put(routeKey, new Pair<>(totalTime, count));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;

        Pair<Integer, Integer> routeData = routeMap.get(routeKey);

        return (double) routeData.getKey() / routeData.getValue();
    }
}