class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        List<Integer> compressed = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            if (nums[i] > 0) {
                while (i < nums.length
                       && nums[i] > 0) {
                    sum += nums[i++];
                }
                i--;
                compressed.add(sum);
            }
            else {
                compressed.add(nums[i]);
            }
        }
        for (int left = 0; left<compressed.size(); left++) {
            max = Math.max(max, compressed.get(left));
            if (compressed.get(left) < 0) {
                continue;
            }
            int localSum = compressed.get(left);
            int right = left+1;
            while (right < compressed.size()
                  && localSum+compressed.get(right) > 0) {
                localSum += compressed.get(right);
                right++;
                max = Math.max(max, localSum);
            }
        }
        return max;
    }
}