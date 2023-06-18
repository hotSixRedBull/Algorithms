class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : arr2) {
            set.add(num);
        }
        // System.out.println(String.format("set:  %s", set));
        
        int n = arr1.length;
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = -2;
        }
        dp[0] = 0;
        int[] arr = new int[n+1];
        for (int i=0; i<n; i++) {
            arr[i] = arr1[i];
        }
        arr[n] = Integer.MAX_VALUE;
        // System.out.println(String.format("arr:  %s", Arrays.toString(arr)));
        for (int i=1; i<=n; i++) {
            if (arr[i] <= arr[i-1]) {
                //153, 134
                int cur = arr[i];
                int local = 0;
                int min = Integer.MAX_VALUE;
                for (int j=i-1; j>=0; j--) {
                    if (arr[j] >= cur) {
                        Integer smaller = set.lower(cur);
                        if (smaller == null) {
                            local = -1;
                            break;
                        }
                        local++;
                        cur = smaller;
                    }
                    else {
                        if (dp[j] != -1) {
                            // don't change
                            min = Math.min(min, local+dp[j]);
                        }
                        // change
                        Integer smaller = set.lower(cur);
                        if (smaller == null) {
                            local = -1;
                            break;
                        }
                        local++;
                        cur = smaller;
                    }
                }
                if (min < Integer.MAX_VALUE) {
                    if (local == -1) {
                        dp[i] = min;
                    }
                    else {
                        dp[i] = Math.min(min, local);
                    }
                }
                else {
                    dp[i] = local;
                }
            }
            else {
                int cur = arr[i];
                int local = 0;
                int min = Integer.MAX_VALUE;
                if (dp[i-1] != -1) {
                    min = dp[i-1];
                }
                //1536, 134
                for (int j=i-1; j>=0; j--) {
                    if (arr[j] >= cur) {
                        Integer smaller = set.lower(cur);
                        if (smaller == null) {
                            local = -1;
                            break;
                        }
                        local++;
                        cur = smaller;
                    }
                    else {
                        if (dp[j] != -1) {
                            // don't change
                            min = Math.min(min, local+dp[j]);
                        }
                        // change
                        Integer smaller = set.lower(cur);
                        if (smaller == null) {
                            local = -1;
                            break;
                        }
                        local++;
                        cur = smaller;
                    }
                }
                if (min < Integer.MAX_VALUE) {
                    if (local == -1) {
                        dp[i] = min;
                    }
                    else {
                        dp[i] = Math.min(min, local);
                    }
                }
                else {
                    dp[i] = local;
                }
            }
        }
        // System.out.println(String.format("dp:   %s\nn: %d", Arrays.toString(dp), n));
        if (dp[n-1] == -1
           && dp[n] != -1) {
            return dp[n];
        }
        if (dp[n-1] != -1
           && dp[n] == -1) {
            return dp[n-1];
        }
        return Math.min(dp[n-1], dp[n]);
    }
}

/*
[0,11,6,1,4,3]
[5,4,11,10,1,0]
[1,28,27,14,5,16,31,2,9,4,3,22,13,24,7,10]
[12,11,30,21,0,15,18,25,20,19,6,29,8,23,26,1,28]
[5,16,19,2,1,12,7,14,5,16]
[6,17,4,3,6,13,4,3,18,17,16,7,14,1,16]
*/