class Solution {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> cnt[b]-cnt[a]);
        for (int i=0; i<26; i++) {
            if (cnt[i] != 0) {
                pq.add(i);
            }
        }
        
        int numberOfTypeNeeded = 1;
        int numberOfButtonLeft = 8;
        int result = 0;
        while (pq.size() > 0) {
            int cur = pq.poll();
            result += numberOfTypeNeeded*cnt[cur];
            numberOfButtonLeft--;
            if (numberOfButtonLeft == 0) {
                numberOfTypeNeeded++;
                numberOfButtonLeft = 8;
            }
        }

        return result;
    }
}