class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}
//saw solution
/*
class Solution {
    TreeMap<Integer, TreeSet<Integer>> map;
    int[] nums;
    int n;
    public int findNumberOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        map = new TreeMap();
        for (int i=0; i<nums.length; i++) {
            map.putIfAbsent(nums[i], new TreeSet());
            map.get(nums[i]).add(i);
        }
        
        List<Integer> li = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            if (li.size() == 0
               || li.get(li.size()-1) < nums[i]) {
                li.add(nums[i]);
            }
            else {
                int insertPoint = Collections.binarySearch(li, nums[i]);
                if (insertPoint < 0) {
                    insertPoint++;
                    insertPoint *= -1;
                    li.set(insertPoint, nums[i]);
                }
            }
        }
        // System.out.println(li);
        int max = li.size();
        return recursive(0, Integer.MIN_VALUE, 0, max);
    }
    
    public int recursive(int pos, int prevVal, int len, int max) {
        // System.out.println(String.format("recursive(%d,%d,%d,%d)", pos, prevVal, len, max));
        if (len == max) {
            return 1;
        }
        int result = 0;
        for (int i=pos; i<n; i++) {
            if (prevVal < nums[i]) {
                result += recursive(i+1, nums[i], len+1, max);
            }
        }
        return result;
    }
}
*/