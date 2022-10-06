class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key) == false) {
            map.put(key, new TreeMap());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key) == false) {
             return "";
        }
        else {
            if (map.containsKey(key) == false) {
                return "";
            }
            TreeMap<Integer, String> floor = map.get(key);
            Integer tmp = floor.floorKey(timestamp);
            if (tmp == null) {
                return "";
            }
            return floor.get(tmp);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */