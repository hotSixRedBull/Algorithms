class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsCpy = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            numsCpy[i] = nums[i];
        }
        Arrays.sort(numsCpy);
        int i = 0;
        int j = nums.length-1;
        while (i < nums.length && nums[i] == numsCpy[i]) {
            i++;
        }
        while (j >= 0 && nums[j] == numsCpy[j]) {
            j--;
        }
        // System.out.println(Arrays.toString(numsCpy));
        // System.out.println("i: "+i+",j: "+j);
        if (i < j) {
            return j-i+1;
        }
        else {
            return 0;
        }
    }
}