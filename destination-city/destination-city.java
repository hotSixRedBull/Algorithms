class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> departures = new TreeSet<>();
        Set<String> arrivals = new TreeSet<>();
        for (List<String> path : paths) {
            departures.add(path.get(0));
            arrivals.add(path.get(1));
        }
        
        for (String arrival: arrivals) {
            if (!departures.contains(arrival)) {
                return arrival;
            }
        }
        return "";
    }
}