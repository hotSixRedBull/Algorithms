class Solution {
    public int countTriples(int n) {
        // int small = 3;
        // int large = 4;
        // int cnt = 0;
        // while (Math.sqrt(Math.pow(small,2)+Math.pow(large,2)) <= n) {
        //     cnt+=2;
        //     small*=2;
        //     large*=2;
        // }
        // return cnt;
        int cnt = 0;
        for (int i=1; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                double calc = Math.sqrt(Math.pow(i,2) + Math.pow(j,2));
                if (calc%1 == 0 && calc <= n) {
                    cnt+=2;
                    //System.out.println(i+","+j+","+calc);
                }
            }
        }
        return cnt;
    }
}