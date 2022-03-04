class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] arr = new double[5050];
        int target = query_row*(query_row+1)/2+query_glass;
        // System.out.println(String.format("target: %d", target));
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> levelQ = new ArrayDeque();
        q.add(0);
        levelQ.add(1);
        arr[0] = poured;
        while (q.size() > 0) {
            int cur = q.poll();
            int level = levelQ.poll();
            double water = arr[cur];
            // System.out.println(String.format("cur: %d, water: %f", cur, water));
            if (cur == target) {
                return water > 1 ? 1 : water;
            }
            if (water > 1) {
                arr[cur] = 1;
                water -= 1;
                int left = getLeft(cur, level);
                int right = getRight(cur, level);
                if (left < 5050) {
                    q.add(left);
                    levelQ.add(level+1);
                    arr[left] += water/2;
                    // System.out.println(String.format("arr[%d]: %f, +water: %f", left, arr[left]-water/2, water/2));
                }
                if (right < 5050) {
                    q.add(right);
                    levelQ.add(level+1);
                    arr[right] += water/2;
                    // System.out.println(String.format("arr[%d]: %f, +water: %f", right, arr[right]-water/2, water/2));
                }
            }
        }
        return 0;
    }
    public int getLeft(int n, int level) {
        int start = (level-1)*level/2;
        int diff = n-start;
        int nextStart = level*(level+1)/2;
        return nextStart+diff;
    }
    public int getRight(int n, int level) {
        int start = (level-1)*level/2;
        int diff = n-start;
        int nextStart = level*(level+1)/2;
        return nextStart+diff+1;
    }
}
/*
25
6
1
*/