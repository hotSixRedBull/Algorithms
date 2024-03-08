class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int max = 0;
        for (int i=0; i<101; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }
        int numberOfMaxFreq = 0;
        for (int i=0; i<101; i++) {
            if (cnt[i] == max) {
                numberOfMaxFreq++;
            }
        }
        return max*numberOfMaxFreq;
    }
}