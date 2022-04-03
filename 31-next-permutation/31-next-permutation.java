class Solution {
    public void nextPermutation(int[] nums) {
        subProblem(nums, 0);
        return;
    }
    
    
    public static void subProblem(int[] nums, int s) {
        if (s > nums.length) {
            return;
        }
        
        if (nums.length == 1) {
            return;
        }
        
        int start = s;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i=start; i<nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        // System.out.println(String.format("max: %d, maxIndex: %d", max, maxIndex));
        if (maxIndex == nums.length-1) {
            int tmp = nums[nums.length-1];
            nums[nums.length-1] = nums[nums.length-2];
            nums[nums.length-2] = tmp;
            return;
        }
        
        else {
            //내림차순 확인
            boolean decreasing = true;
            int decIndex = -1;
            for (int i=maxIndex; i<nums.length-1; i++) {
                if (nums[i] < nums[i+1]) {
                    decIndex = i;
                    decreasing = false;
                    break;
                }
            }
            
            //내림차순이면, 앞의 자리가 바뀌어야 함
            if (decreasing) {
                // System.out.println("내림차순");
                if (maxIndex == 0) {
                    // System.out.println("맨앞이 젤큼");
                    Arrays.sort(nums);
                }
                else {
                    // System.out.println("앞에껄 바꿔");
                    changeFront(nums, maxIndex);
                }
            }
            //내림차순이 아니면, 뒤의 것에 대해 부분문제 수행
            else {
                // System.out.println("안내림차순");
                subProblem(nums, maxIndex+1);
            }
        }
    }
    
    public static void changeFront(int[] nums, int pos) {
        int target = nums[pos-1];
        // System.out.println(String.format("target : %d", target));
        int minIndex = pos-1;
        int min = Integer.MAX_VALUE;
        for (int i=pos; i<nums.length; i++) {
            if (nums[i] > target) {
                min = Math.min(min, nums[i]);
                minIndex = i;
            }
        }
        // System.out.println(String.format("min : %d", min));
        int tmp = nums[pos-1];
        nums[pos-1] = min;
        nums[minIndex] = tmp;
        sort(nums, pos);
    }

    
    public static void sort(int[] nums, int start) {
        int[] sorted = new int[nums.length-start];
        for (int i=0; i<sorted.length; i++) {
            sorted[i] = nums[i+start];
        }
        Arrays.sort(sorted);
        for (int i=0; i<sorted.length; i++) {
            nums[i+start] = sorted[i];
        }
    }
}