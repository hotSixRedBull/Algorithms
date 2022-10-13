class Solution {
    public int largestPerimeter(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(b,a);
            }
        }).mapToInt(Integer::intValue).toArray();
        // System.out.println(Arrays.toString(nums));
        Queue<Integer> q = new ArrayDeque();
        q.offer(nums[0]);
        q.offer(nums[1]);
        q.offer(nums[2]);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i=3; i<nums.length; i++) {
            if (sum > q.peek()*2) {
                break;
            }
            sum -= q.poll();
            sum += nums[i];
            q.add(nums[i]);
        }
        if (sum <= q.peek()*2) {
            return 0;
        }
        else {
            return sum;
        }
    }
}

/*
A1. sort

A2. pq?
I can't find a way to remove minimum value on heap.
the logic is,
- add until size 3
- if size is 3,
  - add another number
  - pop the min one if the largest one can make triangle.
  - pop the max one if the largest can't make a triangle.
*/