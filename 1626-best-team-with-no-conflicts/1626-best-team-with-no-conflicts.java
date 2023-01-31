class Solution {
    int[][] cache;
    List<int[]> li;
    public int bestTeamScore(int[] scores, int[] ages) {
        cache = new int[1001][1001];
        li = new ArrayList();
        li.add(new int[]{-1, -1});
        for (int i=0; i<scores.length; i++) {
            li.add(new int[]{ages[i], scores[i]});
        }
        Collections.sort(li, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        // System.out.println(Arrays.deepToString(li.toArray(new int[0][2])));
        return recursive(1, 0, 0);
    }
    
    public int recursive(int cur, int prev, int sum) {
        if (cur == li.size()) {
            return 0;
        }
        if (cache[cur][prev] != 0) {
            return cache[cur][prev];
        }
        int max = Integer.MIN_VALUE;
        if (li.get(prev)[0] == li.get(cur)[0]
            || li.get(prev)[1] <= li.get(cur)[1]) {
            max = Math.max(max, li.get(cur)[1]+recursive(cur+1, cur, sum));
        }
        max = Math.max(max, recursive(cur+1, prev, sum));
        
        
        cache[cur][prev] = max;
        // System.out.println(String.format("recursive(%d, %d, %d): %d", cur, prev, sum, max));
        return max;
    }
}