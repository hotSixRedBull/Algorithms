class Solution {
    public boolean checkPossibility(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                int[] removePriorOne = new int[nums.length-1];
                boolean ans = true;
                for (int j=1; j<i-2; j++) {
                    if (nums[j-1] > nums[j]) {
                        ans = false;
                        break;
                    }
                }
                if (i >= 2
                    && nums[i-2] > nums[i]) {
                    ans = false;
                }
                for (int j=i+1; j<nums.length; j++) {
                    if (nums[j-1] > nums[j]) {
                        ans = false;
                        break;
                    }
                }
                if (ans) {
                    return true;
                }
                ans = true;
                int[] removeLaterOne = new int[nums.length-1];
                for (int j=1; j<i-1; j++) {
                    if (nums[j-1] > nums[j]) {
                        ans = false;
                        break;
                    }
                }
                if (i >= 1
                    && i < nums.length-1
                    && nums[i-1] > nums[i+1]) {
                    ans = false;
                }
                for (int j=i+2; j<nums.length; j++) {
                    if (nums[j-1] > nums[j]) {
                        ans = false;
                        break;
                    }
                }
                return ans;
            }
        }
        return true;
    }
}

/*
[3,4,2,3]
*/