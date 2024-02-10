//saw solution
class Solution {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        
        int twoPostsBack = k;
        int onePostBack = k * k;
        
        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (onePostBack + twoPostsBack);
            twoPostsBack = onePostBack;
            onePostBack = curr;
        }
        
        return onePostBack;
    }
}
/*
class Solution {
    public int numWays(int n, int k) {
        int[][][] cache = new int[n][k][2];
        for (int i=0; i<k; i++) {
            cache[0][i][0] = 1;
        }
        for (int index=1; index<n; index++) {
            for (int color=0; color<k; color++) {
                for (int newColor=0; newColor<k; newColor++) {
                    if (newColor == color) {
                        continue;
                    }
                    for (int series=0; series<2; series++) {
                        cache[index][color][0] += cache[index-1][newColor][series];
                    }
                }
                cache[index][color][1] = cache[index-1][color][0];
            }
        }
        int result = 0;
        for (int color=0; color<k; color++) {
            for (int series=0; series<2; series++) {
                result += cache[n-1][color][series];
            }
        }
        
        // for (int index=0; index<n; index++) {
        //     System.out.println(String.format("\"%d\": {",index));
        //     for (int color=0; color<k; color++) {
        //         System.out.println(String.format("    \"%d\": {",color));
        //         System.out.println("      "+Arrays.toString(cache[index][color]));
        //         System.out.println(String.format("    },",color));
        //     }
        //     System.out.println("},");
        // }
        return result;
    }
}
*/