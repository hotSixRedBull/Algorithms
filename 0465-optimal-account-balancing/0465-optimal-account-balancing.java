class Solution {
    public int minTransfers(int[][] transactions) {
        int n = 12;
        int[] assets = new int[n];
        int min = transactions.length;
        for (int[] t : transactions) {
            int from = t[0];
            int to = t[1];
            int amount = t[2];
            assets[from] -= amount;
            assets[to] += amount;
        }
        
        List<Integer> pos = new ArrayList();
        List<Integer> neg = new ArrayList();
        for (int i=0; i<n; i++) {
            if (assets[i] > 0) {
                pos.add(assets[i]);
            }
            if (assets[i] < 0) {
                neg.add(-assets[i]);
            }
        }
        
        return Math.min(min, recursive(pos, 0, neg, 0));
    }
    public int recursive(List<Integer> pos, int pi, List<Integer> neg, int depth) {
        // System.out.println(String.format("recursive, pos: %s, neg: %s", pos, neg));
        if (depth >= 8) {
            return Integer.MAX_VALUE/2;
        }
        if (pi >= pos.size()) {
            return 0;
        }
        
        int min = 8;
        boolean changed = false;
        if (pos.get(pi) == 0) {
            min = Math.min(min, recursive(pos, pi+1, neg, depth+1)+1);
        }
        else {
            changed = true;
            for (int j=0; j<neg.size(); j++) {
                if (neg.get(j) == 0) {
                    continue;
                }
                if (pos.get(pi) == neg.get(j)) {
                    int tmp = pos.get(pi);
                    pos.set(pi, 0);
                    neg.set(j, 0);
                    min = Math.min(min, recursive(pos, pi+1, neg, depth+1)+1);
                    pos.set(pi, tmp);
                    neg.set(j, tmp);
                }
                else if (pos.get(pi) < neg.get(j)) {
                    int tmp = pos.get(pi);
                    pos.set(pi, 0);
                    neg.set(j, neg.get(j)-tmp);
                    min = Math.min(min, recursive(pos, pi+1, neg, depth+1)+1);
                    pos.set(pi, tmp);
                    neg.set(j, neg.get(j)+tmp);
                }
                else {
                    int tmp = neg.get(j);
                    pos.set(pi, pos.get(pi)-tmp);
                    neg.set(j, 0);
                    min = Math.min(min, recursive(pos, pi, neg, depth+1)+1);
                    pos.set(pi, pos.get(pi)+tmp);
                    neg.set(j, tmp);
                }
            }
        }
        return changed ? min : 0;
    }
}

/*
[[1,8,1],[1,0,21],[2,8,10],[3,9,20],[4,10,61],[5,11,61],[6,1,59],[7,0,60]]
[[0,1,10],[2,0,5]]
*/