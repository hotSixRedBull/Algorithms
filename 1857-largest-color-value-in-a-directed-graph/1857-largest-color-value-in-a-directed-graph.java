class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        int[][] c = new int[n][26];
        Queue<Integer> q = new ArrayDeque();
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                c[i][colors.charAt(i)-'a']++;
            }
        }
        
        int max = 1;
        while (q.size() > 0) {
            int cur = q.poll();
            // System.out.println(String.format("cur: %d, c: %s", cur, Arrays.toString(c[cur])));
            for (int child : map.get(cur)) {
                indegree[child]--;
                for (int i=0; i<26; i++) {
                    c[child][i] = Math.max(c[child][i], c[cur][i]);
                }
                c[child][colors.charAt(child)-'a'] = Math.max(c[child][colors.charAt(child)-'a'],
                                                              c[cur][colors.charAt(child)-'a']+1);
                max = Math.max(max, c[child][colors.charAt(child)-'a']);
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            if (indegree[i] > 0) {
                max = -1;
                break;
            }
        }
        return max;
    }
}


/*
1. starting from only 0th node? -> no.


self test cases
"abaca"
[[0,1],[0,2],[2,3],[3,4]]
"abaca"
[[0,1],[0,2]]
"abaca"
[[2,3],[3,4]]
"a"
[[0,0]]
"abaca"
[[0,1],[2,3],[3,4],[4,2]]

failed test cases
"hhqhuqhqff"
[[0,1],[0,2],[2,3],[3,4],[3,5],[5,6],[2,7],[6,7],[7,8],[3,8],[5,8],[8,9],[3,9],[6,9]]
"iivvvvv"
[[0,1],[1,2],[1,3],[2,3],[3,4],[2,4],[3,5],[1,5],[4,5],[5,6]]
"g"
[]
"nnllnzznn"
[[0,1],[1,2],[2,3],[2,4],[3,5],[4,6],[3,6],[5,6],[6,7],[7,8]]
*/