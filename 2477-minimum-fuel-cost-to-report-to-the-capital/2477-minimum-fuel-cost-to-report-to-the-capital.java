class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        int[] peoples = new int[n+1];
        for (int i=0; i<=n; i++) {
            peoples[i] = 1;
        }
        int[] inDegree = new int[n+1];
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for (int[] road : roads) {
            inDegree[road[0]]++;
            inDegree[road[1]]++;
            adj.putIfAbsent(road[0], new ArrayList());
            adj.get(road[0]).add(road[1]);
            adj.putIfAbsent(road[1], new ArrayList());
            adj.get(road[1]).add(road[0]);
        }
        // System.out.println(adj);
        Queue<Integer> q = new ArrayDeque();
        boolean[] visit = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            if (inDegree[i] == 1) {
                q.add(i);
                visit[i] = true;
            }
        }
        long sum = 0;
        while (q.size() > 0) {
            int pos = q.poll();
            // System.out.println(String.format("pos: %d, sum: %d", pos, sum));
            if (pos == 0) {
                continue;
            }
            for (int neighbor : adj.get(pos)) {
                if (neighbor != 0 && visit[neighbor]) {
                    continue;
                }
                if (peoples[pos]%seats != 0) {
                    sum++;
                }
                sum += peoples[pos]/seats;
                inDegree[neighbor]--;
                peoples[neighbor] += peoples[pos];
                if (inDegree[neighbor] == 1) {
                    q.add(neighbor);
                    visit[neighbor] = true;
                }
            }
        }
        return sum;
    }
}
/*
[[0,1],[0,2],[1,3],[1,4]]
5
[[1,0],[0,2],[3,1],[1,4],[5,0]]
1
*/