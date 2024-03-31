//saw solution
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] distinctCount = new int[nums.length + 1];

        int totalCount = 0;
        int left = 0;
        int right = 0;
        int currCount = 0;

        while (right < nums.length) {
            if (distinctCount[nums[right++]]++ == 0) {
                k--;
            }

            if (k < 0) {
                --distinctCount[nums[left++]];
                k++;
                currCount = 0;
            }

            if (k == 0) {
                while (distinctCount[nums[left]] > 1) {
                    --distinctCount[nums[left++]];
                    currCount++;
                }
                totalCount += (currCount + 1);
            }
        }
        return totalCount;
    }
}
/*
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int cnt = 0;
        int start=0;
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            while (map.size() > k) {
                if (map.get(nums[start]) == 1) {
                    map.remove(nums[start]);
                }
                else {
                    map.put(nums[start], map.getOrDefault(nums[start], 0)-1);
                }
                start++;
            }
            if (map.size() == k) {
                Map<Integer, Integer> cpy = new HashMap(map);
                int scpy = start;
                while (scpy < nums.length
                       && cpy.size() == k) {
                    // System.out.println(String.format("map: %s\ncpy: %s", map, cpy));
                    if (cpy.get(nums[scpy]) == 1) {
                        cpy.remove(nums[scpy]);
                    }
                    else {
                        cpy.put(nums[scpy], cpy.getOrDefault(nums[scpy], 0)-1);
                    }
                    scpy++;
                }
                scpy--;
                cnt += scpy-start+1;
            }
        }
        return cnt;
    }
}
*/