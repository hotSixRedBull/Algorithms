// saw solution
class Solution {
    int[][] memo;
    int MOD = (int) 1e9 + 7;
    int arrLen;
    
    public int dp(int curr, int remain) {
        if (remain == 0) {
            if (curr == 0) {
                return 1;
            }
            
            return 0;
        }
        
        if (memo[curr][remain] != -1) {
            return memo[curr][remain];
        }

        int ans = dp(curr, remain - 1);
        if (curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % MOD;
        }
        
        if (curr < arrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % MOD;
        }
        
        memo[curr][remain] = ans;
        return ans;
    }
    
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        this.arrLen = arrLen;
        memo = new int[arrLen][steps + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dp(0, steps);
    }
}
/*
step => how many pairs of (left, right) can be.
arrLen => how many consecutive right can be.

n,1 => 1
s*n

1,n => 1
s

1,1 => 1
1,2 => 1
2,1 => 1
2,2 => 2 => (2,1)S + RL
2,3 => 2 => //
1,3 => 1
3,1 => 1
3,2 => 4 => (2,2)S + SRL + RSL
3,3 => 4 => //
1,4 => 1
4,1 => 1
4,2 => 5 => (2,2)SS + (2,2)RL + RSSL


3,2
RLS
SRL
RSL
SSS

2,2
RL
SS

2,4
RL
SS

4,2
RLRL
RLSS
RSSL
SSRL
SSSS
*/