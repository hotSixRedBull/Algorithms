class LFUCache {
    Map<Integer, Integer> map; // key, value
    TreeMap<Integer, LinkedHashSet<Integer>> fmap; // freq, key // frequency map
    Map<Integer, Integer> rmap; // key, freq // reverse frequency map
    Map<Integer, Integer> tmap; // key, last used time // time map
    int time;
    int cap;
    int siz;
    
    public LFUCache(int capacity) {
        time = 0;
        cap = capacity;
        siz = 0;
        map = new HashMap();
        fmap = new TreeMap();
        rmap = new HashMap();
        tmap = new HashMap();
    }
    
    public int get(int key) {
        // System.out.println(String.format("get(%d)", key));
        time++;
        int ret = -1;
        if (map.containsKey(key)) {
            ret = map.get(key);
            raiseFreq(key);
            tmap.put(key, time);
        }
        // System.out.println(String.format("  >> %d, map: %s, fmap: %s", ret, map, fmap));
        return ret;
    }
    
    public void put(int key, int value) {
        // System.out.println(String.format("put(%d, %d)", key, value));
        // System.out.println(String.format("  >> map: %s, fmap: %s, tmap: %s", map, fmap, tmap));
        time++;
        if (siz < cap) {
            if (map.containsKey(key) == false) {
                siz++;
                if (fmap.containsKey(1) == false) {
                    fmap.put(1, new LinkedHashSet());
                }
                fmap.get(1).add(key);
                rmap.put(key, 1);
            }
            else {
                raiseFreq(key);
            }
        }
        else if (map.containsKey(key)) {
            raiseFreq(key);
        }
        else {
            if (cap == 0) {
                return;
            }
            Integer lo = fmap.firstKey();
            int replaceKey = -1;
            if (fmap.get(lo).size() != 1) {
                int recent = Integer.MAX_VALUE;
                replaceKey = fmap.get(lo).iterator().next();
                fmap.get(lo).remove(replaceKey);
            }
            else {
                replaceKey = fmap.get(lo).iterator().next();
                fmap.remove(lo);
            }
            map.remove(replaceKey);
            rmap.remove(replaceKey);
            tmap.remove(replaceKey);
            if (fmap.containsKey(1) == false) {
                fmap.put(1, new LinkedHashSet());
            }
            fmap.get(1).add(key);
            rmap.put(key, 1);
        }
        map.put(key, value);
        tmap.put(key, time);
        // System.out.println(String.format("  >> map: %s, fmap: %s, tmap: %s", map, fmap, tmap));
    }
    
    public int raiseFreq(int key) {
        // System.out.println(String.format("  raiseFreq(%d), fmap: %s, rmap: %s", key, fmap, rmap));
        int freq = rmap.get(key);
        if (fmap.get(freq).size() == 1) {
            fmap.remove(freq);
        }
        else {
            fmap.get(freq).remove(key);
        }
        if (fmap.containsKey(freq+1) == false) {
            fmap.put(freq+1, new LinkedHashSet());
        }
        fmap.get(freq+1).add(key);
        rmap.put(key, freq+1);
        return freq;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
[[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]
["LFUCache","put","put","put","put","get"]
[[2],[3,1],[2,1],[2,2],[4,4],[2]]
["LFUCache","put","get"]
[[0],[0,0],[0]]
["LFUCache","put","put","get","put","put","get"]
[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
["LFUCache","put","put","get","get","put","get","get","get"]
[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
*/