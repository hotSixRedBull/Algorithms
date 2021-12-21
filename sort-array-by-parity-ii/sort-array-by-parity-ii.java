class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        ArrayList<Integer> needReplace = new ArrayList<>();
        Stack<Integer> odds = new Stack<>();
        Stack<Integer> evens = new Stack<>();
        while (left < right) {
            while (left < nums.length && isRightPosition(left, nums[left])) {
                left++;
            }
            while (right > 0 && isRightPosition(right, nums[right])) {
                right--;
            }
            if (left < right && left < nums.length && right > 0) {
                needReplace.add(left);
                needReplace.add(right);
                if (left % 2 == 1) {
                    evens.push(nums[left]);
                }
                else {
                    odds.push(nums[left]);
                }
                if (right % 2 == 1) {
                    evens.push(nums[right]);
                }
                else {
                    odds.push(nums[right]);
                }
                left++;
                right--;
            }
        }
        for (int i=0; i<needReplace.size(); i++) {
            int index = needReplace.get(i);
            if (index % 2 == 1) {
                nums[index] = odds.pop();
            }
            else {
                nums[index] = evens.pop();
            }
        }
        return nums;
    }
    
    public boolean isRightPosition(int pos, int val) {
        return ((pos%2 == 1) ^ (val%2 == 1)) == false;
    }
}