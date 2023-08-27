class Solution {
    int[][] dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new int[n][2001];
        
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<n; i++) {
            map.put(stones[i], i);
        }
        Queue<int[]> q = new ArrayDeque();
        if (map.containsKey(stones[0]+1)) {
            q.add(new int[]{map.get(stones[0]+1), 1});
        }
        else {
            return false;
        }
        while (q.size() > 0) {
            int[] cur = q.poll();
            int pos = stones[cur[0]];
            int unit = cur[1];
            if (dp[cur[0]][unit] != 0) {
                // System.out.println(String.format(">>pos: %d, unit: %d", cur[0], cur[1]));
                continue;
            }
            dp[cur[0]][unit] = 1;
            // System.out.println(String.format("pos: %d, unit: %d", cur[0], cur[1]));
            if (cur[0] == n-1) {
                return true;
            }
            if (unit != 1
                && map.containsKey(pos+unit-1)) {
                // System.out.println(pos+unit-1);
                q.add(new int[]{map.get(pos+unit-1), unit-1});
            }
            if (map.containsKey(pos+unit)) {
                // System.out.println(pos+unit);
                q.add(new int[]{map.get(pos+unit), unit});
            }
            if (map.containsKey(pos+unit+1)) {
                // System.out.println(pos+unit+1);
                q.add(new int[]{map.get(pos+unit+1), unit+1});
            }
        }
        return false;
    }
}