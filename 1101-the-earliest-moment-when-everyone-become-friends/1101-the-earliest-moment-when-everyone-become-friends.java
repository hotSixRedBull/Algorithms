class Solution {
    int[] parent;
    Set<Integer> rootSet;
    public int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        rootSet = new HashSet();
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rootSet.add(i);
        }
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if (arg0[0] < arg1[0]) {
                    return -1;
                }
                else if (arg0[0] > arg1[0]) {
                    return 1;
                }
                return 0;
            }
        });
        
        // System.out.println("parent:" + Arrays.toString(parent));
        
        for (int[] log : logs) {
            union(log[1], log[2]);
            
            if (rootSet.size() == 1) {
                return log[0];
            }
        }
        
        return -1;
    }
    
    public int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }
    
    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) {
            return;
        }
        if (parA > parB) {
            int tmp = parA;
            parA = parB;
            parB = tmp;
        }
        if (rootSet.contains(parB)) {
            rootSet.remove(parB);
        }
        parent[parB] = parent[parA];
        // System.out.println(String.format("After union %d and %d, parent: ", a, b)+Arrays.toString(parent)+" set: "+rootSet);
    }
}

/* TC
[[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]]
6
[[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]]
4
[[4,1,3],[1,4,5],[6,5,6],[0,0,3],[2,2,1],[11,4,2],[5,4,6],[3,1,6],[10,5,1],[7,1,0]]
7

*/