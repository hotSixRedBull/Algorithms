class UnionFind {
    int[] parent;
    int[] rank;
    int size;
    public UnionFind(int siz) {
        parent = new int[siz];
        rank = new int[siz];
        size = siz;
        for (int i=0; i<siz; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }
    public int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    public void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return;
        }
        if (rank[aParent] < rank[bParent]) {
            parent[bParent] = aParent;
            rank[aParent] += rank[bParent];
        }
        else {
            parent[aParent] = bParent;
            rank[bParent] += rank[aParent];
        }
        
    }
}
class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // template for connecting edge as a adjacent list
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], val -> new ArrayList()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val -> new ArrayList()).add(edge[0]);
        }
        
        // map is for value to nodeIndex
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        for (int i=0; i<vals.length; i++) {
            map.computeIfAbsent(vals[i], val -> new ArrayList()).add(i);
        }
        
        // make union find
        UnionFind uf = new UnionFind(vals.length);
        int goodPaths = 0;
        
        for (int value : map.keySet()) {        //start from smaller values
            for (int node : map.get(value)) {   //each value node
                if (!adj.containsKey(node)) {
                    continue;
                }
                for (int nei : adj.get(node)) {  //neighbor is smaller than current
                    if (vals[node] >= vals[nei]) {
                        uf.union(node, nei);     //union
                    }
                }
            }
            
            Map<Integer, Integer> group = new HashMap();
            for (int u : map.get(value)) { //count how many nodes are in a same component
                group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
            }
            
            for (int key : group.keySet()) {//for each groups, count goodPaths
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }
        return goodPaths;
    }
}