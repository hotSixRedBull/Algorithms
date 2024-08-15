//saw solution
class Solution {

    public int minMoves(int[][] rooks) {
        int minMoves = 0;

        Arrays.sort(rooks, (a, b) -> a[0] - b[0]);
        // Moves required to place rooks in each row
        for (int i = 0; i < rooks.length; i++) {
            minMoves += Math.abs(i - rooks[i][0]);
        }

        Arrays.sort(rooks, (a, b) -> a[1] - b[1]);
        // Moves required to place rooks in each column
        for (int i = 0; i < rooks.length; i++) {
            minMoves += Math.abs(i - rooks[i][1]);
        }

        return minMoves;
    }
}
/*
class Solution {
    public int minMoves(int[][] rooks) {
        int n = rooks.length;
        Map<Integer, List<Integer>> rpos = new HashMap();
        Map<Integer, List<Integer>> cpos = new HashMap();
        for (int i=0; i<n; i++) {
            int[] rook = rooks[i];
            rpos.putIfAbsent(rook[0], new ArrayList());
            cpos.putIfAbsent(rook[1], new ArrayList());
            rpos.get(rook[0]).add(i);
            cpos.get(rook[1]).add(i);
        }
        return min(rooks, rpos, cpos, ...)
    }
}

/*
prunning??
*/