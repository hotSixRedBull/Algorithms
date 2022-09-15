class Solution {
    public int[] findOriginalArray(int[] changed) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int c : changed) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Integer> li = new ArrayList();
        while (map.size() > 0) {
            int c = map.firstKey();
            int smaller = map.get(c);
            map.remove(c);
            if (c == 0) {
                if (smaller % 2 == 1) {
                    return new int[0];
                }
                for (int i=0; i<smaller/2; i++) {
                    li.add(0);
                }
                continue;
            }
            int bigger = map.getOrDefault(c*2, 0);
            if (smaller > bigger) {
                return new int[0];
            }
            else if (smaller == bigger) {
                for (int i=0; i<smaller; i++) {
                    li.add(c);
                }
                map.remove(c*2);
            }
            else {
                for (int i=0; i<smaller; i++) {
                    li.add(c);
                }
                map.put(c*2, bigger-smaller);
            }
        }
        if (map.size() != 0) {
            return new int[0];
        }
        else {
            int[] ans = new int[li.size()];
            for (int i=0; i<li.size(); i++) {
                ans[i] = li.get(i);
            }
            return ans;
        }
    }
}