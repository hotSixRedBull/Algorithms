class SnapshotArray {
    Map<Integer, TreeMap<Integer, Integer>> map;
    Set<Integer> changeList;
    int[] arr;
    int snapShotId;
    public SnapshotArray(int length) {
        snapShotId = -1;
        arr = new int[length];
        map = new HashMap();
        changeList = new HashSet();
        for (int i=0; i<length; i++) {
            arr[i] = 0;
            map.put(i, new TreeMap());
            map.get(i).put(snapShotId, 0);
        }
    }
    
    public void set(int index, int val) {
        changeList.add(index);
        arr[index] = val;
    }
    
    public int snap() {
        snapShotId++;
        for (int i : changeList) {
            map.putIfAbsent(i, new TreeMap());
            TreeMap<Integer, Integer> valueMap = map.get(i);
            if (valueMap.size() == 0) {
                valueMap.put(snapShotId, arr[i]);
            }
            int lastValue = valueMap.get(valueMap.lastKey());
            if (lastValue != arr[i]) {
                valueMap.put(snapShotId, arr[i]);
            }
        }
        changeList = new HashSet();
        return snapShotId;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> valueMap = map.get(index);
        return valueMap.floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */