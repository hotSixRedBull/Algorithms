//saw solution
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // initialize the hash map with index 0 for sum 0
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            if (!hashMap.containsKey(sum % k))
                hashMap.put(sum % k, i + 1);
            // if the subarray size is at least two
            else if (hashMap.get(sum % k) < i)
                return true;
        }
        return false;
    }
}
/*
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        
        nums[0] %= k;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] == 0
               && nums[i] == 0) {
                return true;
            }
            if (nums[i-1] == 0
               && nums[i] % k == 0) {
                return true;
            }
            if (nums[i-1] % k == 0
               && nums[i] == 0) {
                return true;
            }
            nums[i] %= k;
        }
        // System.out.println(Arrays.toString(nums));
        
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{0,2,nums[0]+nums[1]});
        while (q.size() > 0) {
            int[] cur = q.poll();
            int left = cur[0];
            int right = cur[1];
            int sum = cur[2];
            if (left == nums.length) {
                continue;
            }
            if (sum % k == 0) {
                // System.out.println(String.format("%d, %d", left, right));
                return true;
            }
            else if (sum > k) {
                q.add(new int[]{left, right, sum%k});
                sum -= nums[left];
                left++;
            }
            else {
                if (right == nums.length) {
                    continue;
                }
                sum += nums[right];
                right++;
            }
            q.add(new int[]{left, right, sum});
        }
        return false;
    }
}
*/

/*
[23,2,4,6,6]
7
[5,0,0,0]
3
[1,1]
1
[1,3,0,6]
6
*/