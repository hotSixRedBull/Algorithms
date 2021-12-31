class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> tMap = new HashMap<>();
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i=0; i<target.length; i++) {
            tMap.put(target[i], tMap.getOrDefault(target[i], 0)+1);
            aMap.put(arr[i], aMap.getOrDefault(arr[i], 0)+1);
        }
        
        if (tMap.size() != aMap.size()) {
            return false;
        }
        
        for (int key : tMap.keySet()) {
            if (!aMap.containsKey(key) || aMap.get(key) != tMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}