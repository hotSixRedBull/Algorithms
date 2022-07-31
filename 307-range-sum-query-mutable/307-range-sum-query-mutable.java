class NumArray {

    int[] fenwick;
    int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        fenwick = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            int index = i+1;
            // System.out.println(String.format("[start] initialize %dth", index));
            while (index < fenwick.length) {
                // System.out.println(String.format("initialize %dth with %d", index, nums[i]));
                fenwick[index] += nums[i];
                index += index & (-index);
            }
            // System.out.println(String.format("fenwick: %s", Arrays.toString(fenwick)));
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        // System.out.println(String.format("diff(%d) = val(%d) - nums[index](%d)", diff, val, nums[index]));
        index++;
        // System.out.println(String.format("[start] update %dth", index));
        while (index < fenwick.length) {
            // System.out.println(String.format("update %dth with %d", index, diff));
            fenwick[index] += diff;
            index += index & (-index);
        }
        // System.out.println(String.format("fenwick: %s", Arrays.toString(fenwick)));
    }
    
    public int sumRange(int left, int right) {
        // System.out.println(String.format("[sumRange] %d to %d", left, right));
        return sumFromZero(right+1)-sumFromZero(left);
    }
    
    public int sumFromZero(int end) {
        // System.out.println(String.format("[start] sumFromZero %dth", end));
        if (end <= 0) {
            return 0;
        }
        int ret = 0;
        while (end > 0) {
            // System.out.println(String.format("+sumFromZero %dth", end));
            ret += fenwick[end];
            end -= end & (-end);
        }
        // System.out.println(String.format(">>>result: %d", ret));
        return ret;
    }
}

/*
001 => 1개의 합, 1의 값
010 => 2개의 합, 1, 2의 값
011 => 1개의 합, 3의 값
[1, 4, 5]


[
"NumArray",
"update",
"update",
"update",
"sumRange",
"update",
"sumRange",
"update",
"sumRange",
"sumRange",
"update"
]
[
[[7,2,7,2,0]],
[4,6], //[[7,2,7,2,6]],
[0,2], //[[2,2,7,2,6]],
[0,9], //[[9,2,7,2,6]],
       [4,4], 
[3,8], //[[9,2,7,8,6]],
       [0,4],
[4,1], //[[9,2,7,8,1]],
       [0,3],
       [0,4],
[0,4] //[[4,2,7,8,1]],
]
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */