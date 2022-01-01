class Solution {
    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> hashmap = new HashMap<>();
        
        Queue<String> q = new ArrayDeque<>();
        Queue<Integer> lengthQ = new ArrayDeque<>();
        for (String word : words) {
            List<String> list = hashmap.getOrDefault(word.length(), new ArrayList<>());
            list.add(word);
            q.add(word);
            lengthQ.add(1);
            hashmap.put(word.length(), list);
        }
        
        int ans = 1;
        HashMap<String, Integer> pruningMap = new HashMap<>();
        while (q.size() > 0) {
            String cur = q.poll();
            int length = lengthQ.poll();
            if (pruningMap.containsKey(cur) && length <= pruningMap.get(cur)) {
                continue;
            }
            pruningMap.put(cur, length);
            ans = Math.max(ans, length);
            if (!hashmap.containsKey(cur.length()+1)) {
                continue;
            }
            List<String> candidates = hashmap.get(cur.length()+1);
            for (String candidate : candidates) {
                if (isPredecessor(cur, candidate)) {
                    q.add(candidate);
                    lengthQ.add(length+1);
                }
            }
        }
        
        return ans;
    }
    public boolean isPredecessor(String a, String b) {
        int j = 0;
        int cnt = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(j)) {
                if (cnt != 0) {
                    return false;
                }
                else {
                    cnt++;
                    i--;
                }
            }
            j++;
        }
        return true;
    }
}