class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i=1; i<keysPressed.length(); i++) {
            char cur = keysPressed.charAt(i);
            int duration = releaseTimes[i]-releaseTimes[i-1];
            if (duration > maxDuration || (duration == maxDuration && ans < cur)) {
                ans = cur;
                maxDuration = duration;
            }
        }
        return ans;
    }
}