class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        TreeMap<Integer, Long> map = new TreeMap();
        for (int i=0; i<n; i++) {
            map.putIfAbsent(nums[i], (long) 0);
            map.put(nums[i], map.get(nums[i])+cost[i]);
        }
        
// System.out.println(map);
        
        int[] keys = new int[map.size()];
        long[] positiveAcc = new long[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            keys[index] = key;
            positiveAcc[index] = index == 0 ? map.get(key) : map.get(key) + positiveAcc[index-1];
            index++;
        }
        
        long[] negativeAcc = new long[map.size()];
        index = keys.length-1;
        for (int key : map.descendingKeySet()) {
            negativeAcc[index] = index >= keys.length-1 ? map.get(key) : map.get(key) + negativeAcc[index+1];
            index--;
        }
        
// System.out.println(String.format("keys: %s\n positiveAcc: %s\n negativeAcc: %s", Arrays.toString(keys), Arrays.toString(positiveAcc), Arrays.toString(negativeAcc)));
        
        int newN = positiveAcc.length;
        long min = Long.MAX_VALUE;
        int minIndex = -1;
        long[] each = new long[newN];
        each[0] = 0;
        for (int i=0; i<newN; i++) {
            long rightDirection = positiveAcc[i];
            if (i<newN-1) {
                rightDirection -= negativeAcc[i+1];
            }
            if (i < newN-1) {
                each[i+1] = each[i] + rightDirection;
            }
            if (each[i] < min) {
                min = each[i];
                minIndex = i;
            }
// System.out.println(String.format("i: %d, positive: %d", i, rightDirection));
        }
        
// System.out.println(String.format("min: %d, minIndex: %d", min, minIndex));
        
        long result = 0;
        int target = keys[minIndex];
        for (int i=0; i<newN; i++) {
            result += map.get(keys[i])*Math.abs(target-keys[i]);
        }
        return result;
    }
}

/* self TC
[1,3,5,2]
[2,3,1,14]
[2,2,2,2,2]
[4,2,8,1,3]
[1,1,1,1,2]
[1,1,1,1,3]
[1,1,1,1,2]
[1,1,1,1,4]
[1,1,1,1,2]
[1,1,1,1,5]
*/