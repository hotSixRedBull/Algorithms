class LRUCache {
    Map<Integer, Integer> map;
    Map<Integer, Integer> keyToUpdate;
    TreeMap<Integer, Integer> updateToKey;
    int size;
    int t;
    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.keyToUpdate = new HashMap();
        this.updateToKey = new TreeMap();
        this.size = capacity;
        this.t = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int prev = keyToUpdate.get(key);
            updateToKey.remove(prev);
            keyToUpdate.put(key, t);
            updateToKey.put(t, key);
        }
        t++;
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        // System.out.println(String.format("put(%d, %d)\n- map: %s\n- updateToKey: %s\n- keyToUpdate: %s",key,value,map,updateToKey,keyToUpdate));
        if (map.containsKey(key)) {
            int prev = keyToUpdate.get(key);
            updateToKey.remove(prev);
        }
        map.put(key, value);
        keyToUpdate.put(key, t);
        updateToKey.put(t, key);
        while (map.size() > size) {
            int minTime = updateToKey.firstKey();
            int minKey = updateToKey.get(minTime);
            map.remove(minKey);
            keyToUpdate.remove(minKey);
            updateToKey.remove(minTime);
        }
        t++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */