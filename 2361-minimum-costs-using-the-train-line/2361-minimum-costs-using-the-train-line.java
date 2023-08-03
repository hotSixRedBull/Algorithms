class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        //n~2n-1 -> express node
        int n = regular.length+1;
        long[] dists = new long[2*n+2];
        dists[0] = 0;
        dists[n+1] = expressCost;
        for (int i=1; i<2*n+2; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        
        Map<Integer, Map<Integer, Long>> distMap = new HashMap();
        for (int i=0; i<2*n+2; i++) {
            distMap.put(i, new HashMap());
        }
        
        for (int i=0; i<n; i++) {
            distMap.get(i).put(i+n+1, (long) expressCost);
            distMap.get(i+n+1).put(i, (long) 0);
        }
        
        for (int i=0; i<regular.length; i++) {
            distMap.get(i).put(i+1, (long) regular[i]);
            distMap.get(i+n+1).put(i+n+2, (long) express[i]);
        }
        
        // System.out.println(distMap);
        
//         PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> (int)(a[2]-b[2]));
//         for (int nei : distMap.get(0).keySet()) {
//             pq.add(new long[]{0, nei, distMap.get(0).get(nei)});
//         }
        
//         int[] used = new int[2*n+2];
//         while (pq.size() > 0) {
//             long[] cur = pq.poll();
//             // System.out.println(Arrays.toString(cur));
//             // System.out.println(Arrays.toString(dists));
//             int from = (int) cur[0];
//             int to = (int) cur[1];
//             long dist = cur[2];
            
//             used[from]++;
            
//             if (dists[from]+dist < dists[to]) {
//                 dists[to] = dists[from]+dist;
//             }
//             for (int nei : distMap.get(to).keySet()) {
//                 if (used[nei] > 1) {
//                     continue;
//                 }
//                 pq.add(new long[]{cur[1], (long) nei, distMap.get(to).get(nei)});
//             }
//         }
        
        for (int i=0; i<regular.length; i++) {
            dists[i+1] = dists[i]+regular[i];
            dists[i+1] = Math.min(dists[i+1], dists[i+n+1]+regular[i]);
            dists[i+n+2] = dists[i+n+1]+express[i];
            dists[i+n+2] = Math.min(dists[i+n+2], dists[i]+express[i]+expressCost);
        }
        
        long[] results = new long[n-1];
        for (int i=0; i<n-1; i++) {
            results[i] = Math.min(dists[i+1], dists[i+n+2]);
        }
        
        return results;
    }
}

/*
[5,5,5,5,5]
[1,1,1,1,1]
19
[5,21,9,25,13,15,28,5,1,10]
[15,18,23,21,22,17,9,20,14,33]
11
*/