class Solution {
    int n;
    int index;
    int maxSum;
    public int maxValue(int n, int index, int maxSum) {
        this.n = n;
        this.index = index;
        this.maxSum = maxSum;
        
        int lo = 1;
        int hi = maxSum;
        int max = 0;
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            if (canReachable(mid)) {
                // System.out.println(String.format("%d is reachable.", mid));
                lo = mid+1;
                max = Math.max(max, mid);
            }
            else {
                // System.out.println(String.format("%d is UNreachable.", mid));
                hi = mid-1;
            }
        }
        // System.out.println(String.format("lo: %d", lo));
        if (canReachable(lo)) {
            // System.out.println(String.format("lo: %d is reachable", lo));
            max = Math.max(max, lo);
        }
        return max;
    }
    public boolean canReachable(int a) {
        long longA = (long) a;
        long front = (long) index;
        long frontSide = 0;
        if (longA <= front) {
            frontSide += longA*(longA-1)/2;
            frontSide += front-longA+1;
        }
        else {
            frontSide += front*longA - (front*(front+1)/2);
        }
        
        long back = (long) (n-1-index);
        long backSide = 0;
        if (longA <= back) {
            backSide += longA*(longA-1)/2;
            backSide += back-longA+1;
        }
        else {
            backSide += back*longA - (back*(back+1)/2);
        }
        // System.out.println(String.format("frontSide: %d, a: %d, backSide: %d", frontSide, a, backSide));
        return (longA + frontSide + backSide) <= maxSum;
    }
}

/*
0~index-1 + index + index+1~n-1 => maxSum

4
2
6
6
1
10
10
7
1000000000
1000000
12345
1000000000
3
2
1000000000
99999999
123456
1000000000

9
5
24
*/