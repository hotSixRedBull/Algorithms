// saw solution a bit..
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.contains(num-1) == false) {
                int cur = num+1;
                int consecutive = 1;
                while (set.contains(cur)) {
                    cur++;
                }
                max = Math.max(max, cur-num);
            }
        }
        return max;
    }
}


/*
sort in O(n)?

A1. counting sort, O(k), k is maximum value.
--> Will be TLE

A2. Heap, O(nlogn)


TC
[0,-1]
*/