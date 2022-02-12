class Solution {
    public int knightDialer(int n) {
        List<List<Integer>> adj = new ArrayList();
        adj.add(Arrays.asList(4, 6));
        adj.add(Arrays.asList(8, 6));
        adj.add(Arrays.asList(7, 9));
        adj.add(Arrays.asList(4, 8));
        adj.add(Arrays.asList(0, 3, 9));
        adj.add(new ArrayList());
        adj.add(Arrays.asList(1, 7, 0));
        adj.add(Arrays.asList(2, 6));
        adj.add(Arrays.asList(1, 3));
        adj.add(Arrays.asList(2, 4));
        
        int[] cur = new int[10];
        long sum = 10;
        long modulo = (long) Math.pow(10, 9) + (long) 7;
        Arrays.fill(cur, 1);
        for (int i=2; i<=n; i++) {
            sum = 0;
            int[] prev = Arrays.copyOf(cur, 10);
            for (int j=0; j<10; j++) {
                cur[j] = 0;
                List<Integer> list = adj.get(j);
                for (int neighbor : list) {
                    cur[j] += prev[neighbor];
                    cur[j] %= modulo;
                }
                sum += cur[j];
                sum %= modulo;
            }
        }
        
        return (int) sum;
    }
}

/*
1 -> 8, 6
2 -> 7, 9
3 -> 4, 8
4 -> 0, 3, 9
5 -> X
6 -> 1, 7, 0
7 -> 2, 6
8 -> 1, 3
9 -> 2, 4
0 -> 4, 6
*/