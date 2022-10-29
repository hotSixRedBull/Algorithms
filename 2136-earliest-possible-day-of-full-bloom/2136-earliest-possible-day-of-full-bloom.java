// saw solution, understood
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            indices.add(i);
        }
        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        int result = 0;
        for (int i = 0, curPlantTime = 0; i < n; ++i) {
            int idx = indices.get(i);
            int time = curPlantTime + plantTime[idx] + growTime[idx];
            result = Math.max(result, time);
            curPlantTime += plantTime[idx];
        }
        return result;
    }
}

/*
In a day,
I can do both plant and grow.

A1. DP

A2. Greedy?
Usually these kind of problems have a solution using greedy algorithm.

What to plant?
I think i should consider growTime?

let's make these rules and test
1. grow time first, plant time later (both descending)
2. plant time first, grow time later (both descending)
3. grow time first, plant time later (both ascending)
4. plant time first, grow time later (both ascending)
1. grow time first, plant time later (descending, ascending)
2. plant time first, grow time later (descending, ascending)
1. grow time first, plant time later (ascending, descending)
2. plant time first, grow time later (ascending, descending)

-> turned out that i can consider only grow time.

*/