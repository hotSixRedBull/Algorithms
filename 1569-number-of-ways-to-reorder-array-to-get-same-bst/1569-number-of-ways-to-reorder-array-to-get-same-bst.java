import java.math.BigInteger;

class Solution {
    int mod;
    BigInteger[] dp;
    
    public int numOfWays(int[] nums) {
        int n = nums.length;
        this.mod = 1_000_000_007;
        
        dp = new BigInteger[n+1];
        dp[0] = new BigInteger("1");
        for (int i=1; i<dp.length; i++) {
            dp[i] = dp[i-1].multiply(new BigInteger(Integer.toString(i)));
        }
        List<Integer> lefts = new ArrayList();
        List<Integer> rights = new ArrayList();
        for (int i=1; i<n; i++) {
            if (nums[i] < nums[0]) {
                lefts.add(nums[i]);
            }
            else {
                rights.add(nums[i]);
            }
        }
        BigInteger ans = combination(n-1, lefts.size())
            .multiply(recursive(lefts))
            .multiply(recursive(rights));
        return ans.subtract(new BigInteger("1")).mod(new BigInteger(Integer.toString(mod))).intValue();
    }
    
    public BigInteger recursive(List<Integer> nums) {
        if (nums.size() == 0) {
            return new BigInteger("1");
        }
        int n = nums.size();
        List<Integer> lefts = new ArrayList();
        List<Integer> rights = new ArrayList();
        for (int i=1; i<n; i++) {
            if (nums.get(i) < nums.get(0)) {
                lefts.add(nums.get(i));
            }
            else {
                rights.add(nums.get(i));
            }
        }
        BigInteger ans = combination(n-1, lefts.size())
            .multiply(recursive(lefts))
            .multiply(recursive(rights));
        // System.out.println(String.format("nums: %s, ans: %d", nums, ans));
        // System.out.println(String.format("combination(%d,%d): %d, lefts: %s, value: %d, rights: %s, value: %d", n-1, lefts.size(), combination(n-1,lefts.size()), lefts, recursive(lefts), rights, recursive(rights)));
        return ans.mod(new BigInteger(Integer.toString(mod)));
    }
    
    public BigInteger combination(int n, int k) {
        return dp[n].divide(dp[k]).divide(dp[n-k]);
    }
}

/*
self test
[2,1,3]
[3,4,5,1,2]
[1,2,3]
[1]
[8,5,9,3,7,2,4,6,1]
*/