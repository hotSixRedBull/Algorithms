class PeopleData {
    String startStation;
    double time;
    public PeopleData(String station, double t) {
        startStation = station;
        time = t;
    }
}

class TravelData {
    double sum;
    double numberOfData;
}

class UndergroundSystem {
    Map<Integer, PeopleData> nameMap;
    Map<String, TravelData> travelMap;
    
    public UndergroundSystem() {
        nameMap = new HashMap();
        travelMap = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        nameMap.put(id, new PeopleData(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        PeopleData peopleData = nameMap.get(id);
        String key = peopleData.startStation+"-"+stationName;
        if (travelMap.containsKey(key) == false) {
            travelMap.put(key, new TravelData());
        }
        
        TravelData travelData = travelMap.get(key);
        travelData.numberOfData++;
        travelData.sum += t-peopleData.time;
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+"-"+endStation;
        TravelData travelData = travelMap.get(key);
        return travelData.sum/travelData.numberOfData;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */