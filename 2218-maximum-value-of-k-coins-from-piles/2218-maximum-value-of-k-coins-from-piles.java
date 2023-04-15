class Solution {
    int n;
    int[][] cache;
    List<List<Integer>> p;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        cache = new int[n][k+1];
        this.p = piles;
        int result = recursive(0, k);
        for (int i=0; i<n; i++) {
            for (int j=0; j<=k; j++) {
                cache[i][j] = -1;
            }
        }
        recursive(0, k);
        return cache[0][k];
    }
    
    public int recursive(int cur, int k) {
        if (cur == n) {
            if (k > 0) {
                return -1;
            }
            return 0;
        }
        
        if (cache[cur][k] != -1) {
            return cache[cur][k];
        }
        
        int max = recursive(cur+1, k);
        int acc = 0;
        for (int i=0; i<Math.min(p.get(cur).size(), k); i++) {
            acc += p.get(cur).get(i);
            // System.out.println(String.format("acc: %d, recursive(cur+1, k-i-1): %d",acc, recursive(cur+1, k-i-1)));
            max = Math.max(max, acc + recursive(cur+1, k-i-1));
        }
        cache[cur][k] = max;
        return max;
    }
}