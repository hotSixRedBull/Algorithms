class Solution {
    public int minSteps(int n) {
        int[] cache = new int[n+1];
        for (int num=2; num<=n; num++) {
            cache[num] = num; //copy 1, paste n-1
            int end = (int) Math.floor(Math.sqrt(num));
            for (int div=2; div<=end; div++) {
                if (num % div != 0) {
                    continue;
                }
                cache[num] = Math.min(cache[num], cache[num/div]+div);
            }
        }
        return cache[n];
    }
}

/*
3
1
1000
965
986
111
113
119
911
*/