class Solution {
    public int strStr(String haystack, String needle) {
        int[] built = buildKMPArr(needle);
        int builtIndex = 0;
        for (int i=0; i<haystack.length(); i++) {
            while (builtIndex > 0
                  && haystack.charAt(i) != needle.charAt(builtIndex)) {
                builtIndex = built[builtIndex-1];
                // System.out.println(String.format("builtIndex: %d", builtIndex));
            }
            if (haystack.charAt(i) == needle.charAt(builtIndex)) {
                builtIndex++;
            }
            // System.out.println(String.format("builtIndex: %d, needle.length(): %d", builtIndex, needle.length()));
            if (builtIndex == needle.length()) {
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    public int[] buildKMPArr(String needle) {
        int n = needle.length();
        int[] dp = new int[n];
        int compareIndex = 0;
        for (int i=1; i<n; i++) {
            while (compareIndex > 0 
                   && needle.charAt(i) != needle.charAt(compareIndex)) {
                compareIndex = dp[compareIndex-1];
                // System.out.println(String.format("i=%d, compareIndex: %d", i, compareIndex));
            }
            if (needle.charAt(i) == needle.charAt(compareIndex)) {
                compareIndex++;
                dp[i] = compareIndex;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp;
    }
}

/*
"aaaaa"
"bba"
*/