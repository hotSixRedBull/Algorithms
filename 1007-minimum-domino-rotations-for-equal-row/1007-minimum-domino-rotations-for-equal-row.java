class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int target = -1;
        HashMap<Integer, Integer> map = new HashMap();
        HashMap<Integer, Integer> cntMap = new HashMap();
        for (int i=0; i<tops.length; i++) {
            cntMap.put(tops[i], cntMap.getOrDefault(tops[i], 0)+1);
            cntMap.put(bottoms[i], cntMap.getOrDefault(bottoms[i], 0)-1);
            
            if (tops[i] == bottoms[i]) {
                map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
                if (map.get(tops[i]) >= tops.length) {
                    target = tops[i];
                    break;
                }
            }
            else {
                map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
                map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
                if (map.get(tops[i]) >= tops.length) {
                    target = tops[i];
                    break;
                }
                else if (map.get(bottoms[i]) >= bottoms.length) {
                    target = bottoms[i];
                    break;
                }
            }
        }
        
        if (target == -1) {
            return -1;
        }
        
        int ans = 0;
        if (cntMap.get(target) > 0) {
            for (int i=0; i<tops.length; i++) {
                if (tops[i] != target) {
                    ans++;
                }
            }
        }
        else {
            for (int i=0; i<bottoms.length; i++) {
                if (bottoms[i] != target) {
                    ans++;
                }
            }
        }
        return ans;
    }
}