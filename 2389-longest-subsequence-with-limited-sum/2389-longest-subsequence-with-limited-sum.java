class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = queries.length;
        int[] answers = new int[m];
        for (int i=0; i<m; i++) {
            int sum = 0;
            int query = queries[i];
            int cnt = 0;
            boolean broken = false;
            for (int num : nums) {
                sum += num;
                cnt++;
                if (sum > query) {
                    broken = true;
                    break;
                }
            }
            answers[i] = broken ? cnt-1 : cnt;
        }
        return answers;
    }
}