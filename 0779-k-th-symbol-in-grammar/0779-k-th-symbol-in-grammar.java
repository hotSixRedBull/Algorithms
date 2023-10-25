//saw solution
class Solution {
    public int kthGrammar(int n, int k) {
        int count = Integer.bitCount(k - 1);
        return count % 2 == 0 ? 0 : 1;
    }
}
/*
class Solution {
    public int kthGrammar(int n, int k) {
        long cur = 0;
        for (int i=1; i<n; i++) {
            long next = 0;
            int m = (int)Math.pow(2, i-1);
            for (int j=0; j<m; j++) {
                if ((cur & (1 << j)) > 0) {
                    next |= 1 << (2*j);
                } 
                else {
                    next |= 1 << (2*j+1);
                }
            }
            System.out.println(String.format("%d, %s", i+1, Long.toString(next, 2)));
            // System.out.println(next);
            cur = next;
        }
        if ((cur & (1 << k-1)) > 0) {
            return 1;
        }
        return 0;
    }
}
*/