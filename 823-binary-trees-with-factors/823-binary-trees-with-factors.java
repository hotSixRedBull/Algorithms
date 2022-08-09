// saw solution
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }
}

/*
class Solution {
    HashMap<Integer, Integer> cache;
    Set<Integer> set;
    int MOD;
    public int numFactoredBinaryTrees(int[] arr) {
        cache = new HashMap();
        set = new HashSet();
        MOD = 1_000_000_007;
        for (int num : arr) {
            set.add(num);
        }
        
        int sum = 0;
        for (int num : arr) {
            sum += getNumberOfSubsets(num);
            sum %= MOD;
            // System.out.println(String.format("sum ==> %d", sum));
        }
        
        return sum;
    }
    
    public int getNumberOfSubsets(int num) {
        if (cache.containsKey(num)) {
            // System.out.println(String.format("cache contains %d ==> %d", num, cache.get(num)));
            return cache.get(num) % MOD;
        }
        
        int localSum = 0;
        for (int i=1; i<=Math.sqrt(num); i++) {
            if (num % i == 0
               && set.contains(i)
               && set.contains(num/i)) {
                if (i == num/i) {
                    localSum += getNumberOfSubsets(i) % MOD;
                }
                else {
                    localSum += getNumberOfSubsets(i)*getNumberOfSubsets(num/i) % MOD;
                    localSum *= 2; //switch the two
                }
            }
        }
        localSum++; // itself
        
        cache.put(num, localSum % MOD);
        // System.out.println(String.format("calculated %d ==> %d", num, cache.get(num)));
        return localSum % MOD;
    }
}
*/
/*
[18,3,6,2]

[2] [3] [6] [18]
[6, 3, 2] [6, 2, 3] [18, 6, 3] [18, 3, 6]
[18, 6, 3, 2, 3] [18, 6, 3, 3, 2] [18, 3, 6, 2, 3] [18, 3, 6, 3, 2]


[45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48]
*/
