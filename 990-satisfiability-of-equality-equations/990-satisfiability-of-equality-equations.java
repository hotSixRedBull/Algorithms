class UnionFind {
    int[] p;
    int[] rank;
    public UnionFind() {
        p = new int[26];
        Arrays.fill(p, -1);
        rank = new int[26];
        Arrays.fill(rank, 1);
    }
    public void union(char a, char b) {
        int aInd = find(a);
        int bInd = find(b);
        if (rank[aInd] < rank[bInd]) {
            p[aInd] = p[bInd];
            rank[aInd] += rank[bInd];
        }
        else {
            p[bInd] = p[aInd];
            rank[bInd] += rank[aInd];
        }
    }
    public int find(char val) {
        int index = val-'a';
        if (p[index] == -1) {
            return -1;
        }
        else if (p[index] == index) {
            return index;
        }
        else {
            return p[index] = p[p[index]];
        }
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        Arrays.sort(equations, new Comparator<String>() {
           @Override
            public int compare(String a, String b) {
                if (a.charAt(1) == b.charAt(1)) {
                    if (a.charAt(0) == b.charAt(0)) {
                        return a.charAt(3)-b.charAt(3);
                    }
                    return a.charAt(0)-b.charAt(0);
                }
                else if (a.charAt(1) == '!') {
                    return 1;
                }
                else if (b.charAt(1) == '!') {
                    return -1;
                }
                return 0;
            }
        });
        // System.out.println(String.format("sorted: %s", Arrays.deepToString(equations)));
        
        UnionFind uf = new UnionFind();
        Set<Character> used = new HashSet();
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                if (used.contains(e.charAt(0)) == false) {   
                    uf.p[e.charAt(0)-'a'] = e.charAt(0)-'a';
                    used.add(e.charAt(0));
                }
                if (used.contains(e.charAt(3)) == false) {   
                    uf.p[e.charAt(3)-'a'] = e.charAt(3)-'a';
                    used.add(e.charAt(3));
                }
                uf.union(e.charAt(0), e.charAt(3));
            }
            else {
                if (e.charAt(0) == e.charAt(3)) {
                    return false;
                }
                
                if (uf.find(e.charAt(0)) == uf.find(e.charAt(3))
                   && used.contains(e.charAt(0))
                   && used.contains(e.charAt(3))) {
                    return false;
                }
            }
        }
        return true;
    }
}


/*
sort and unionFind
Time complexity = O(nlogn) + O(logn) => O(nlogn)

["a==b","b!=a"]
["b==a","a==b"]

["c==c","b==d","x!=z"]
["a!=a"]
*/