class Solution {
    int[] nums;
    Map<Integer, Map<Integer, Map<Integer, Integer>>> cache;
    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        cache = new HashMap();
        for (int i=0; i<n; i++) {
            cache.put(i, new HashMap());
            for (int j=0; j<n; j++) {
                cache.get(i).put(j, new HashMap());
            }
        }
        return aScore(0, n-1, 1) >= 0;
    }
    public int aScore(int left, int right, int turn) {
        if (left == right) {
            return turn == 1 ? nums[left] : -nums[left];
        }
        if (cache.get(left).get(right).containsKey(turn)) {
            return cache.get(left).get(right).get(turn);
        }
        if (turn == 1) {
            int max = Integer.MIN_VALUE;
            max = Math.max(max, 
                           Math.max(aScore(left+1, right, 2)+nums[left],
                                    aScore(left, right-1, 2)+nums[right]));
            cache.get(left).get(right).put(turn, max);
            return max;
        }
        else {
            int min = Integer.MAX_VALUE;
            min = Math.min(min, 
                           Math.min(aScore(left+1, right, 1)-nums[left],
                                    aScore(left, right-1, 1)-nums[right]));
            cache.get(left).get(right).put(turn, min);
            return min;
        }
    }
}