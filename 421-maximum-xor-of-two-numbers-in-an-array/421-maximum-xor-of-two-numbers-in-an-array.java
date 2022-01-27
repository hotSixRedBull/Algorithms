class Solution {
    public int findMaximumXOR(int[] nums) {
        //sort
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        
        int hBit = Integer.highestOneBit(nums[nums.length-1]);
        //Search candidates
        List<Integer> candidates = new ArrayList<>();
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] < hBit) {
                break;
            }
            candidates.add(nums[i]);
            // System.out.println("candidate: "+Integer.toBinaryString(nums[i]));
        }
        // System.out.println("candidates: "+candidates);
        
        int max = 0;
        for (int candidate : candidates) {
            boolean op = false;
            String str = Integer.toBinaryString(candidate);
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) == '0') {
                    int target = 1 << (str.length()-1-i);
                    // System.out.println("target: "+target);
                    int localMax = 0;
                    
                    int lo=0;
                    int hi=nums.length-1;
                    while (lo < hi) {
                        int mid = lo - (lo-hi)/2;
                        if (nums[mid] < target) {
                            lo = mid+1;
                        }
                        else {
                            hi = mid;
                        }
                    }
                    
                    int end = target << 1;
                    while (lo < nums.length && nums[lo] < end) {
                        localMax = Math.max(localMax, nums[lo]^candidate);
                        lo++;
                    }
                    
                    if (localMax != 0) {
                        max = Math.max(max, localMax);
                        op = true;
                        break;
                    }
                }
            }
            
            if (!op) {
                // System.out.println("cases like 1111");
                for (int i=1; i<=str.length(); i++) {
                    long target = 1 << i;
                    // System.out.println("target: "+target);
                    int localMax = 0;
                    
                    int lo=0;
                    int hi=nums.length-1;
                    while (lo < hi) {
                        int mid = lo - (lo-hi)/2;
                        if (nums[mid] < target) {
                            lo = mid+1;
                        }
                        else {
                            hi = mid;
                        }
                    }
                    
                    long end = target << 1;
                    while (lo < nums.length && nums[lo] < end) {
                        localMax = Math.max(localMax, nums[lo]^candidate);
                        lo++;
                    }
                    
                    if (localMax != 0) {
                        max = Math.max(max, localMax);
                        op = true;
                        break;
                    }
                }
            }
            
            //check 0
            if (!op) {
                int lo = 0;
                int hi = nums.length-1;
                while (lo < hi) {
                    int mid = lo - (lo-hi)/2;
                    if (nums[mid] < 0) {
                        lo = mid+1;
                    }
                    else {
                        hi = mid;
                    }
                }
                if (nums[lo] < 1) {
                    max = Math.max(max, candidate);
                    op = true;
                }
            }
            
            
            //check largest target
            if (!op) {
                int target = Integer.highestOneBit(candidate);
                int lo = 0;
                int hi = nums.length-1;
                while (lo < hi) {
                    int mid = lo - (lo-hi)/2;
                    if (nums[mid] < target) {
                        lo = mid+1;
                    }
                    else {
                        hi = mid;
                    }
                }
                // System.out.println("lo: "+lo);
                int end = target << 1;
                while (lo < nums.length && nums[lo] < end) {
                    max = Math.max(max, nums[lo]^candidate);
                    lo++;
                }
            }
        }
        
        return max;
    }
}

/*
[3,10,5,25,2,8]
[14,70,53,83,49,91,36,80,92,51,66,70]
[14,15,9,3,2]
[2147483647,2147483646,2147483645]

*/