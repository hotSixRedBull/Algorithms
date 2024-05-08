class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sorted = new int[n];
        for (int i=0; i<n; i++) {
            sorted[i] = score[i];
        }
        Arrays.sort(sorted);
        int left = 0;
        int right = n-1;
        while (left < right) {
            int temp = sorted[left];
            sorted[left] = sorted[right];
            sorted[right] = temp;
            left++;
            right--;
        }
        Map<Integer, String> map = new HashMap();
        if (n > 0) {
            map.put(sorted[0], "Gold Medal");
        }
        if (n > 1) {
            map.put(sorted[1], "Silver Medal");
        }
        if (n > 2) {
            map.put(sorted[2], "Bronze Medal");
        }
        for (int i=3; i<n; i++) {
            map.put(sorted[i], Integer.toString(i+1));
        }
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            answer[i] = map.get(score[i]);
        }
        return answer;
    }
}