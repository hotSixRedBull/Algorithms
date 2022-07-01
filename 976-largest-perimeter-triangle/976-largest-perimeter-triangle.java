class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int k=nums.length-1; k>=2; k--) {
            int j=k-1;
            int i=k-2;
            if (nums[k] >= nums[j]+nums[i]) {
                continue;
            }
            else {
                return nums[k]+nums[j]+nums[i];
            }
        }
        return 0;
    }
}

/*
A0. bruteForce, O(N^3)/O(1)
A1. sort, O(n^3)/O(n)
   -> sort for O(nlogn), mix for O(n^3)
A2. counting sort O(k + k^2)
*/