class Solution {
    public int reductionOperations(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        Map<Integer, Integer> cntMap = new HashMap();
        for (int i=0 ; i<nums.length; i++) {
            if (!set.contains(nums[i])) {
                pq.add(nums[i]);    
            }
            set.add(nums[i]);
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0)+1);
        }
        
        int ans = 0;
        while (set.size() != 1 && pq.size() > 0) {
            int val = pq.poll();
            int cnt = cntMap.get(val);
            // System.out.println(String.format("val: %d, cntMap.get(%d): %d", val, val, cnt));
            Integer smaller = set.lower(val);
            if (smaller == null) {
                break;
            }
            cntMap.put(smaller, cntMap.getOrDefault(smaller, 0)+cnt);
            cntMap.remove(val);
            set.remove(val);
            ans += cnt;
        }
        return ans;
    }
}