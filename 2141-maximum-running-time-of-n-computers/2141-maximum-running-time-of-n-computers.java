// saw solution
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;
        long left = 1, right = sumPower / n;
        
        while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;
            
            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target))
                left = target;
            else
                right = target - 1;
        }
        return left;
    }
}
/*
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        int left = len;
        TreeMap<Integer, Integer> map = new TreeMap(Collections.reverseOrder());
        for (int b : batteries) {
            map.put(b, map.getOrDefault(b, 0)+1);
        }
        long runtime = 0;
        TreeMap<Integer, Integer> calc = new TreeMap();
        while (left >= n) {
            calc = new TreeMap();
            // System.out.println(map);
            int stored = 0;
            int max = map.firstKey();
            int diff = max;
            Queue<Integer> removeQ = new ArrayDeque();
            for (int key : map.keySet()) {
                diff = Math.min(diff, key);
                if (stored+map.get(key) > n) {
                    calc.put(key, n-stored);
                    map.put(key, map.get(key)-n+stored);
                    stored = n;
                }
                else {
                    calc.put(key, map.get(key));
                    stored += map.get(key);
                    removeQ.add(key);
                }
                if (stored == n) {
                    break;
                }
            }
            // diff = diff > 1 && map.size() < n ? diff-1 : 1;
            diff = 1;
            runtime += diff;
            for (int key : removeQ) {
                map.remove(key);
            }
            
            removeQ = new ArrayDeque();
            for (int key : calc.keySet()) {
                int nextKey = key-diff;
                if (nextKey == 0) {
                    left -= calc.get(key);
                    continue;
                }
                map.put(nextKey, map.getOrDefault(nextKey, 0)+calc.get(key));
            }
        }
        return runtime;
    }
}


2
[3,3,3]
2
[4,4,4]
2
[2,2,2]
2
[1,1,1,1]
3
[10,10,3,5]
9
[18,54,2,53,87,31,71,4,29,25]
12
[11,89,16,32,70,67,35,35,31,24,41,29,6,53,78,83]
*/