class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] indegree = new long[n];
        for (int[] road : roads) {
            indegree[road[0]]++;
            indegree[road[1]]++;
            
        }
        List<long[]> li = new ArrayList();
        for (int i=0; i<n; i++) {
            li.add(new long[]{(long) i, indegree[i]});
        }
        Collections.sort(li, (a, b) -> Long.compare(b[1], a[1]));
        
        long result = 0;
        for (int score=n; score>=1; score--) {
            result += li.get(n-score)[1]*((long) score);
        }
        return result;
    }
}