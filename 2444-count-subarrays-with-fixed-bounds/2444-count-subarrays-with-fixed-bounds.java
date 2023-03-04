class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int prev = 0;
        TreeSet<Integer> mins = new TreeSet();
        TreeSet<Integer> maxs = new TreeSet();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                prev = i+1;
                mins = new TreeSet();
                maxs = new TreeSet();
                continue;
            }
            if (nums[i] == minK) {
                mins.add(i);
            }
            if (nums[i] == maxK) {
                maxs.add(i);
            }
            result += countSubarrays(nums, minK, maxK, prev, i, mins, maxs);
        }
        return result;
    }
    
    public long countSubarrays(int[] nums, int minK, int maxK, int start, int end, TreeSet<Integer> mins, TreeSet<Integer> maxs) {
        // System.out.println(String.format("(%d, %d), mins: %s, maxs: %s", start, end, mins, maxs));
        long result = 0;
        if (start > end) {
            return result;
        }
        if (mins.size() == 0
           || maxs.size() == 0) {
            return result;
        }
        Integer highstMin = mins.last();
        Integer highstMax = maxs.last();
        if (highstMin > highstMax) {
            Integer max = maxs.floor(highstMin);
            if (max == null) {
                return result;
            }
            int left = max-start+1;
            result += left;
            // System.out.println(String.format("%d, %d, %d", highstMin, max, result));
        }
        else {
            Integer min = mins.floor(highstMax);
            if (min == null) {
                return result;
            }
            int left = min-start+1;
            result += left;
            // System.out.println(String.format("%d, %d, %d", min, highstMax, result));
        }
        return result;
    }
}

/*
[35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913]
35054
945315
*/