class UnionFind {
    int[] p;
    int[] r;
    public UnionFind(int siz) {
        p = new int[siz];
        r = new int[siz];
        for (int i=0; i<siz; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }
    
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        if (r[pa] < r[pb]) {
            p[pb] = pa;
            r[pa] += r[pb];
        }
        else {
            p[pa] = pb;
            r[pb] += r[pa];
        }
    }
    
    public int find(int a) {
        if (p[a] == a) {
            return a;
        }
        int cur = a;
        while (p[cur] != cur) {
            cur = p[cur];
        }
        return p[a] = cur;
    }
    
    public int getNumberOfGroup() {
        Set<Integer> set = new HashSet();
        for (int i=0; i<p.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }
}

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int d = diff(strs[i], strs[j]);
                if (d == 2
                   || d == 0) {
                    uf.union(i,j);
                }
            }
        }
        return uf.getNumberOfGroup();
    }
    public int diff(String a, String b) {
        int result = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}

/*
["abc","abc"]
*/