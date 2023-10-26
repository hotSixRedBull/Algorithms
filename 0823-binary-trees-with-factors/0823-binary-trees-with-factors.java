class Solution {
    Set<Integer> set;
    Map<Integer, Integer> cache;
    long mod;
    public int numFactoredBinaryTrees(int[] arr) {
        set = new HashSet();
        cache = new HashMap();
        mod = 1_000_000_007;
        
        for (int val : arr) {
            set.add(val);
        }
        
        cache.put(1, -1);
        
        long result = 0;
        for (int i=0; i<arr.length; i++) {
            result += dp(arr[i]) % mod;
            result %= mod;
        }
        // System.out.println(cache);
        return (int)result;
    }
    
    public long dp(int val) {
        // System.out.println(String.format("dp(%d)", val));
        if (cache.containsKey(val)) {
            return cache.get(val);
        }
        int max = (int) Math.sqrt(val);
        long result = set.contains(val) == true ? 1 : 0;
        for (int left=2; left<=max; left++) {
            if (val % left != 0) {
                continue;
            }
            int right = val / left;
            if (set.contains(left) == false || set.contains(right) == false) {
                continue;
            }
            long leftVal = dp(left);
            long rightVal = dp(right);
            if (leftVal == -1 || rightVal == -1) {
                continue;
            }
            if (left != right) {
                result += (leftVal*rightVal)%mod;
                result %= mod;
            }
            result += (leftVal*rightVal)%mod;
            result %= mod;
        }
        if (result == 0) {
            cache.put(val, -1);
        }
        else {
            cache.put(val, (int)(result%mod));
        }
        return cache.get(val);
    }
}

/*
[18,3,6,2]
*/