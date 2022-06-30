class Solution {
    public int minMoves2(int[] nums) {
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap();
        for (int num : nums) {
            if (freq.containsKey(num) == false) {
                freq.put(num, 0);
            }
            freq.put(num, freq.get(num)+1);
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            int midVal = localCalculate(freq, mid);
            int prev = Integer.MAX_VALUE;
            int next = Integer.MAX_VALUE;
            if (mid > lo) {
                prev = localCalculate(freq, mid-1);
            }
            if (mid < hi) {
                next = localCalculate(freq, mid+1);
            }
            if (prev < midVal) {
                hi = mid-1;
            }
            else if (next < midVal) {
                lo = mid+1;
            }
            else {
                return midVal;
            }
        }
        return localCalculate(freq, lo);
    }
    
    public int localCalculate(HashMap<Integer, Integer> freq,
                             int target) {
        int localCalculation = 0;
        for (int key2 : freq.keySet()) {
            int mul = Math.abs(key2-target);
            localCalculation += mul*freq.get(key2);
            if (localCalculation < 0) {
                break;
            }
        }
        // System.out.println(String.format("%d: %d", target, localCalculation));
        return localCalculation;
    }
}

/*
- is input sorted? no
- does input has duplicates? yes

A1. brute force, O(k*n)/O(1), k is maximum value of an element.
--> TLE
A2. counting sort O(k*n)/O(k*n)
A3. counting sort + greedy
   - value that has more count will be the point to group.
     - [1, 1, 1, 10], 1 will be destination.
     - is there any exceptions for that?
       - [1, 1, 1, 5, 10]
         - 1 : 13
         - 5 : 17
       - [1, 1, 1, 5, 5, 10]
         - 1 : 17
         - 5 : 17
         
A4. min and max? (will FAIL)
   - what if i count min and max each and change into one more bigger, smaller one?
   - for example,
     [1, 10, 2, 9]
     [2, 9, 2, 9] + 2
     [5, 5, 5, 5] + 16
     
     another eg
     [1,1,1,10]
     [5,5,5,5] + 17.. if i set 1, it would be 9...

*/