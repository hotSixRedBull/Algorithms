class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length+1];
        for (int i=2; i<=cost.length; i++) {
            cache[i] = Math.min(cache[i-1]+cost[i-1], cache[i-2]+cost[i-2]);
        }
        return cache[cost.length];
    }
}

/*
10  15  20
0   0   10  15
*/