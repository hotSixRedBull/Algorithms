class NumArray {
    public int[][] dp;
    public boolean[][] dpExists;

    public NumArray(int[] nums) {
        this.dp = new int[nums.length+1][nums.length+1];
        this.dpExists = new boolean[nums.length+1][nums.length+1];
        for (int i=0; i<nums.length; i++) {
            this.dp[i][i] = nums[i];
        }
        //System.out.println(Arrays.toString(dpExists[0]));
    }
    
    public int sumRange(int left, int right) {
        if (this.dpExists[left][right] == true) {
            return this.dp[left][right];
        }
        int sum = 0;
        for (int i=left; i<=right; i++) {
            sum += this.dp[i][i];
            this.dpExists[left][i] = true;
            this.dp[left][i] = sum;
        }
        return this.dp[left][right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */