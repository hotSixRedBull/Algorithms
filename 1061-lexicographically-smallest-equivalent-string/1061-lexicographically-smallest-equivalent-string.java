class UnionFind {
    static int size = 26;
    int[] p;
    public UnionFind() {
        p = new int[size];
        for (int i=0; i<size; i++) {
            p[i] = i;
        }
    }
    
    public int find(char c) {
        int cInt = c - 'a';
        // System.out.println(String.format("before find(%c): %d, array: %s",c, p[cInt], Arrays.toString(p)));
        if (p[cInt] == cInt) {
            return cInt;
        }
        p[cInt] = p[p[cInt]];
        // System.out.println(String.format("after find(%c) = %d, array: %s",c, p[cInt], Arrays.toString(p)));
        return p[cInt];
    }
    
    public void union(char aChar, char bChar) {
        int aParent = find(aChar);
        int bParent = find(bChar);
        if (aParent < bParent) {
            p[bParent] = aParent;
        }
        else {
            p[aParent] = bParent;
        }
        // System.out.println(String.format("union(%c,%c): %s", aChar, bChar, Arrays.toString(p)));
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for (int i=0; i<s1.length(); i++) {
            uf.union(s1.charAt(i), s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<baseStr.length(); i++) {
            sb.append((char)(uf.find(baseStr.charAt(i))+'a'));
        }
        return sb.toString();
    }
}