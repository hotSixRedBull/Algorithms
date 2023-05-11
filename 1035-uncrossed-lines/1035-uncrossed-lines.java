class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<nums2.length; i++) {
            map.putIfAbsent(nums2[i], new ArrayList());
            map.get(nums2[i]).add(i);
        }
        int max = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int i=0; i<nums1.length; i++) {
            int target = nums1[i];
            if (map.containsKey(target) == false) {
                continue;
            }
            List<Integer> pos = map.get(target);
            for (int pIndex=pos.size()-1; pIndex>=0; pIndex--) {
                int p = pos.get(pIndex);
                Map<Integer, Integer> lower = treeMap.headMap(p, false);
                if (lower.size() == 0) {
                    treeMap.put(p, 1);
                    max = Math.max(max, 1);
                }
                else {
                    int localMax = 1;
                    for (int l : lower.values()) {
                        localMax = Math.max(localMax, l);
                    }
                    treeMap.put(p, localMax+1);
                    max = Math.max(max, localMax+1);
                }
            }
        }
        return max;
    }
}

/*
[3]
[3,3,2]
*/