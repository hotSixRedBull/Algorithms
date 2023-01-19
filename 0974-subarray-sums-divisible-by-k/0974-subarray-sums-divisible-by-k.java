class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainder = new int[k];
        remainder[0] = 1;
        long sum = 0;
        int ret = 0;
        for (int num : nums) {
            sum += (long)num;
            if (sum < k) {
                sum += sum/k * -k;
            }
            int r = (int)((sum + k)%k);
            ret += remainder[r];
            remainder[r]++;
        }
        return ret;
    }
}

/*
[-2]
6
[-6,1,-5,10]
9
*/