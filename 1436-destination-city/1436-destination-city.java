class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet();
        Set<String> cities = new HashSet();
        for (List<String> path : paths) {
            cities.add(path.get(0));
            cities.add(path.get(1));
            outgoingCities.add(path.get(0));
        }
        
        cities.removeAll(outgoingCities);
        List<String> result = new ArrayList(cities);
        return result.get(0);
    }
}