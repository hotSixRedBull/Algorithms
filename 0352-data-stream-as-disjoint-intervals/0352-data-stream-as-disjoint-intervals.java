class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap();
    }
    
    public void addNum(int value) {
        // System.out.println(String.format("adding %d", value, map));
        if (map.size() == 0) {
            map.put(value, value);
            return;
        }
        if (map.containsKey(value)) {
            return;
        }
        
        Integer lo = map.lowerKey(value);
        Integer hi = map.higherKey(value);
        
        if (lo != null
           && map.get(lo) >= value) {
            return;
        }
        
        if (lo == null) {
            if (hi == null) {
                map.put(value, value);
            }
            else {
                if (hi-1 == value) {
                    int end = map.get(hi);
                    map.remove(hi);
                    map.put(value, end);
                }
                else {
                    map.put(value, value);
                }
            }
        }
        else if (hi == null) {
            int end = map.get(lo);
            if (end == value-1) {
                map.put(lo, value);
            }
            else {
                map.put(value, value);
            }
        }
        else {
            int end1 = map.get(lo);
            int end2 = map.get(hi);
            if (value == end1+1) {
                if (value == hi-1) {
                    map.put(lo, end2);
                    map.remove(hi);
                }
                else {
                    map.put(lo, value);
                }
            }
            else if (value == hi-1) {
                map.remove(hi);
                map.put(value, end2);
            }
            else {
                map.put(value, value);
            }
        }
        // System.out.println(String.format("after adding %d, %s", value, map));
    }
    
    public int[][] getIntervals() {
        int[][] ret = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            ret[index][0] = key;
            ret[index++][1] = map.get(key);
        }
        // System.out.println(String.format("getIntervals: %s", map));
        return ret;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */

/*
["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]
[[],[6],[],[6],[],[0],[],[4],[],[8],[],[7],[],[6],[],[4],[],[7],[],[5],[]]
["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]
[[],[1],[],[3],[],[7],[],[2],[],[6],[],[9],[],[4],[],[10],[],[5],[]]
*/