class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] cache = new int[colors.length][4];
        for (int i=0; i<colors.length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE/2);
            cache[i][colors[i]] = 0;
        }
        int[] nearest = new int[4];
        Arrays.fill(nearest, Integer.MAX_VALUE/2);
        for (int i=0; i<colors.length; i++) {
            nearest[1]++;
            nearest[2]++;
            nearest[3]++;
            nearest[colors[i]] = 0;
            for (int j=1; j<4; j++) {
                cache[i][j] = Math.min(cache[i][j], nearest[j]);
            }
        }
        Arrays.fill(nearest, Integer.MAX_VALUE/2);
        for (int i=colors.length-1; i>-1; i--) {
            nearest[1]++;
            nearest[2]++;
            nearest[3]++;
            nearest[colors[i]] = 0;
            for (int j=1; j<4; j++) {
                cache[i][j] = Math.min(cache[i][j], nearest[j]);
            }
        }
        
        // printCache(cache);
        
        List<Integer> ans = new ArrayList();
        for (int[] query : queries) {
            if (cache[query[0]][query[1]] == Integer.MAX_VALUE/2) {
                ans.add(-1);
            }
            else {
                ans.add(cache[query[0]][query[1]]);
            }
        }
        return ans;
    }
    
    public void printCache(int[][] cache) {
        for (int[] c : cache) {
            System.out.println(Arrays.toString(c));
        }
    }
}