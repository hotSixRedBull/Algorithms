class Solution {
    int[] ns;
    int size;
    int[] dp;
    public int maxScore(int[] nums) {
        ns = nums;
        size = (int)Math.pow(2,nums.length);
        dp = new int[size];
        Arrays.fill(dp, -1);
        return recursive(0, 1);
    }
    
    public int recursive(int state, int depth) {
        if (depth == ns.length/2+1) {
            return 0;
        }
        if (dp[state] != -1) {
            return dp[state];
        }
        int max = 0;
        for (int i=0; i<ns.length; i++) {
            int mask1 = 1 << (ns.length-1-i);
            if ((state & mask1) > 0) {
                continue;
            }
            for (int j=i+1; j<ns.length; j++) {
                int mask2 = 1 << (ns.length-1-j);
                if ((state & mask2) > 0
                   || mask1 == mask2) {
                    continue;
                }
                // System.out.println(String.format("mask: %s, gcd(%d, %d): %d", Integer.toBinaryString(mask1 | mask2), ns[i], ns[j], gcd(ns[i], ns[j])));
                max = Math.max(max, depth * gcd(ns[i], ns[j]) + recursive(state | mask1 | mask2, depth+1));
            }
        }
        // System.out.println(String.format("recursive(%s, %d): %d", Integer.toBinaryString(state), depth, max));
        return dp[state] = max;
    }
    
    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}