class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> cnt1 = new HashMap();
        HashMap<Character, Integer> cnt2 = new HashMap();
        for (int i=0; i<word1.length(); i++) {
            cnt1.put(word1.charAt(i), cnt1.getOrDefault(word1.charAt(i), 0)+1);
        }
        for (int i=0; i<word2.length(); i++) {
            cnt2.put(word2.charAt(i), cnt2.getOrDefault(word2.charAt(i), 0)+1);
        }
        // System.out.println(String.format("cnt1: %s\ncnt2: %s\n",cnt1,cnt2));
        if (cnt1.size() != cnt2.size()
            || cnt1.keySet().containsAll(cnt2.keySet()) == false) {
            return false;
        }
        
        PriorityQueue<Integer> pq1 = new PriorityQueue();
        PriorityQueue<Integer> pq2 = new PriorityQueue();
        for (char key : cnt1.keySet()) {
            pq1.add(cnt1.get(key));
        }
        for (char key : cnt2.keySet()) {
            pq2.add(cnt2.get(key));
        }
        // System.out.println(String.format("pq1: %s\npq2: %s\n",pq1,pq2));
        while (pq1.size() > 0) {
            if (pq1.peek().intValue() != pq2.peek().intValue()) {
                return false;
            }
            pq1.poll();
            pq2.poll();
        }
        return true;
    }
}