class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> q = new ArrayDeque();
        boolean[] visit = new boolean[nums.length];
        q.add(0);
        while (q.size() > 0) {
            int cur = q.poll();
            if (nums[cur] + cur >= nums.length-1) {
                return true;
            }
            if (nums[cur] == 0) {
                continue;
            }
            for (int i=cur+1; i<=cur+nums[cur]; i++) {
                if (i < nums.length
                    && visit[i] == false) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }
}