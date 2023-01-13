class Solution {
    int ans;
    public int longestPath(int[] parent, String s) {
        ans = 0;
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for (int i=1; i<parent.length; i++) {
            if (adj.containsKey(parent[i]) == false) {
                adj.put(parent[i], new ArrayList());
            }
            adj.get(parent[i]).add(i);
        }
        maxLengthSubTree(adj, s, 0);
        return ans;
    }
    public int maxLengthSubTree(HashMap<Integer, List<Integer>> adj,
                               String s,
                               int cur) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        if (adj.containsKey(cur)) {
            for (int child : adj.get(cur)) {
                if (s.charAt(cur) == s.charAt(child)) {
                    maxLengthSubTree(adj, s, child);
                }
                else {
                    pq.add(maxLengthSubTree(adj, s, child));
                    if (pq.size() > 2) {
                        pq.poll();
                    }
                }
            }
        }
        int ret = 1;
        int max = 0;
        if (pq.size() > 1) {
            ret += pq.poll();
        }
        if (pq.size() > 0) {
            max = pq.poll();
            ret += max;
        }
        ans = Math.max(ans, ret);
        return max + 1;
    }
}

/*
[-1,0,1]
"aab"

[-1,0,1,2,3,4]
"zzabab"
*/