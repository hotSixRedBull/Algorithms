class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue(new Comparator<Pair<Integer,Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                return a.getKey()-b.getKey();
            }
        });
        for (int i=0; i<costs.length; i++) {
            int[] cost = costs[i];
            Pair <Integer, Integer> p = new Pair(cost[0]-cost[1], i);
            pq.add(p);
        }
        int sum = 0;
        while (pq.size() > costs.length/2) {
            sum += costs[pq.poll().getValue()][0];
        }
        while (pq.size() > 0) {
            sum += costs[pq.poll().getValue()][1];
        }
        return sum;
    }
}
