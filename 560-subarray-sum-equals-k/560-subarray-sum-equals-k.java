class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            int localSum = nums[i];
            if (localSum == k) {
                cnt++;
            }
            for (int j=i+1; j<nums.length; j++) {
                localSum += nums[j];
                if (localSum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*
[1,-1,0]
0
[0,0]
0
[28,54,7,-70,22,65,-6]
100
*/
