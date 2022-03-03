class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        // System.out.println("map: "+map);
        int target = 0;
        int nCopy = n;
        while (nCopy > 0) {
            int cur = nCopy % 10;
            // System.out.println("cur: "+cur);
            nCopy /= 10;
            if (!map.containsKey(cur)) {
                // System.out.println(">>cur: "+cur);
                return false;
            }
            target *= 10;
            target += map.get(cur);
        }
        return target != n;
    }
}