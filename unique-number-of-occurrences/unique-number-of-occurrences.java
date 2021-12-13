class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> valueToOccur = new HashMap<>();
        HashMap<Integer, Integer> OccurCnt = new HashMap<>();
        for (int val : arr) {
            if (valueToOccur.containsKey(val)) {
                valueToOccur.put(val, valueToOccur.get(val)+1);
            }
            else {
                valueToOccur.put(val, 1);
            }
        }
        
        for (int key : valueToOccur.values().toArray(new Integer[0])) {
            if (OccurCnt.containsKey(key)) {
                return false;
            }
            else {
                OccurCnt.put(key, 1);
            }
        }
        return true;
    }
}