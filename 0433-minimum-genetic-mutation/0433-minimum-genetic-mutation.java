class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<Integer, List<Integer>> neighbors = new HashMap();
        for (int i=0; i<bank.length; i++) {
            neighbors.put(i, new ArrayList());
        }
        for (int i=0; i<bank.length; i++) {
            for (int j=i+1; j<bank.length; j++) {
                if (countDiff(bank[i], bank[j]) == 1) {
                    neighbors.get(i).add(j);
                    neighbors.get(j).add(i);
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque();
        boolean[] visited = new boolean[bank.length];
        for (int i=0; i<bank.length; i++) {
            if (countDiff(start, bank[i]) == 1) {
                q.add(new int[]{i, 1});
            }
        }
        int min = Integer.MAX_VALUE;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int pos = cur[0];
            int len = cur[1];
            if (bank[pos].equals(end)) {
                min = Math.min(min, len);
            }
            for (int nei : neighbors.get(pos)) {
                if (visited[nei] == false) {
                    visited[nei] = true;
                    q.add(new int[]{nei, len+1});
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public int countDiff(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}