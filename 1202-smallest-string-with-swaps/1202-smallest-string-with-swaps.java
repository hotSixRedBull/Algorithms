class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean[] used = new boolean[s.length()];
        int usedCnt = 0;
        List<List<Integer>> adj = new ArrayList();
        for (int i=0; i<s.length(); i++) {
            adj.add(new ArrayList());
        }
        for (List<Integer> pair : pairs) {
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }
        
        StringBuilder sb = new StringBuilder(s);
        while (usedCnt < s.length()) {
            Queue<Integer> q = new ArrayDeque();
            for (int i=0; i<s.length(); i++) {
                if (used[i] == false) {
                    used[i] = true;
                    usedCnt++;
                    q.add(i);
                    break;
                }
            }
            PriorityQueue<Integer> indexQ = new PriorityQueue();
            PriorityQueue<Character> charQ = new PriorityQueue();
            while (q.size() > 0) {
                int cur = q.poll();
                indexQ.add(cur);
                charQ.add(s.charAt(cur));
                List<Integer> neighbors = adj.get(cur);
                for (int nei : neighbors) {
                    if (used[nei] == false) {
                        used[nei] = true;
                        usedCnt++;
                        q.add(nei);
                    }
                }
            }
            while (indexQ.size() > 0) {
                int targetIndex = indexQ.poll();
                char targetChar = charQ.poll();
                sb.replace(targetIndex, targetIndex+1, Character.toString(targetChar));
            }
        }
        return sb.toString();
    }
}