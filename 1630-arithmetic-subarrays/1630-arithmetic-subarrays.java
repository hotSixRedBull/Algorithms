class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList();
        for (int q=0; q<m; q++) {
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int i=l[q]; i<=r[q]; i++) {
                pq.add(nums[i]);
            }
            if (pq.size() <= 2) {
                ans.add(true);
                continue;
            }
            int prev = pq.poll();
            int diff = pq.peek()-prev;
            boolean result = true;
            while (pq.size() > 0) {
                int cur = pq.poll();
                if (cur-prev != diff) {
                    result = false;
                    break;
                }
                prev = cur;
            }
            ans.add(result);
        }
        return ans;
    }
}