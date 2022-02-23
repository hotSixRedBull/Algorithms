class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap();
        for (int i=0; i<nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
    
        List<Integer> keys = new ArrayList(freqMap.keySet());
        keys.sort(Collections.reverseOrder());
        int left = k;
        HashMap<Integer, Integer> ansMap = new HashMap();
        for (int num : keys) {
            int freq = freqMap.get(num);
            if (left <= freq) {
                ansMap.put(num, left);
                left = 0;
                break;
            }
            else {
                ansMap.put(num, freq);
                left -= freq;
            }
        }
        
        int[] ans = new int[k];
        int ansIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (ansIndex == k) {
                break;
            }
            if (ansMap.containsKey(nums[i])) {
                ans[ansIndex++] = nums[i];
                if (ansMap.get(nums[i]) == 1) {
                    ansMap.remove(nums[i]);
                }
                else {
                    ansMap.put(nums[i], ansMap.get(nums[i])-1);
                }
            }
        }
        return ans;
    }
}