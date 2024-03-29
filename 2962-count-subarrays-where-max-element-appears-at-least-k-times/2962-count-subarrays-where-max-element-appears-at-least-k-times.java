class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        TreeMap<Integer, List<Integer>> cnt = new TreeMap();
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int i=0;
        for (int j=0; j<nums.length; j++) {
            if (cnt.containsKey(nums[j]) == false) {
                cnt.put(nums[j], new ArrayList());
            }
            List<Integer> li = cnt.get(nums[j]);
            li.add(j);
            cnt.put(nums[j], li);
            if (cnt.containsKey(max)
               && cnt.get(max).size() >= k) {
                List<Integer> maxList = cnt.get(max);
                int numberOfCombination = maxList.get(maxList.size()-k)+1;
                // System.out.println(numberOfCombination);
                result += numberOfCombination;
            }
        }
        return result;
    }
}

/*
[1,3,2,3,3]
2
[1,4,2,1]
3
[1,3,2,3,3,2]
2
[1,3,2,3,3,2,2]
2
[1,3,2,3,3]
3
[1,3,2,3,3,2]
3
[1,3,2,3,3,2,2]
3
[28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49]
1
*/