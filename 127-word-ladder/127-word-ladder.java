class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> adj = new HashMap();
        adj.put(beginWord, new ArrayList());
        for (int i=0; i<wordList.size(); i++) {
            String ith = wordList.get(i);
            if (getDiff(beginWord, ith) == 1) {
                adj.get(beginWord).add(ith);
            }
            for (int j=i+1; j<wordList.size(); j++) {
                String jth = wordList.get(j);
                if (getDiff(ith, jth) == 1) {
                    if (!adj.containsKey(ith)) {
                        adj.put(ith, new ArrayList());
                    }
                    adj.get(ith).add(jth);
                    if (!adj.containsKey(jth)) {
                        adj.put(jth, new ArrayList());
                    }
                    adj.get(jth).add(ith);
                }
            }
        }
        
        
        Queue<String> q = new ArrayDeque();
        Queue<Integer> distQ = new ArrayDeque();
        Queue<Set<String>> visited = new ArrayDeque();
        q.add(beginWord);
        distQ.add(1);
        visited.add(new HashSet());
        int ans = Integer.MAX_VALUE;
        while (q.size() > 0) {
            String cur = q.poll();
            int dist = distQ.poll();
            Set<String> visit = visited.poll();
            //System.out.println(String.format("cur: %s, dist: %d, visit: ", cur, dist) + visit);
            if (cur.equals(endWord)) {
                ans = dist;
                break;
            }
            List<String> candidates = adj.getOrDefault(cur, new ArrayList());
            if (candidates.size() == 0) {
                continue;
            }
            for (String candidate : candidates) {
                if (!visit.contains(candidate)) {
                    q.add(candidate);
                    distQ.add(dist+1);
                    visit.add(candidate);
                    visited.add(visit);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    public int getDiff(String s1, String s2) {
        int cnt = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}