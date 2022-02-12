/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        Queue<List<Integer>> rangeQ = new ArrayDeque();
        rangeQ.add(Arrays.asList(bottomLeft[0], topRight[0]));
        Queue<Integer> candidates = new ArrayDeque();
        while (rangeQ.size() > 0) {
            List<Integer> range = rangeQ.poll();
            //System.out.println("range: "+range);
            int start = range.get(0);
            int end = range.get(1);
            if (start == end) {
                candidates.add(start);
                continue;
            }
            int mid = start-(start-end)/2;
            int[] s = {start, 0};
            int[] m = {mid, 1000};
            if (sea.hasShips(m, s)) {
                rangeQ.add(Arrays.asList(start, mid));
            }
            m[0] = mid+1;
            m[1] = 0;
            int[] e = {end, 1000};
            if (sea.hasShips(e, m)) {
                rangeQ.add(Arrays.asList(mid+1, end));
            }
        }
        
        // System.out.println("candidates: " + candidates);
        if (candidates.size() >= 10) {
            return 10;
        }
        
        int cnt = 0;
        for (int candidate : candidates) {
            rangeQ = new ArrayDeque();
            rangeQ.add(Arrays.asList(bottomLeft[1], topRight[1]));
            while (rangeQ.size() > 0) {
                List<Integer> range = rangeQ.poll();
                int start = range.get(0);
                int end = range.get(1);
                if (start == end) {
                    cnt++;
                    continue;
                }
                int mid = start-(start-end)/2;
                int[] s = {candidate, start};
                int[] m = {candidate, mid};
                if (sea.hasShips(m, s)) {
                    rangeQ.add(Arrays.asList(start, mid));
                }
                m[0] = candidate;
                m[1] = mid+1;
                int[] e = {candidate, end};
                if (sea.hasShips(e, m)) {
                    rangeQ.add(Arrays.asList(mid+1, end));
                }
            }
        }
        
        return cnt;
    }
}