class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList();
        if (nums.length == 0) {
            answer.add(generateRangeString(lower, upper));
        }
        else {
            if (lower < nums[0]) {
                answer.add(generateRangeString(lower, nums[0]-1));
            }
            for (int i=0; i<nums.length-1; i++) {
                if (nums[i+1] - nums[i] > 1) {  
                    answer.add(generateRangeString(nums[i]+1, nums[i+1]-1));
                }
            }
            if (nums[nums.length-1] < upper) {
                answer.add(generateRangeString(nums[nums.length-1]+1, upper));
            }
        }
        return answer;
    }
    
    static String generateRangeString(int from, int to) {
        if (from == to) {
            return Integer.toString(from);
        }
        else {
            return from + "->" + to;
        }
    }
}